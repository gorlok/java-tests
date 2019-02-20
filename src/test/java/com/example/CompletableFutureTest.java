package com.example;

import static java.util.concurrent.CompletableFuture.allOf;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

// https://www.baeldung.com/java-completablefuture
public class CompletableFutureTest {

	@Test
	void competableFutureWithTimeoutTest() throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(30 * 1000); // wait 30 seconds
			completableFuture.complete("Hello");
			return null;
		});

		// CompletableFuture<String> newOne = completableFuture.orTimeout(10,
		// TimeUnit.SECONDS);
		CompletableFuture<String> newOne = 
				completableFuture.completeOnTimeout("value en case of timeout", 5, TimeUnit.SECONDS);

		String result = newOne.get();
		// assertEquals("Hello", result);
		assertEquals("value en case of timeout", result);
	}

	public Future<String> calculateAsyncWithCancellation() throws InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(500);
			completableFuture.cancel(false);
			return null;
		});

		return completableFuture;
	}

	@Test
	void competableFutureWithCancelTest() throws Exception {
		Future<String> future = calculateAsyncWithCancellation();

		assertThrows(CancellationException.class, () -> future.get());
	}

	@Test
	void competableFutureWithSupplyAsyncTest() throws Exception {
		CompletableFuture<String> future = supplyAsync(() -> "Hello");

		assertEquals("Hello", future.get());
	}

	@Test
	void competableFutureAsyncResultsTest() throws Exception {
		CompletableFuture<String> completableFuture = supplyAsync(() -> "Hello");

		CompletableFuture<String> future = completableFuture.thenApply(s -> s + " World");

		assertEquals("Hello World", future.get());
	}

	@Test
	void comptableFutureAsyncAcceptTest() throws Exception {
		CompletableFuture<String> completableFuture = supplyAsync(() -> "Hello");

		CompletableFuture<Void> future = completableFuture
				.thenAccept(s -> System.out.println("Computation returned: " + s));

		future.get();
	}

	@Test
	void competableFutureAsyncRunTest() throws Exception {
		CompletableFuture<String> completableFuture = supplyAsync(() -> "Hello");

		CompletableFuture<Void> future = completableFuture
				.thenRun(() -> System.out.println("Computation finished."));

		future.get();
	}

	@Test
	void competableFutureAsyncCombining1Test() throws Exception {
		CompletableFuture<String> completableFuture = supplyAsync(() -> "Hello")
				.thenCompose(s -> supplyAsync(() -> s + " World"));

		assertEquals("Hello World", completableFuture.get());
	}

	@Test
	void competableFutureAsyncCombining2Test() throws Exception {
		CompletableFuture<String> completableFuture = supplyAsync(() -> "Hello")
				.thenCombine(supplyAsync(() -> " World"), (s1, s2) -> s1 + s2);

		assertEquals("Hello World", completableFuture.get());
	}

	@Test
	void competableFutureAsyncCombining3Test() throws Exception {
		CompletableFuture<Void> future = supplyAsync(() -> "Hello")
				.thenAcceptBoth(supplyAsync(() -> " World"),
				(s1, s2) -> System.out.println(s1 + s2));

		future.get();
	}
	
	@Test
	void competableFutureAsyncAllOfTest() throws Exception {
		CompletableFuture<String> future1 = supplyAsync(() -> "Hello");
		CompletableFuture<String> future2 = supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3 = supplyAsync(() -> "World");

		CompletableFuture<Void> combinedFuture = 
				allOf(future1, future2, future3);
		 
		// ...
		 
		combinedFuture.get();
		 
		assertTrue(future1.isDone());
		assertTrue(future2.isDone());
		assertTrue(future3.isDone());
	}
	
	@Test
	void competableFutureAsyncJoinTest() throws Exception {
		CompletableFuture<String> future1 = supplyAsync(() -> "Hello");
		CompletableFuture<String> future2 = supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3 = supplyAsync(() -> "World");

		String combined = Stream.of(future1, future2, future3)
				.map(CompletableFuture::join)
				.collect(Collectors.joining(" "));

		assertEquals("Hello Beautiful World", combined);
	}
	
	@SuppressWarnings("unused")
	@Test
	void competableFutureAsyncExceptionTest() throws Exception {
		String name = null;
		 
		// ...
		 
		CompletableFuture<String> completableFuture
		  =  supplyAsync(() -> {
		      if (name == null) {
		          throw new RuntimeException("Computation error!");
		      }
		      return "Hello, " + name;
		  }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
		 
		assertEquals("Hello, Stranger!", completableFuture.get());
	}
	
	@Test
	void competableFutureAsyncApplyTest() throws Exception {
		CompletableFuture<String> completableFuture = supplyAsync(() -> "Hello");
		 
		CompletableFuture<String> future = completableFuture
				.thenApplyAsync(s -> s + " World");

		assertEquals("Hello World", future.get());
	}
	
}

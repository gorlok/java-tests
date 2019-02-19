package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class CompletableFutureTest {
	
	@Test
	void competableFutureTest() 
	throws InterruptedException, ExecutionException {
	    CompletableFuture<String> completableFuture 
	      = new CompletableFuture<>();
	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(30 * 1000); // wait 30 seconds
	        completableFuture.complete("Hello");
	        return null;
	    });		
		
	    //CompletableFuture<String> newOne = completableFuture.orTimeout(10, TimeUnit.SECONDS);
	    CompletableFuture<String> newOne = completableFuture.completeOnTimeout("value en case of timeout", 5, TimeUnit.SECONDS);
	    
	    String result = newOne.get();
	    //assertEquals("Hello", result);
	    assertEquals("value en case of timeout", result);
	}

}

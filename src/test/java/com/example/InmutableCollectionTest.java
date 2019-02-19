package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class InmutableCollectionTest {

	private Set<String> createImmutableSetOld() {
		Set<String> names = new HashSet<>();
		names.add("John");
		names.add("George");
		names.add("Betty");

		return Collections.unmodifiableSet(names);
	}

	private Set<String> createImmutableSetNew() {
		return Set.of("John", "George", "Betty");
	}

	@Test
	void inmutableCollectionTest() {
		var oldSet = createImmutableSetOld();
		var newSet = createImmutableSetNew();
		
		System.out.println(newSet);
		
		assertEquals(oldSet, newSet);
	}

}

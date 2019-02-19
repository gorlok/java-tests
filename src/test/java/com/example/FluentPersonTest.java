package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.example.FluentPerson.FluentPersonBuilder;

public class FluentPersonTest {
	
	@Test
	void fluentTest() {
		FluentPerson p = FluentPersonBuilder.builder()
				.withName("  ")
				.withAge(45)
				.withValidator(s -> s != null && !s.isBlank())
				.build();
		
		assertFalse(p.validate());
		
		
	}
	
}

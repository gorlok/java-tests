package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OptionalNullTest {
	
	@Test
	void optionalNullTest() {
		var p1 = new Person();
		
		assertEquals("name: <sin nombre>", p1.fullName());
		
		p1.setName("pepe");
		
		assertEquals("name: pepe", p1.fullName());
	}

}

package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PointTest {
	
	@Test
	void pointTest() {
		var p = Point.of(2.5f, 5f);
		
		assertEquals(2.5f, p.x());
		assertEquals(5f, p.y());
	}		

}

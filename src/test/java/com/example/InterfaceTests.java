package com.example;

import org.junit.jupiter.api.Test;

public class InterfaceTests {

	@Test
	void defaultInterfaceTest() {
		var op = new Operations();
		
		var sum = op.add(10, 20);
		var mul = op.multiply(3, 5);
		
		System.out.printf("sum is %d and mul is %d", sum, mul);
	}
	
}

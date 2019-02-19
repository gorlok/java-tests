package com.example;

public interface IOperations {
	
	private void log(String s) {
		System.out.println(s);
	}
	
	default int add(int x, int y) {
		log(String.format("add %d and %d", x, y));
		return x + y;
	}
	
	default int multiply(int x, int y) {
		log(String.format("multiply %d and %d", x, y));
		return x * y;
	}

}

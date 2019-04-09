package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TriviaEclipse {
	
	static String m1(long ...v) { return "long"; }
	
	static String m1(int v1, int v2) { return "int"; }

	@Test
	void trivia() {
		assertEquals("int", m1(Integer.MAX_VALUE+1, Integer.MAX_VALUE-1));
	}

}

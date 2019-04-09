package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Api {
	
	private String[] comments = {"uno", "dos", "tres"};
	
	public Stream<String> comments() {
		return Stream.of(this.comments);
	}
	
	public Stream<String> comments2() {
		List<String> list = Arrays.asList(this.comments);
		return list.stream();
	}
		
}

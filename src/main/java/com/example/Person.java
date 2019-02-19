package com.example;

import java.util.Optional;

public class Person {
	
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> name() {
		return Optional.ofNullable(this.name);
	}
	
	public String fullName() {
		return "name: " + name().orElse("<sin nombre>");
	}

}

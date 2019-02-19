package com.example;

public class FluentPerson {
	
	private String name;
	private int age;
	
	private Validator validator;
	
	private FluentPerson() {
	}

	public String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	void setAge(int age) {
		this.age = age;
	}
	
	void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	public boolean validate() {
		return validator.handle(this.name);
	}
	
	@FunctionalInterface
	public interface Validator {
		boolean handle(String value);
	}
	
	public static class FluentPersonBuilder {
		private FluentPerson instance = new FluentPerson();
		
		public static FluentPersonBuilder builder() {
			return new FluentPersonBuilder();
		}
		
		public FluentPersonBuilder withName(String name) {
			this.instance.setName(name);
			return this;
		}
		
		public FluentPersonBuilder withAge(int age) {
			this.instance.setAge(age);
			return this;
		}
		
		public FluentPersonBuilder withValidator(Validator validator) {
			this.instance.setValidator(validator);
			return this;
		}
		
		public FluentPerson build() {
			return this.instance;
		}
	}

}

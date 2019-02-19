package com.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
	
	private List<String> stuff = new ArrayList<>();
	
	public ShoppingBasket(List<String> stuff) {
		this.stuff = stuff;
	}
	
	public List<String> get() {
		return this.stuff;
	}
	
	@Deprecated(since = "4", forRemoval = true)
	public void foo() {
		//
	}
	
}


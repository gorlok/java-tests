package com.example;

import java.util.List;
import java.util.Optional;

public class ShoppingBasketManager {
	
	public Optional<ShoppingBasket> findShoppingBasketEmpty() {
		return Optional.empty();
	}
	
	public Optional<ShoppingBasket> findShoppingBasketWithStuff() {
		var basket = new ShoppingBasket(List.of("patata", "banana", "choco"));
		return Optional.of(basket);
	}
	
}
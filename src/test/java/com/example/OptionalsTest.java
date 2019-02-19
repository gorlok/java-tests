package com.example;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalsTest {
	
	void displayShoppingBasketContent(ShoppingBasket basket) {
		System.out.println("basket content: " + basket.get());
	}
	
	void displayEmptyShoppingBasket() {
		System.out.println("basket: no content");
	}
	
	@Test
	void optionalIfPresentOrElseTest() {
		var shop = new ShoppingBasketManager();
		
		var basketEmpty = shop.findShoppingBasketEmpty();
		basketEmpty.ifPresentOrElse(
				this::displayShoppingBasketContent, 
				this::displayEmptyShoppingBasket);

		var basketNotEmpty = shop.findShoppingBasketWithStuff();
		basketNotEmpty.ifPresentOrElse(
				this::displayShoppingBasketContent,
				this::displayEmptyShoppingBasket);
		
		
		var basket = shop.findShoppingBasketEmpty().or(() -> Optional.of(
				new ShoppingBasket(List.of("phone", "watch"))));
		
		System.out.println("basket: " + basket.get().get());
	}

}

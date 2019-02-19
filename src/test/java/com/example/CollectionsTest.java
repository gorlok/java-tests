package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CollectionsTest {

	@Test
	void inmutableCollectionsTests() {
		var lista = List.of("uno", "dos", "tres", "cuatro");
		var mapa = Map.of("a", 1, "b", 2, "c", 3);
		
		System.out.println(lista);
		System.out.println(mapa);
		
		assertEquals("tres", lista.get(2));
		assertTrue(lista.size() == 4);
		
		assertEquals(3, mapa.get("c"));
		
		//mapa.put("x", 99);
	}


}

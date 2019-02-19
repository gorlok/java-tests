package com.example.composition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.composition.Computer.ComputerBuilder;

public class ComputerTest {

	@Test
	void computerTest() throws Exception {
		Computer pc = ComputerBuilder.builder()
				.withProcessor(new StandardProcessor("Intel i5"))
				.withMemory(new StandardMemory("DDR3", "4GB"))
				.withSoundCard(new StandardSoundCard("SoundBlaster"))
				.build();
		
		assertEquals("4GB", pc.getMemory().get().getSize());
	}
}

package com.example.composition;

import java.util.Optional;

public class Computer {
	
	private Processor processor;
	private Memory memory;
	private SoundCard soundCard;
	
	public Optional<Processor> getProcessor() {
		return Optional.of(processor);
	}
	public Optional<Memory> getMemory() {
		return Optional.of(memory);
	}
	public Optional<SoundCard> getSoundCard() {
		return Optional.of(soundCard);
	}
	
	public static class ComputerBuilder {
		Computer instance;
		
		private ComputerBuilder() {
			this.instance = new Computer();
		}
		
		public static ComputerBuilder builder() {
			return new ComputerBuilder();
		}
		
		public ComputerBuilder withProcessor(Processor p) {
			this.instance.processor = p;
			return this;
		}
		
		public ComputerBuilder withMemory(Memory m) {
			this.instance.memory = m;
			return this;
		}
		
		public ComputerBuilder withSoundCard(SoundCard sc) {
			this.instance.soundCard = sc;
			return this;
		}
		
		public Computer build() {
			return this.instance;
		}
	}
}

interface Processor {
	String getModel();
	void setModel(String model);	
}
interface Memory {
	String getBrand();
	void setBrand(String brand);
	String getSize();
	void setSize(String size);
}
interface SoundCard {
	String getBrand();
	void setBrand(String brand);
}

class StandardProcessor implements Processor {
	private String model;
	
	public StandardProcessor(String model) {
		super();
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}

class StandardMemory  implements Memory {
	private String brand;
	private String size;
	
	
	public StandardMemory(String brand, String size) {
		super();
		this.brand = brand;
		this.size = size;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}

class StandardSoundCard implements SoundCard {
	private String brand;
	
	
	public StandardSoundCard(String brand) {
		super();
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
}


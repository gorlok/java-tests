package com.example;

public class Point {
	
	private double x, y;

	private Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double x() {
		return x;
	}
	
	public double y() {
		return y;
	}
	
	public static Point of(double x, double y) {
		return new Point(x, y);
	}
	
}

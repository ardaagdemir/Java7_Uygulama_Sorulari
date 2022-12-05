package com.bilgeadam.solid_example.open_closed;

public class Circle extends Shape {

	public double radius;

	@Override
	public double Area() {
		return radius *radius * Math.PI;
	}
	
}

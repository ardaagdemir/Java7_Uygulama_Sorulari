package com.bilgeadam.solid_example.open_closed;

public class Rectangle extends Shape{
	
	public double width;
	public double height;
	
	@Override
	public double Area() {
		return width * height;
	}
	
	
}

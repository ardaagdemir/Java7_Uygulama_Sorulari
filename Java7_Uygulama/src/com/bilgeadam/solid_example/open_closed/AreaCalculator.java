package com.bilgeadam.solid_example.open_closed;

public class AreaCalculator {
	
	static double area=0;
	
	public static double area(Shape shapes) {
		double area=0;
		area = shapes.Area();
		return area;
	}
}

package com.bilgeadam.solid_example.open_closed;

public class Main {

	public static void main(String[] args) {
		
		Rectangle rectangle = new Rectangle();
		rectangle.height = 5;
		rectangle.width = 10;
		
		Circle circle = new Circle();
		circle.radius = 3;
		
		System.out.println(AreaCalculator.area(rectangle));
		System.out.println(AreaCalculator.area(circle));

	}

}

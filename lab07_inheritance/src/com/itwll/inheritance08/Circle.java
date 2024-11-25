package com.itwll.inheritance08;

public class Circle extends Shape {

	private double raidus;
	
	public Circle(double raidus) {
		super("동그라미");
		this.raidus = raidus;
	}

	@Override
	public double area() {
		return Math.PI * raidus * raidus;
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * raidus;
	}

}

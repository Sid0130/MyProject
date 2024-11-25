package com.itwill.class04;

public class Rectangle {
	// 필드(field)
	double width; // 직사각형의 가로 길이
	double height; // 직사각형의 세로 길이
	
	// 생성자(constructor)
	// 기본생성자
	// 가로/세로 길이를 아규먼트로 전달받아서 초기화 하는 생성자
	public Rectangle() {}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	// 메서드(method)
	// area 직사각형의 넓이를 리턴.
	// perimeter : 직사각형의 둘레 길이를 리턴.
	public double area() {
		double result;	
		result = this.height * this.width;
		System.out.println("직사각형의 넓이 = " + result);
		return result;
	}
	
	
	public double perimeter() {
		double result;
		result = (this.height + this.width) * 2;
		System.out.println("직사각형의 둘레 = " + result);
		return result;
	}

}

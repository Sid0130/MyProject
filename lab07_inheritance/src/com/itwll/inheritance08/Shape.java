package com.itwll.inheritance08;

public abstract class Shape {
	// field
	protected String type; // 직사각형, 원, ..
	
	// constructor - 상속하는 하위 클래스에서만 호출 가능. 
	public Shape(String type) {
		this.type = type;
	}
	
	// 추상 메서드
	public abstract double area(); // 도형의 넓이를 리턴하는 메서드. 
	public abstract double perimeter(); // 도형의 둘레 길이를 리턴하는 메서드.  각각 도형은 계산하는 방식이 다를거가 때문에 
	
	// final 메서드 : 하위 클래스에서 override 할 수 없는 메서드.
	
	public final void draw() {
		String msg = String.format("%s [넓이: %f, 둘레: %f]\n", 
				type, area(),perimeter());
		System.out.println(msg); // 문자열 만들어주고싶은 메서드
		
		// 누군가가 대신 구현해주길 남겨두는것
		
	}
}

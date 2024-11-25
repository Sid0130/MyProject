package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		
		// Rectangle 타입 객체 선언, 초기화
		Rectangle r1 = new Rectangle();
		System.out.println("r1 = " + r1);
		System.out.println("r1 = " + r1.height);
		System.out.println("r1 = " + r1.width);
		
		r1.height = 5.0;
		r1.width = 5.0;
		r1.area();
		r1.perimeter();
				
		Rectangle r2 = new Rectangle(4, 3);
		System.out.println(r2);
		r2.area();
		r2.perimeter();
		// Rectangle 객체의 메서드 호출
		
		

	}

}

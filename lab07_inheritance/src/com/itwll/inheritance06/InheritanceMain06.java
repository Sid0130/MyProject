package com.itwll.inheritance06;

public class InheritanceMain06 {

	public static void main(String[] args) {
//		Point 타입의 객체들을 생성, toString, equals, hashCode 메서드를 테스트
		Point pt1 = new Point();
		System.out.println(pt1);
		// -> toString() 오버라이드 전 : com.itwll.inheritance06.Point@54bedef2
		// -> toString() 오버라이드 후 : Point [x=0.0, y=0.0]
		System.out.println(pt1.hashCode());
		// ->hashCode() 오버라이드 전 :1421795058(10진수) = 0x54bedef2(16진수)
		Point pt2 = new Point();
		System.out.println(pt2);
		System.out.println(pt2.hashCode());
		
		System.out.println(pt1.equals(pt2));
		// -> equlas() 오버라이드 전: false
		// -> equlas() 오버라이드 후: true
		
		Point pt3 = new Point(1,2);
		System.out.println(pt3);
		System.out.println(pt3.hashCode());
		System.out.println(pt1.equals(pt3));
		System.out.println("---------------------");
		
		Member m1 = new Member("admin", "1234");
		System.out.println("m1: " + m1);
		System.out.println("m1 hash: " + m1.hashCode());
		
		Member m2 = new Member("admin", "admin1234");
		System.out.println("m2: " + m2);
		System.out.println("m2 hash: " + m2.hashCode());
		
		System.out.println("m1 equals m2: " + m1.equals(m2));
	}
}

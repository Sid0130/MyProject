package com.itwill.class01;

/*
 * 객체지향 프로그래밍 언어(object-Oriented Programming Language): Java, C++, C#, Kotlin, ...
 * 절차지향 프로그래밍 언어(Procedural Programming Language): C, ...
 * 
 * 객체(Object) : 대상. 프로그램에서 만들려고(사용하려고) 하는 대상. 추상적인 개념     
 * 클래스(Class): 객체 설계도. 객체를 만들기 위한 소스코드.
 * - 객체가 가져야 하는 "데이터(값)"를 변수로 선언 -> 필드(field).
 * - 객체가 가져야 하는 "기능"을 메서드로 선언.
 * - 변수를 선언할 때 타입 이름으로 사용됨.
 * 인스턴스(Instance): 실제로 생성된 객체.
 */

public class ClassMain01 {

	public static void main(String[] args) {
		
		String s1 = "안녕하세요!"; 
		System.out.println("s1 length = " + s1.length());
		System.out.println("s1 concat = " + s1.concat("비가 오네요...")); //s1 문자 뒤에 concat 글자 붙혀라
		
		String s2 = "hello";
		System.out.println("s2 length = " + s2.length());	
		System.out.println("s2 concat = " + s2.concat("Java"));
		// 사용하려고 하는 객체를 만들려면
		// 변수타입 변수를 선언해서 
		// 객체와 객체관계를 이용해서 프로그래밍하는것이 객체지향프로그램
		// 객체가 가지고있는 데이터 , 변수들의 값들, s2라고 하는 문자열의 데이터가 있을거고
		// s2.의 기능 을 가져다 쓰는것 그리고 리턴
		// 다른 클래스의 메서드를 사용하라면 변수를 선언해줘야한다.
		// hello 는 문자열 객체 또는 인스턴스.라고한다
	}

}

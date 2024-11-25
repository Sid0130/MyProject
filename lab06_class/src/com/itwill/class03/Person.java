package com.itwill.class03;

public class Person {
	// field(필드)
	String name;
	int age;
	
	// constructor (생성자)
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		//객체가 가지고있는 변수를 = 저장하겠다 지역변수의 변수로
	}
	
	// method(메서드)
	public void sayHello() {
		System.out.println("안녕하세요, 저는 " + this.name + " 입니다.");
		System.out.println("제 나이는 " + this.age + " 입니다.");
		
		// this 인스턴스 인스턴스가 가지고있는 age라는 필드 this
		// this 가 생성된 객체 이 메서드를 호출한 객체(인스턴스)
		// this 는 sayHello를 호출한 인스턴스 this 라고함
	}
		
}

package com.itwll.inheritance02;

// 회사원은 사람이다. (Business person is a person.)
// 사람 - Superclass(상위 클래스), 회사원 - Subclass(하위 클래스).
public class Person {
	
	// field 
	private String name;	
	//  protected 상속에서는 보여주겠다.
	// constructor
	public Person() {
		System.out.println("Person() 생성자 호출");	
	}
	public Person(String name) {
		this.name = name;
		System.out.println("Person(name) 생성자 호출");
	}
	// getter & setter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

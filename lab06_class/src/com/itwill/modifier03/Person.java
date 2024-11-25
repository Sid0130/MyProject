package com.itwill.modifier03;

public class Person {
	// field 
	private String name; // 읽기 전용
	private int age; // 읽기/쓰기 가능
	
	// constructor
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	// method
	// getter & setter
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if(age >= 0) {
			this.age = age;
		} else {
			// 경고 메세지를 출력하거나 
			// 예외(Exception) 발생
		}
			// 필드는 프라이빗으로 하고 값을 바꿔주는 세터는 필요한 경우에 퍼블릭으로 한다
		// 매번 필드에 값을 변경하는것을 방지하기 위해 한곳 (메서드)에서 데이터 무결성을 유지할 수 있다.
		// 그래서 세터를 제공하고 필드는 프라이빗으로 감춤으로서 데이터 캡슐화를 할 수 있다.
		// 전통적으로 필드는 프라이빗 특별한 경우는 퍼블릭. 생성자나 메서드는 퍼블릭, 가끔 프라이빗으로 감추기도함.
		// 
	}
}

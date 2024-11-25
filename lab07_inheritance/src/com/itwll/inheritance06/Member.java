package com.itwll.inheritance06;

import java.util.Objects;

public class Member {
	// field
	private String id;
	private	String password;
	
	public Member() {}

	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	// to String override : id, password
	@Override // annotation(애너테이션) - 자바 컴파일러가 메서드 오버라이드 문법에 맞는 지를 
	public String toString() {
		return "Member(id: " + id + ", password: " + password + ")";
	}
	
	// hashCode, equals override : id가 같으면 equals가 true가 되도록. 같은 hash 코드 값이 되도록.
	@Override
	public int hashCode() {
//		return Objects.hash(id); 	// Objects 은 static 메서드를 활용.
		return id.hashCode(); // String 클래스에서 override 한 메서드를 활용. 이미 해쉬코드가 오버라이드 되어있으니까 이것을 이용하겠다
	
	}	
	@Override
	public boolean equals(Object x) {
		boolean result = false;
		if (x instanceof Member) {
			Member other = (Member) x;
//			result = this.id == other.id; // id가 String이니 equals를 써야함!!
			result = this.id.equals(other.id); // -> (주의) id는 문자열 타입이므로, 비교할 때 equals() 메서드로 비교!
		}
		return result;
	}	
}

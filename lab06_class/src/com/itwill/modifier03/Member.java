package com.itwill.modifier03;

public class Member {
	// field 
	// 항상 프라이빗으로 선언 , 필요한 경우에 getter 와 setter 를 제공해서 메서드들은 퍼블릭으로 제공하자라는게 자바의 객체지향설계 철학.
	private String id; // 읽기 전용 값 -> getter 만 작성
	private String password; // 읽기/쓰기 가능 -> getter, setter 작성
	
	
	// constructor
	
	public Member(String id, String password) {
		this.id = id; 
		this.password = password; 
	}
	
	// method
	// getter method : private 으로 감춰진 필드의 값을 읽을 수 있도록 해주는 메서드. (필드의 값을 리턴)
	// 필드의 값을 리턴하는 메서드.
	public String getId() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	// setter method : private 으로 감춰진 필드의 값을 변경할 수 있도록 해주는 메서드.
	// 필드의 값을 전달받은 아규먼트로 변경(재할당)하는 메서드.
	public void setPassword(String password) {
		this.password = password;
	// 게터는 리턴타입 세터는 아규먼트를 받고 재할당
	}
	
}

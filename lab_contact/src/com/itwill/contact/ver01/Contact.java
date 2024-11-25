package com.itwill.contact.ver01;


// MVC 아키텍쳐에서 Model 역할을 담당하는 클래스.
// 연락처 데이터(이름 , 전화번호, 이메일) 저장하는 클래스
public class Contact {
	// field
	private String name;
	private String phone;
	private String email;
	
	// constructor
	// (1) 기본 생성자
	// (2) name, phone, email
	
	public Contact() {}
	public Contact(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	// method
	// getters & setters
	public String getName() {
		return this.name;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getEmail() {
		return this.email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	// 연락처 정보를 출력.
	
	public void info() {
		System.out.printf("Contact(name=%s, phone=%s, email=%s)\n", 
				this.name, this.phone, this.email);		
	}
	
	@Override
	public String toString() { // println 에서 사용 할 문자열
		return "Contact(name=" + this.name 
				+ ", phone=" + this.phone
				+ ", email=" + this.email + ")";
	}
}

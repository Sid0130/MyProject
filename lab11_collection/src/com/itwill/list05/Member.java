package com.itwill.list05;

import java.util.Objects;

public class Member {
	// field
	// 주소, 사진, 주문 등등..
	private String id;
	private String password;
	
	public Member() {}
	public Member(String id, String password){
		this.id = id;
		this.password = password;
		
	}
	
	//getter(id, password) & setter(password)
	
	public String getId() {
		return this.id;
	}
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
	
		return "Member (id= " + id + ", password= " + password + ")";
	}
	
	@Override
	public boolean equals(Object x) { //Object 비교할때에 멤버타입인지 아닌지 확인
		boolean result = false;
		if(x instanceof Member) {
			Member other = (Member) x; // 멤버타입으로 변환하겠다.
			result = this.id.equals(other.id); // 이퀄스로 전달된 id와 멤버의 아이디가 같은가. 두 객체의 아이디가 같은가
		}
		return result;
	}
	
	@Override
	public int hashCode() {
//		return id.hashCode(); // String 클래스에서 override한 hashCode를 이용.
		return Objects.hash(id); // java.util.Objects 클래스의 메서드를 이용.
	}	
}

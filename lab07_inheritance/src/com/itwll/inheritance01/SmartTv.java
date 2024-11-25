package com.itwll.inheritance01;
// 베이직 티비를 확장해서 스마트티비 클래스를 만든다.

// 스마트 TV는 기본TV를 확장(상속)한다.
// BasicTv: 상위(super), 부모(parent), 기본(base) 클래스
// SmartTv: 하위(sub), 자식(child), 유도된(derived) 클래스
// 모든 클래스의 최상위 클래스는 java.lang.Object 클래스.
// 상위 클래스가 Object인 경우 extends Object 선언은 생략 가능.
public class SmartTv extends BasicTv {
	// field
	private String ip;
	
	
	// getter & setter
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}

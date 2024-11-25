package com.itwill.menu;

public enum Captain2 {
	INSTANCE("캡틴 아메리카"); // 이게 싱글톤
	
	private String name;
	
	Captain2(String name){
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	
}

// 이넘을 이용한 싱글톤.
package com.itwill.menu;

public enum Season3 {
	SPRING("봄"),
	SUMMER("여름"),
	FALL("가을"),
	WINTER("겨울");
	// 이 이름으로 변수를 선언하는 것과 생성자를 호출하는것을 같이 써버리는것
	
	// enum 도 클래스의 한 종류이기 때문에 필드/생성자/메서드를 선언할 수 있음. 
	
	private String seasonName; 
	
	// 생성자
	// enum 생성자가 class 생성자와 다른 점은 private만 가능.
	// enum 생성자에서는 private을 생략 가능.
	Season3(String seasonName){
		this.seasonName = seasonName;
	}
	
	// 메서드
	public String getSeasonName() {
		return seasonName;
	}
}

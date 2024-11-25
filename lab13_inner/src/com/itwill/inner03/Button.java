package com.itwill.inner03;

// 해야될 일을 어떻게 세팅을하고 각각 버튼들이 해야될 일
// 해야될 일을 약속해두면 
// 클릭이라는 일은 자바가상머신이 해주는데
/*
 * 생성자 - 인터페이스는 클래스 객체를 생성 못하니 클래스를 새로 만들어서 객체를 만들어 오버라이딩하고 다형성으로 onClick에 아규먼트 listener를 줄 수 있다
 */

public class Button {
	//public static 내부 인터페이스 -> static 생략 가능.
	public interface OnClickListener { // 추상메서드, 상수
		void onClick(); // public abstract 생략. 다른 클래스에서 구현할 수 있어야 함
		// 클릭할 때 동작하는 메서드
	}
	
	// class Button의 필드.
	private String name;
	private OnClickListener onClicklistener;
	
	// class Button의 생성자.
	public Button(String name) {
		this.name = name;
	}
	
	// class Button의 setter
	public void setOnClickListener(OnClickListener listener) {
		this.onClicklistener = listener;
	}
	
	// class Button의 메서드
	public void click() {
		System.out.print(name + "버튼: ");
		onClicklistener.onClick();
	}
}

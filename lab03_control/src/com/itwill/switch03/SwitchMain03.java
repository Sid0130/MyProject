package com.itwill.switch03;

enum Week { // 하나의 파일안에서 만드는 방법. 따로 만드는게 좋다.
	SUN, MON, TUE;
}

public class SwitchMain03 {

	public static void main(String[] args) {
		// switch 구문에서 enum 을 사용하는 방법 :
		
		// Season enum 타입의 변수를 선언, 초기화
		Season s = Season.SUMMER; // enum 의 이름 .상수
		
		switch (s) {
		case SPRING :
			System.out.println("봄");
			break;
		case SUMMER :
			System.out.println("여름");
			break;
		case FALL :
			System.out.println("가을");
			break;
		case WINTER :
			System.out.println("겨울");
			break;
		}
		
		// 첫번째 목적은 제한된 입력값을 지정하기 위해
		// 상수이름을 의미있게 만들면 코드를 보고 무슨 역할을 하는지 예측이 가능하다
		// 시즌과 메인클래스가 같은 패키지에 있기에 import를 안해도 되는것이고
		// 기본타입이 아니면 import를 해야하는데 같은 패키지 안에 있으면 import하지 않아도 된다.
		

	}

}

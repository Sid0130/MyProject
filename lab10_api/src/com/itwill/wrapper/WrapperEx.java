package com.itwill.wrapper;

/*
 * wrapper 클래스: 자바의 기본 타입의 값을 하나만 저장하는 클래스(타입).
 * 기본 타입: boolean, byte, short, int, long, char, float, double
 * wrapper: Boolean, Byte, Short, Integer, Long, Character, Float, Double
 * - java.lang 패키지에 있기 때문에 import 문장이 필요 없음. 기본 타입은 값만 갖고있고 메서드는 없음. 해당 메모리에 0과 1을 저장하고 있는 타입이 기본 
 * - 목적:
 * 	 (1) 기본 타입의 값을 사용한 기능(메서드)들을 제공.
 * 	 (2) 상속/다형성 이용 가능.
 * 	 (3) generic class(List, Set, Map)에서 이용하기 위해서.
 * 
 */

public class WrapperEx {

	public static void main(String[] args) {
		// 객체를 만드는 것!
		// int 타입의 값을 아규먼트로 전달받아서 Integer 타입의 객체 생성. (int -> Integer)
		Integer number1 = Integer.valueOf(1); // 메서드를 사용한다. 제공한다. 스태틱 메서드 은 클래스 이름으로 호출
		System.out.println(number1); // Integer는 객체다 Object를 상속 받는다 
		
		
		// 문자열(String)을 아규먼트로 전달받아서 Integer 타입의 객체 생성 (String -> Integer)
		Integer number2 = Integer.valueOf("123");
		System.out.println(number2);
		
		// 문자열(String)을 int 타입의 정수로 변환(String -> int) 하는 메서드. 기본타입의 값
		int number3 = Integer.parseInt("100"); // parse로 시작되면 기본타입!
		System.out.println(number3);
		
		int result = number1 + number2; // auto-unboxing: Integer 객체 값을 자동으로 리턴.
		//Integer라는 객체는 그냥 사칙연산으로 쓰면된다.
		System.out.println(result);
		
		Integer number4 = 4; // auto-boxing: 기본 타입의 값을 wrapper 객체로 (자동) 변환.
		
		// 더하기는 두가지 밖에 없음 숫 숫 문 문
		// 래퍼클래스 = 박스  포장하는 클래스
		// valueOf = 박스에 숫자를 넣어서 포장 포장하는것을 박싱(boxing)
		// 박스를 열어서 포장을 푸는것을 unboxing . unboxing 을 해주는 메서드는 .intValue가 있음. 객체가 가지고 있는 값을 타입의 값으로 리턴해주는 메서드
		// boxing 할때 사용하는 메서드가 valueOf(...) 꺼내주는거면 .intValue 이게 unboxing
		// 자동으로 꺼내주는것을 오토언박싱 int 타입의 변수에 값을 변환해주는것 = Integer라는 객체를 그냥 int라고 생각해도 무관하다.
		// 메서드들을 가지고있는 Integer다. 타입이다.
	}

}

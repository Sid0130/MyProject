package com.itwill.method02;

/*
 * 메서드 선언(정의) 방법 : 
 * [수식어] 리턴타입 메서드이름([파라미터 선언, ...]) { ...; ...;}  대괄호는 생략해도 되는 부분  
 * - 수식어는 생략 가능.
 * - 수식어 종류 : public, protected, private, static, abstract, final
 * - 아규먼트를 전달받지 않는 메서드는 파라미터를 선언하지 않음.
 * - 파라미터가 여러개일 때는 쉼표(,)로 구분.
 * - 반환값이 있는 메서드는 반환값의 타입을 메서드 이름 앞에 명시.
 * - 반환값이 없는 메서드는 메서드 이름 앞에 "void" 라고 명시.
 * - 메서드는 클래스 안에서만 작성!
 * - 메서드 안에서 또 다른 메서드를 작성할 수 없음!
 * - 메서드 이름은 변수 이름과 같이 소문자로 시작하는 camel 표기법을 권장.
 * - 메서드 이름의 규칙(문법)은 변수 이름 규칙과 동일.
 */

public class MethodMain02 {

	public static void main(String[] args) { // 수식어[public static] 리턴타입[void] 메서드이름[main] 파라미터선언[String[] args]
		// void 는 리턴 값이 없다 라는 뜻.
		// 수식어는 상황에 따라 생략 가능
		// 리턴타입은 생략 불가능.
		// 중괄호 빠지면 안됨.

		// 아규먼트가 있고, 리턴 값도 있는 메서드 작성 연습.
		// 메서드는 호출해야 실행이 됨.
		double result = add(2.0, 1.0); // 메서드를 불러주는 곳
		System.out.println("result = " + result);

		result = add(10.2, 2.0);
		System.out.println("result = " + result);
		
		result = subtract(1.0, 2.0);
		System.out.println("result = " + result);
		
		result = multiply(2, 2); // double x = 2;
		System.out.println("result = " + result);
		
		result = divide(1, 2); // 실제로 divide 안에서는 double 값으로 나온다 그러므로 0.5로 나옴.
		System.out.println("result = " + result);
		
		// todo는 나중에 할일 fixme는 고칠거
		// TODO:
		// FIXME:
	}
	// 기능이 필요한 위치에서 불러오기 위한것

	// 메서드 선언 -> 문서 주석(documentation comment)를 함께 작성할 수 있음.

	/**
	 * 아규먼트로 전달받은 두 숫자 x 와 y 의 덧셈 결과를 리턴.
	 * 
	 * @param x {@code double}.
	 * @param y {@code double}.
	 * @return {@code x + y}.
	 */
	public static double add(double x, double y) { // 파라미터 개수랑 아규먼트 개수가 같아야함
		// 파라미터는 괄호안에서 선언하는것
		return x + y; // 반환하겠다.
	}

	/**
	 * 숫자 2개를 전달 받아서, 두 숫자의 뺄셈 결과 ({@code x - y})를 리턴.
	 * 
	 * @param x double
	 * @param y double
	 * @return x - y.
	 */
	public static double subtract(double x, double y) {
		
		return x - y;
	}
	
	/**
	 * multiply. 숫자 2개를 전달받아서, 숫자의 곱셉 결과를 리턴하는 메서드.
	 * 
	 * @param x double.
	 * @param y double.
	 * @return x * y.
	 */
	public static double multiply (double x, double y) {
		return x * y;
	}

	
	/**
	 * divide. 숫자 2개를 전달받아서, 첫번째 아규먼트를 두번째 아규먼트로 나눈 값을 리턴.
	 * 
	 * @param x double.
	 * @param y double.
	 * @return x / y.
	 */
	public static double divide (double x, double y) { // 둘다 더블이기 때문에 리턴값도 더블
		return x / y;
	}
}

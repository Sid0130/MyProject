package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

/*
 * 람다 표현식(lambda expression)
 * - 익명 클래스 객체를 간단히 작성하기 위한 문법.
 * - 함수형 인터페이스(추상 메서드가 1개)만 람다 표현식으로 작성할 수 있음.
 * 
 * 람다 표현식 문법: (파라미터 선언, ...) -> { 실행 코드; ... } // 실행코드 2문장 이상인 경우
 * (예) (double x,double y) -> {return x / y;} // 실제 정확한 문법
 * - 파라미터 선언에서 변수 타입은 생략 가능. (예) (x, y) -> { return x / y; }
 * - 람다 표현식 몸통 {} 에 한 문장만 있는 경우, {}와 세미콜론(;)을 생략.
 * - 람다 표현식 몸통이 return 문장만 있는 경우에는 return 값만 남김. (예) (x, y) -> x / y
 * - 람다 표현식의 파라미터가 1개인 경우, 괄호() 를 생략 가능. (예) x -> 2 * x
 * - 람다 표현식에서 파라미터가 없는 경우에는 ()는 생략 불가! (예) () -> "Hello"
 */


public class LambdaMain01 {

	public static void main(String[] args) {
		// Calculator 타입 객체 생성
		Calculator calculator = new Calculator(1, 2);
		
		//--- 별도의 java 파일에서 인터페이스를 구현하는 클래스를 작성, 그 객체를 생성.
		Calculable adder = new Adder(); // 다형성
		
		
		// Calculator 객체생성 calculate(x,y) 메서드를 호출해서 계산
		double result = calculator.calculate(adder);
		System.out.println("result = " + result);
		
		//--- 지역 클래스를 선언하고, 그 객체를 생성해서 calculate() 메서드의 아규먼트로 전달:
		class Subtractor implements Calculable {
			@Override
			public double calculate(double x, double y) {
				return x - y;
			}	
		}
		Calculable subtractor = new Subtractor();
		result = calculator.calculate(subtractor); 
		System.out.println("result = " + result);
		
		//--- 익명 클래스로 객체를 생성하고, 그 객체를 calculate() 메서드의 아규먼트로 전달.
		Calculable multiplier = new Calculable() {
			
			@Override
			public double calculate(double x, double y) {
				return x * y;
			}
		}; //문장이 끝났다
		
		result = calculator.calculate(multiplier);
		System.out.println("result = " + result);
		
		//--- calculate() 메서드를 호출할 때 아규먼트로 익명 클래스 사용.
		result = calculator.calculate(new Calculable() { // 계산기 기능에게 아규먼트의 기능을 전달. 그리고 리턴
			@Override	//생성자 호출한다 그 클래슬를 옆에 만들고 객체를 생성 한다.
			public double calculate(double x, double y) {  // x,y 순서, 타입
				return x / y; // 메서드 1개만 갖고있다.
			}
		}); 
		System.out.println("result = " + result);
		
		//- 람다 표현식(lambda expressing)을 사용한 calculate() 메서드 호출:
		result = calculator.calculate((x, y) -> x / y);
//		result = calculator.calculate((double x,double y) ->{return x / y; });
		
		System.out.println("result = " + result);
		
	}

}

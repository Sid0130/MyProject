package com.itwill.lambda01;

public class Calculator {
	
	//함수형 인터페이서(functional interface): 추상 메서드를 오직 1개만 갖는 인터페이스.
	@FunctionalInterface // -> 컴파일러가 함수형 인터페이스인 지를 체크.
	// 추상 메서드가 없으면 에러, 인터페이스가 함수형 인터페이스가 맞는지 오직 1개 있는기 검사
	public interface Calculable {
		double calculate(double x, double y);		
	}
	
	// 필드
	private double x;
	private double y;
	// 생성자
	public Calculator(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// 메서드
	
	public double calculate(Calculable calc) { // 반드시 Calculable 값을 전달해줘야하고  생성된 객체의 주소값이 넘어옴.
		return calc.calculate(x, y); // 추상메서드 구현을해야 객체를 생성 가능.
	}
}

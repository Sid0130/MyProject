package com.itwill.class02;

public class ClassMain02 {

	public static void main(String[] args) {
		// 같은 패키지의 클래스 이름은 import 문 없이도 사용 가능.
		// Score 타입의 객체를 선언, Score 객체 생성하고 변수에 할당.
		Score score1 = new Score(); // 객체를 생성하게되면 각 변수의 기본 값은 0
		System.out.println(score1);
		System.out.println("korea = " + score1.korean);
		// score1 인스턴스의 필드 값들을 변경.
		score1.korean = 100;
		score1.english = 90;
		score1.math = 55;
		
		System.out.println("korea = " + score1.korean);
		
		// score1 인스턴스의 메서드 호출 : 
		System.out.println("score1 총점 : " + score1.getTotal()); // 객체를 생성해야 메서드를 호출가능.
		System.out.println("score1 평균 : " + score1.getMean());
		System.out.println();
		
		// score 타입 객체 선언, 초기화
		Score score2 = new Score();
		// score2 객체(인스턴스)의
		score2.korean = 50;
		score2.english = 55;
		score2.math = 99;
		
		// score2 인스턴스의 메서들을 호출.
		System.out.println("score2 총점 : " + score2.getTotal());
		System.out.println("score2 평균 : " + score2.getMean());
		
		// score 타입 변수 선언, 아규먼트를 갖는 생성자를 호출해서 초기화.
		Score score3 = new Score(99, 88, 70);
		
		// score3 인스턴스에서 메서드 호출.
		
		System.out.println("score3 총점 : " + score3.getTotal());
		System.out.println("score3 평균 : " + score3.getMean());
		
	}

}

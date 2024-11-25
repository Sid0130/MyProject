package com.itwill.condition07;

import java.util.Scanner;

public class ConditionMain07 {

	public static void main(String[] args) {
		// Scanner 타입 변수를 생성하고 초기화.
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 입력>>> ");
		int number = scanner.nextInt();
		//변수 number에 저장된 값이 짝수(even number)이면 "짝수",
		//홀수 (odd number) 이면 "홀수"를 저장하기 위한 변수.
		String evenOrOdd = (number % 2 == 0) ? "짝수" : "홀수"; //문자를 저장하는 변수 타입
		// 뒤에 출력값이 문자인지 숫자인지에 따라 변수 타입이 String 인지 int 인지 적을 수 있다.
		// 비교하는것 중요하다 조건식 if나 삼항에는 무조건 조건식이 와야한다 비교와 논리 true거나 false
		
		System.out.println(evenOrOdd);
		
		
//		int big2 = (x > y) ? x : y;
		
	}

}

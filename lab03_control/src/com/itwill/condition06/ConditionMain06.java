package com.itwill.condition06;

import java.util.Scanner;

public class ConditionMain06 {

	public static void main(String[] args) {
		
		//Scanner 타입의 변수를 생성하고 초기화.
		Scanner scanner = new Scanner(System.in); //new라고 했을때 변수의 타입을 그대로 써준다.
		
		System.out.print("첫번째 정수 입력 >>> ");
		int x = scanner.nextInt(); // 콘솔창에서 입력한 정수를 변수 x에 저장.
		
		System.out.print("두번째 정수 입력 >>> ");
		int y = scanner.nextInt(); // 콘솔창에서 입력한 정수를 변수 y에 저장.
		
		int big; // x, y중에서 더 큰(크거나 같은) 정수를 저장하기 위한 변수.
		
		if(x>y) {
			big = x;
		} else {
			big = y;
		}
		System.out.println("big = " + big); //big 은 틀리던 맞던 항상 실행해야하니
		// 마지막에 한번만 적어도 된다.
		
		// 삼항 연산자 : if-else를 간단히 쓰는 문법.
		// 조건식 ? 조건식이 참일 때 선택할 값 : 조건식이 거짓일 때 선택할 값
		int big2 = (x > y) ? x : y; //x가 y보다 큰가요? 크면 x 작으면 y
		// ':' 는 그렇지 않으면 
		System.out.println("big2 = " + big2);
		
		
		
		
//		if (x > y) { //x가 크면 big에 들어가고 y가 클경우 big에 들어간다
//			System.out.println("첫번째 정수 >>> " + (big = x));
//		} else {
//			System.out.println("두번째 정수 >>> " + (big = y));
//		}
		
	}

}

package com.itwill.condition02;

import java.util.Scanner;

public class ConditionMain02 {

	public static void main(String[] args) {
		// 콘솔 창에서 키보드로 정수를 입력받는 방법:
		Scanner scanner = new Scanner(System.in); //콘솔 입력 도구를 만들어서 변수에 저장.
		
		System.out.print("정수 입력 >>> ");
		
		// 콘솔에서 정수 1개를 입력받고, int 타입 변수 number에 저장.
		int number = scanner.nextInt(); //타이핑한것을 읽어들이겠다. 스캔을해서 정수를 받겠다.
		// 입력을 받아서 변수에 담겠다
		System.out.println("number = " + number);
		
		// if-else if-else 구문 : 
		if (number > 0) { //만약 number가 0보다 크면
			System.out.println("number = 양수");
		} else if (number < 0) { // 그렇지않고, number 0보다 작으면
			System.out.println("number = 음수");
			
		} else { //그렇지 않으면, 
			System.out.println("number = 0");
		}
		// 조건식만 잘 만들면 

	}

}

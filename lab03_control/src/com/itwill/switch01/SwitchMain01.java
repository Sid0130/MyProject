package com.itwill.switch01;

public class SwitchMain01 {

	public static void main(String[] args) { // 프로그램 시작과 끝
		// switch 구문 :
		// switch (식)을 평가(계산)한 후, 해당 case 위치로 이동해서 break 문장을 만날 때까지 실행.
		// 해당하는 case가 없으면 default 블록을 실행. default 는 항상 마지막
		// default 블록은 없을 수도 있음.
		// switch (변수 또는 식)에서 사용할 수 있는 타입 : 
		// (1) 정수 : byte, short, int, long, char
		// (2) 문자 : String
		// (3) enum 타입 (상수들만 나열된 타입)
		// (주의) switch 구문에서는 실수(float, double) 또는 boolean 타입은 사용할 수 없음
		
		int number = 101;
		
		switch (number % 2) {
		case 0 : //콜론은 레이블 .. 코드에 라벨을 붙혀주는거 코드에 0번 포스트잇인지 1번 포스트잇인지 얘기하는것
			System.out.println("짝수");
			//break;
		case 1 : // 코드에 레이블링하는것. 
			System.out.println("홀수");
			//break;		// 마지막 break 문장은 생략 가능.	
		}
		
		// 문자열을 사용하는 switch-case:
		String season = "가을";
		switch (season) {
		case "봄" :
			System.out.println("spring");
			break;
		case "여름" :
			System.out.println("summer");
			break;
		case "가을" :
			System.out.println("fall");
			break;
		case "겨울" :
			System.out.println("winter");
			break;
		default : // default 블록은 항상 마지막에 작성.
			System.out.println("몰라요~");
		}
		
		
	}
}

package com.itwill.array03;

public class ArrayMain03 {

	public static void main(String[] args) {
		// 배열 선언, 초기화 2:
		// 배열이 가지고 있는 원소들을 나열하면서 배열을 초기화
		// 타입[] 변수이름 = new 타입[] {값1, 값2, ...}; -> (주의) 원소 개수를 표기하지 않음!
		// 타입[] 변수이름 = {값1, 값2, ...};

		// 10보다 작은 양의 홀수들을(1, 3, 5, 7, 9)을 저장하는 배열 :
		int[] odds = new int[] { 1, 3, 5, 7, 9 }; // 자바는 몇개인지 알아서 개수를 계산한다.
		for (int i = 0; i < odds.length; i++) {
			System.out.print(odds[i] + " ");

		}
		System.out.println();

		// 문자열 "Hello", "안녕하세요", "Bon jour"를 저장하는 배열 :
		// 요즘은 제일 자주 쓰이는 배열 문법
		String[] array = { "Hello", "안녕하세요", "Bon jour" }; // new String[] { "" }
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " : ");
		}

		System.out.println();

		// 향상된 for 문장(enhanced for statement) : for-each 구문.
		// for (변수 선언 : 배열이름) { 실행문; }
		for (String s : array) { // 0번 원소 순서대로 s에 저장하고 차례대로 출력
			// 배열에 순서대로 꺼내는 것 원소 1개를 저장하려면 변수타입에 맞춰 들어가기에 하나만 
			System.out.print(s + " | ");
		}

		System.out.println();

		// 배열 odds의 모든 원소들을 향상된 for 문장을 사용해서 순서대로 출력.
		
		for (int n : odds) { // 변수를 선언하는이유는 배열에서 원소하나를 꺼냈을때 그 원소를 저
			//저장할 수 있는 타입이어야 한다.
			System.out.print(n + " | ");
		}
		
		System.out.println();
		
		
		boolean [] booleanArray = {true, false, false, true};
		
		for (boolean b : booleanArray) {
			System.out.print(b + " | ");
		}
	}

}

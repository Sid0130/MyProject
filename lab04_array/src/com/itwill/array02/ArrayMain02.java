package com.itwill.array02;

public class ArrayMain02 {

	public static void main(String[] args) {
		// 배열 선언과 초기화 1:
		// 타입[] 변수이름 = new 타입[원소 개수];
		// -> 배열의 모든 원소들을 그 타입의 기본값으로 초기화해줌.
		// -> 정수의 기본값 0, 실수의 기본값 0.0, boolean의 기본값은 false, 자바의 기본타입 8개
		// 그 이외의 나머지 모든 타입의 기본값은 null.
		
		// **************************
		int[] integerArray = new int[3]; // 배열을 만들겠다. 원소 3개짜리로 ex) 3개짜리 4바이트 크기로 12바이트 로 만들겠다
		// 새로 만든것은 점부 0으로 채워져있다. 이 배열을 가르키는 이름이 변수이름 integerArray라고 정했다.
		for (int i = 0; i < integerArray.length; i++) { 
			System.out.print(integerArray[i] + " ");
			// 각각 기본값 0 0 0 으로 출력된다
		}
		System.out.println();
		System.out.println(integerArray);
		
		// ******* 배열의 특정 인덱스(위치)의 값을 변경: array[index] = value; *******
		
		integerArray[0] = 100; // 배열에서 몇번째위치 인덱스를 찾아가서 대입해라라는 말
		integerArray[1] = 50; // 1번위치를 50으로 바꿔라
		for (int i = 0; i < integerArray.length; i++) {
			System.out.print(integerArray[i] + " ");
		} // 인덱스 0번은 100 1번은 50 2번은 0 기본값으로 출력된다.
		System.out.println();
		
		// 인덱스는 항상 int 타입 그리고 인덱스는 항상 0으로 시작.
		// boolean 4개를 저자하는 배열을 선언, (기본값으로) 초기화 :
		boolean [] booleanArray = new boolean[4]; 
		for (int i = 0; i < booleanArray.length; i++ ) {
			System.out.print(booleanArray[i] + " ");
		}
		System.out.println();
		booleanArray[1] = true;
		booleanArray[2] = true;
		for (int i = 0; i < booleanArray.length; i++ ) {
			System.out.print(booleanArray[i] + " ");
		}
	}

}

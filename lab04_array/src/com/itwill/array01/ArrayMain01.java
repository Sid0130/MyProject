package com.itwill.array01;

public class ArrayMain01 {

	public static void main(String[] args) { //args 라는 변수의 문자열 배열이다
		// 시험 점수를 저장하는 변수들 :
		int score1 = 100;
		int score2 = 91;
		int score3 = 95;
		int score4 = 80;
		
		
		// 총점 : 
		int total = score1 + score2 + score3 + score4;
		System.out.println("총점 : " + total);
		
		// 평균 :
		double average = (double) total / 4; 
		System.out.println("평균 : " + average);  // 이렇게 했을때 수가 늘어나면 엄청 번거로울 것이다.
		
		
		// 배열(array) : "같은" 타입의 값(데이터) 여러개를 하나의 변수 이름으로 저장하기 위한 타입.
		// 인덱스(index) : 배열에 값을 저장하거나, 저장된 값을 읽어올 때 사용하는 정수.
		// 	- 배열에서 값이 저장된 위치를 나타내는 정수.
		// 	- 배열의 인덱스는 0부터 시작하는 연속된 정수.
		// 	- 배열의 마지막 인덱스 : (배열 원소 개수) - 1.
		
		// 타입 [] 변수 = {  ... }
		int[] scores = {100, 91, 95}; // 값들을 나열한 것 코드 블록이 아님.
		System.out.println(scores[0]); // 배열의 첫번째 원소 출력
		
		
		// 모든 배열은 저장된 원소 개수를 알 수 있는 length 라는 속성이 있음.
		System.out.println("length = " + scores.length); // 배열의 길이라고하는 속성으로 자동으로 계산.
		
		// for 반복문을 사용해서 배열 scores의 모든 원소들을 순서대로 출력
		for(int i = 0; i < scores.length; i++) { //변수는 배열의 인덱스 배열의 길이보다 인덱스는 작다. 
			// 인덱스는 1씩 증가한다 그러면 스코어를 하나씩 출력
			System.out.println(scores[i]);
		}
		
	}

}

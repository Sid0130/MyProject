package com.itwill.array04;

import java.util.Scanner;

public class ArrayMain04 {

	public static void main(String[] args) {
	    // 성적 처리 프로그램:
        // 정수 5개를 저장할 수 있는 배열을 선언, (기본값으로) 초기화.
        // 콘솔 입력을 받기 위해 Scanner 타입 변수를 선언.
        // for 문장을 사용해서, 시험 점수(정수)를 입력받고 배열에 저장(5번 반복). 
        // 향상된 for 문장을 사용해서 배열에 저장된 값들을 출력.
        // 배열에 저장된 시험 점수들의 총점을 계산하고 출력.
        // 배열에 저장된 시험 점수들의 평균을 계산하고 출력.
		
		int [] array = new int[5]; 
		Scanner scanner = new Scanner(System.in);
		
		for (int n = 0; n < array.length; n++) {
			System.out.print("점수를 입력하세요 > ");
			array[n] = scanner.nextInt();
		}
		int sum = 0;
		for (int n : array) {
			sum += n;
			System.out.print(n + " ");
		}
		
		System.out.println();
		
		double average = (double) sum / array.length;
		System.out.println("총점 = " + sum);
		System.out.println("평균 = " + average);
		
		// 배열 개수만 바꿔주면 인원 늘리거나 줄이거나 할 수 있다.
	}

}

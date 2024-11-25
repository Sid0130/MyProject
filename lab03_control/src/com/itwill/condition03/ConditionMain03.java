package com.itwill.condition03;

import java.awt.MediaTracker;
import java.util.Scanner; //Sanner 타입 이름을 가져옴.
//기본타입 8개가아닌 다른타입의 이름을 가져올 때 

public class ConditionMain03 {

	public static void main(String[] args) {
		// Scanner 타입 변수 선언, 초기화 :
		Scanner scanner = new Scanner(System.in); //콘솔창에서 입력을 받을 수 있는 도구
		
		// 국어 점수를 입력 받고 저장.
		System.out.print("국어 점수 입력 >>> "); 
		int korean = scanner.nextInt();	//입력도구 정수를 입력받겠다.
		// 영어 점수를 입력 받고 저장.
		System.out.print("영어 점수 입력 >>> ");
		int english = scanner.nextInt();
		// 수학 점수를 입력 받고 저장.
		System.out.print("수학 점수 입력 >>> ");
		int math = scanner.nextInt();
		
		//ctrl + space : 코드 추천. 자동완성.
		System.out.println("국어: " + korean);
		System.out.println("영어: " + english);
		System.out.println("수학: " + math);
		
		
		//int sum = korean + english + math;
		
		//System.out.println(sum);
		
		//double average = sum/3; //average 또는 mean
		//System.out.println(average);
		
		double average = (korean + english + math) / 3.0; //이 연산자는 정수나누기 정수만 하기에
		//몫만 계산하기에 타입변환하거나 뒤에 소수점을 적어준다.
		//double average = (double) (korean + english + math) / 3; 
		System.out.println("평균: " + average);
		
		if (average >= 90) {
			System.out.println("A");
		} else if (average >= 80) {
			System.out.println("B");
		} else if (average >= 70) {
			System.out.println("C");
		} else {
			System.out.println("F");
		}
			
		// 세 과목의 점수를 출력.
		// 세 과목의 평균을 (소수점까지) 계산해서 (double타입) 변수에 저장. 국영수/3
		// 평균을 출력.
		// 평균이 90점 이상이면, "A" 라고 출력.
		// 평균이 80점 이상이면, "B" 라고 출력.
		// 평균이 70점 이상이면, "C" 라고 출력.
		// 평균이 70점 미만이면, "F" 라고 출력.
		

	}

}

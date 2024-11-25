package com.itwill.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
        final int LENGTH = 10; // final 로 선언하게되면 값을 변경할 수 없는 변수다.
        
		// 난수를 생성하는 Random 타입 변수를 선언하고, 초기화.
        
		Random rand = new Random();
		
        // 정수(int) 10개를 저장할 수 있는 배열 codes를 선언하고, (기본값으로) 초기화.
		
		int[] codes = new int[10];

		// for 문장을 사용해서, 배열 codes에 1 이상 4 이하의 정수 난수들을 저장(10번 반복).
		for (int i = 0; i < codes.length; i++) {
			codes[i] = rand.nextInt(1, 5);
		}

		for (int i : codes) {
			System.out.print(i + "\t");
		}

		System.out.println();

		String[] genders = new String[10];
		
		for (int i = 0; i < genders.length; i++) {
			String s = (codes[i] == 1 || codes[i] == 3) ? "남성" : "여성"; // 삼항연산자.
			genders[i] = s;
		}
		
		for(String g : genders) {
			System.out.print(g + "\t");
		}
//			if (codes[i] == 1 || codes[i] == 3) {
//				System.out.print("남성\t");
//			} else {
//				System.out.print("여성\t");
//			}
		
		
//		switch(codes[i]) {
//		case 1, 3:
//			s ="남성";
//			break;
//		case 2, 4:
//			s = "여성";
//			break;
//			
//		}
		
		int i = 0;
		for(int c : codes) {
			genders[i] = (c == 1 || c == 3) ? "남성" : "여성";
			i++;
		}

	}

}

package com.itwill.loop03;

public class LoopMain03 {

	public static void main(String[] args) {
		/*
		 *  (문제 1) 아래와 같이 구구단 2단을 출력.
		 *  2 x 1 = 2
		 *  2 x 2 = 4
		 *  2 x 3 = 6
		 *  ...
		 *  2 x 9 = 18
		 */
		
//		for(int n = 2; n <= 9; n++) {
//			System.out.println("구구단 " + n + "단");
//			for(int i=1; i <= 9; i++) {
//				System.out.println(n + " x "+ i + " = "  + n * i + " ");
//			}
//			System.out.println();
//		}
		
		for (int n = 1; n < 13; n++) {
//			System.out.println("2 x " + n + " = " + (2*n));
			
			System.out.printf("2 x %d = %d\n", n, n * 2);
		}
		
		/*
		 *  (문제 2) 아래와 같이 1 ~ 100까지 숫자들을 한 줄에 10개씩 출력.
		 *  1	2	3	4	5	6	7	8	9	10
		 */
		
		for (int n = 1; n <= 100; n++) {
			if (n == 11) {
				System.out.println();
			} else if (n == 21) {
				System.out.println();
			} else if (n == 31) {
				System.out.println();
			} else if (n == 41) {
				System.out.println();
			} else if (n == 51) {
				System.out.println();
			} else if (n == 61) {
				System.out.println();
			} else if (n == 71) {
				System.out.println();
			} else if (n == 81) {
				System.out.println();
			} else if (n == 91) {
				System.out.println();
			} 
			System.out.print(n + " ");			
		}
		System.out.println();
		
		for (int n = 1; n <= 100; n++) {
			System.out.print(n + "\t");
			if (n % 10 == 0) {
				System.out.println();
			}
		}
		
	}

} 

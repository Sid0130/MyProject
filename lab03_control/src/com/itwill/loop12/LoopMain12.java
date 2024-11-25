package com.itwill.loop12;

public class LoopMain12 {

	public static void main(String[] args) {

		// while 반복문 사용
		// [1] 1 + 2 + 3 + ... + 9 + 10 결과 출력

		int sum = 0;

		int n = 1;
		while (n <= 10) {
			sum += n;
			n++;
		}
		System.out.println("1 ~ 10 합 = " + sum);

		// [2] 1 + 3 + 5 + 7 + 9 결과

		sum = 0;
		n = 1;
		while (n <= 10) {
			sum += n;
			n += 2;
		}
		System.out.println("1 ~ 10 홀수 합 = " + sum);

		// [3] 2 + 4 + 6 + 8 +10 결과

		sum = 0;
		n = 1;
		while (n <= 10) {
			if(n % 2 == 0) {
				sum += n;
			}
			n++;
		}
		System.out.println("1 ~ 10 짝수 합 = " + sum);

	}

}

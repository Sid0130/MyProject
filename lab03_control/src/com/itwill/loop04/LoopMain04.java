package com.itwill.loop04;

public class LoopMain04 {

	public static void main(String[] args) {
        /* (문제 1) 369게임: 아래와 같이 출력하세요.
        1   2   *   4   5   *   7   8   *   10
        11  12  *   14  15  *   17  18  *   20
        21  22  *   24  25  *   27  28  *   *
        *   *   *   *   *   *   *   *   *   40
        41  42  *   44  45  *   47  48  *   50
        51  52  *   54  55  *   57  58  *   *
        *   *   *   *   *   *   *   *   *   70
        71  72  *   74  75  *   77  78  *   80
        81  82  *   84  85  *   87  88  *   *
        *   *   *   *   *   *   *   *   *   100
    */

		
		// for 문 안에 ( ; ; ) 세미콜론은 무조건 있어야한다.
		for (int n = 1; n <= 100; n++) {
			
			if ((n % 10 == 3) || (n % 10 == 6) || (n % 10 == 9) || 
					(n / 10 == 3) || (n / 10 == 6) || (n / 10 == 9)){
				System.out.print("*" + "\t");
			} else {
				System.out.print(n + "\t");
			}
			
			
			if (n % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n");

		
		
		// 3 6 9 를 배수로 생각하면 안되고 자릿수로 생각해야한다
		// 10으로 나눈 몫과 나머지를 생각해야한다.
		for (int n = 1; n<=100; n++) {
			int x = n % 10; // n 을 10으로 나눈 나머지 - > 1의 자릿수.
			int y = n / 10; // n 을 10으로 나눈 몫 - > 10의 자릿수.
			
			boolean b1 = x == 3 || x == 6 || x == 9; // 1의 자릿수가 3, 6 ,9 이면
			boolean b2 = y == 3 || y == 6 || y == 9; // 10의 자릿수 3, 6 ,9 이면
			
			if(b1 && b2) {
				System.out.print("**\t");
			}else if(b1 || b2) {
				System.out.print("*\t");
			} else {
				System.out.print(n + "\t");
			}
			
			if(x == 3 || x == 6 || x == 9 || y == 3 || y == 6 || y == 9) {
				System.out.print("*\t");
				
			} else { 
				System.out.print(n + "\t");
			}
			
			if (n % 10 == 0) { // 출력한 숫자가 10의 배수이면 줄바꿈을 넣자.
				System.out.println();
			}
		}
		
		
		
		
		
		
    /* (문제 2) 1부터 100까지의 정수들의 합: 5050 */
		int sum = 0; // 메인 안에 속해있는 변수
		for (int n = 1; n <= 100; n++) { //블록 안에서만 속해있는 변수
			sum = sum + n;
		}
		System.out.println(sum);
    /* (문제 3) 1부터 100까지의 정수들 중 3의 배수들의 합: 1683 */

		int num = 0;
		for (int n = 1; n <= 100; n++) {
			if(n % 3 == 0) {
				num = num + n;
			}
		}
		System.out.println(num);

		
		sum = 0;
		for (int n = 3; n < 100; n += 3) {
			sum += n;
		}
		System.out.println("1 ~ 100 사이의 3의 배수들의 합 = " + sum);
		
		
	}

}

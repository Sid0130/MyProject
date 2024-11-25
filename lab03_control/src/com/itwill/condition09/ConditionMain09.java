package com.itwill.condition09;

import java.util.Random;

public class ConditionMain09 {

	public static void main(String[] args) {
		// Random 타입 : 난수를 만들어 주는 도구. 
		Random rand = new Random(); // 랜덤은 기본타입이 아니라 import를 해야하고 변수는 만들어줌
				// 기본 타입이 아닐때 대문자로 시작하고 변수를 새로 만들어야함 new
		
		
//		int number = rand.nextInt(); //nextInt() : int 범위의 난수를 생성.
//		System.out.println(number);
//		
//		number = rand.nextInt(10); //nextInt(bound) : 0 이상 bound 미만의 난수를 생성.
//		System.out.println(number);
//		
//		number = rand.nextInt(1, 3); //nextInt(a,b) : a 이상 b 미만의 난수를 생성.
//		System.out.println(number);  //자바에서 99% a보다는 포함이고 b는 미포함

		// 주사위 2개를 던짐. 
		
		int dice1 = rand.nextInt(1, 7); // 1 이상 7 미만 난수
		int dice2 = rand.nextInt(1, 7); // 1 이상 7 미만 난수

		// 두 주사위의 숫자의 차를 출력. 
		System.out.printf("(%d,%d)\n", dice1, dice2);
		

		System.out.println(dice1);
		System.out.println(dice2);
//		System.out.println(dice1 - dice2);
		
		int diff;
		if (dice1 > dice2) {
			diff = dice1 - dice2;
		} else {
			diff = dice2 - dice1;
		} 
		System.out.println(diff);
		
		int diff2 = (dice1 > dice2) ? (dice1 - dice2) : (dice2 - dice1);
		System.out.println(diff2);
		
		
		
		
 		if (dice1 > dice2) {
 			System.out.println(dice1 - dice2);
 		} else {
			System.out.println(dice2 - dice1);

		}
	}

}

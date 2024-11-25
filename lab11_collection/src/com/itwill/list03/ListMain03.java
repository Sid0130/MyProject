package com.itwill.list03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ListMain03 {

	public static void main(String[] args) {
		// 1. 정수를 저장할 수 있는 List(ArrayList 또는 LinkedList)를 선언(numbers), 객체 생성.
		LinkedList<Integer> numbers = new LinkedList<Integer>();		
		Random rand = new Random();	
		
		
        // 2. numbers에 [0, 100) 범위(0 이상 100 미만)의 난수 20개를 저장.
		
	
		for(int i = 0; i < 20; i++) {
			int x =	rand.nextInt(100);
			numbers.add(x);
		}
		System.out.println(numbers);
        // 3. numbers를 출력.
        // 4. 정수를 저장할 수 있는 List를 선언(odds), 객체 생성.
		ArrayList<Integer> odds = new ArrayList<Integer>();
        // 5. numbers에 저장된 숫자들 중에서 홀수들을 찾아서 odds에 저장.
		
		for(Integer x : numbers) {
			if(x % 2 == 1) {
				odds.add(x);
			}
		}
		System.out.println(odds);
        // 6. odds를 출력.
        // 7. 정수를 저장할 수 있는 ArrayList를 선언(evenSquares), 객체 생성.
		ArrayList<Integer> evenSquares = new ArrayList<Integer>();
		
		for(Integer x : numbers) {
			if(x % 2 == 0) { // 나눌때 언박싱
				evenSquares.add(x * x);
			}											
		}
		System.out.println(evenSquares);
		// 8. numbers에 저장된 숫자들 중에서 짝수를 찾아서 짝수의 제곱을 evenSquares에 저장.
        // 9. evenSquares를 출력.

	}

}

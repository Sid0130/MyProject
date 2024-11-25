package com.itwill.set02;

import java.util.HashSet;
import java.util.Random;

public class SetMain02 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
				
		// 정수를 저장하는 HashSet을 선언, 초기화.
		HashSet<Integer> numbers = new HashSet<>();
		
		//[0, 10) 범위의 난수 5개를 HashSet에 저장. [ 이상 ) 미만
		//호출할때마다 같은 숫자가 만들어질 수 있음.
		
		
		while(numbers.size() < 5) {
			int x = rand.nextInt(10);
			System.out.println("x = " + x);
			
			numbers.add(x);
			System.out.println(numbers);
		}
		
		
		
		
//		while(true) {
//			int s = rand.nextInt(10);
//			numbers.add(s);
//			if(numbers.size() == 5) {
//				break;
//			}
//		}
//		System.out.println(numbers);	
//		
		
		// HashSet의 원소들을 출력.
		
	}

}

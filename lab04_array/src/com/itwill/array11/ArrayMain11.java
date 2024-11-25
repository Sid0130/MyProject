package com.itwill.array11;

import java.util.Random;

public class ArrayMain11 {

	public static void main(String[] args) {
		// 2차원 배열 연습 :
		
		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언, (기본값으로) 초기화.
		
		int[][] array = new int[3][];
		
		// 난수를 만들기 위해서, Random타입 변수를 선언, 초기화.
		Random rand = new Random();
		
		// 2차원 배열의 첫번째 원소(1차원 배열)는 난수 2개를 저장하는 1차원 배열.
		// 2차원 배열의 두번째 원소는 난수 3개를 저장하는 1차원 배열.
		// 2차원 배열의 세번째 원소는 난수 4개를 저장하는 1차원 배열.
//		array[0] = new int[2];
//		array[1] = new int[3];
//		array[2] = new int[4];
		
//		for(int[] arr : array) {
//			for(int x : arr) {
//				System.out.print(x + " ");
//			}
//			System.out.println();
//		}
		
		// 난수의 범위는 0 이상 10 미만
		for (int i = 0; i < array.length; i++) {
			array[i] = new int[i+2]; // 규칙이있다면 for 문 안에 넣어서 저장개수를 만들면 된다
			for(int j = 0; j <array[i].length; j++) {
				array[i][j] = rand.nextInt(0,10);
//				System.out.print(array[i][j] + " ");
			}
//			System.out.println();
		}
		// 2차원 배열의 모든 원소들을 출력.
		for(int[]arr : array) {
			for(int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		
		
		int sum = 0;
//		for (int i = 0; i < array.length; i++) {
//			for(int j = 0; j < array[i].length; j++) {
//				sum += array[i][j];
//			}
//		}
		
		for(int[]arr : array) {
			for(int x : arr) {
				sum += x;
			}
		}
		System.out.print("sum = " + sum);
		
		
		// 2차원 배열에 저장된 9개 숫자들의 합을 계산하고 출력.
		System.out.println();
		
		int max = array[0][0];
		for (int[] arr : array) {
			
			for(int x : arr) {
				if(x > max) {
					max = x;
				} 
			}			
		}
		System.out.print("최댓값 = " + max);
		// 2차원 배열의 저장된 9개 숫자들 중에서 최댓값을 찾고 출력.
	}

}

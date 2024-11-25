package com.itwill.array06;

public class ArrayMain06 {

	public static void main(String[] args) {
		int a = 1;
		int b = a;
		System.out.println("a=" + a + ", b=" + b);
		
		b = 2;
		System.out.println("a=" + a + ", b=" + b);
		// 향상된 for 문 상용할 때 주의점 :
		// 향상된 for 블록 안에서는 배열 원소의 값을 변경할 수 없음!
		// 값을 읽어오는 용도로만 사용.
		int [] array = new int[5];
		for (int x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		for (int x : array) { // 배열의 첫번째 값을 x에 저장  for문 안에서 사용되는 지역변수
			x = 100; // 지역변수 x의 값을 변경. 배열 array의 원소를 변경한 것은 아님!
		}
		
		
		for (int x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		for (int i = 0; i <array.length; i++) {
			array[i] = i; // 배열 array의 인덱스 i번째 위치의 원소의 값을 변경.
		}
		
		for (int x : array) {
			
			System.out.print(x + " ");
		}
		System.out.println();
	}

}

package com.itwill.loop11;

public class LoopMain11 {

	public static void main(String[] args) {
		//	세미콜론은 꼭!
		// for (.. ; 조건식 ; ...)    반복문과 while (조건식) 반복문은 
		// 블록({...})을 실행하기 전에 조건을 먼저 검사하기 때문에,
		// 처음부터 조건식이 false 가 되는 경우에는 블록이 한번도 실행되지 않을 수 있음.
		int x = 1; 
		while (x < 0) { // 실행이 될수있고 안될수있다.
			System.out.println("x = " + x);
			x--;
		}
		
		// do - while
		
		// do {...} while (조건식);
		int y = 1;
		do {		// 먼저 한번 실행된다. 
			
			System.out.println("y = " + y);
			y--;
			
		} while (y < 0); // 마지막 세미콜론은 반드시 적어준다.

	}
	

}

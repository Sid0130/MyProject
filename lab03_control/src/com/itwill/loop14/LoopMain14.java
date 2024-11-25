package com.itwill.loop14;

public class LoopMain14 {

	public static void main(String[] args) {
		
		// 교재 연습문제 5
		
		for (int x = 1; x <= 4; x++) { // x : line 번호
			for(int y = 1; y <= x; y++) {	// y : 출력할 "*"의 개수
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("----------------------");
		
		for(int x = 1; x<=4; x++) { // x : 줄 번호
			for(int y=1; y<=4; y++) { // y : 출력할 *의 개수
				System.out.print("*");
				if(y == x) { // 출력한 * 개수가 줄 번호와 같으면
					break; // 출력을 멈춤.
				}
			}
			System.out.println();
		}
		
		System.out.println("----------------------");
		
		// 교재 연습문제 6.
		
		for (int x = 1; x <= 4; x++) { // x : 줄 번호 1 ~ 4    	행(가로) 번호
			for(int y = 1; y <= 4; y++) {	// y : print() 를 호출할 개수 1 ~ 4 열(세로) 번호
				if (y <= 4 - x) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
				
			}
			System.out.println();
		}
		
		
		System.out.println("----------------------");

		for (int x = 1; x <= 4; x++) {
			for (int y = 4; y >= 1; y--) {
				if (y > x) { 	// 감소시키는 방향 
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		System.out.println("----------------------");

		for (int x = 1; x <= 4; x++) { // x : 줄 번호
			for(int y = 1; y <= 4 - x; y++) { // y : 공백 개수
				System.out.print(" ");
			}
			for(int y = 1; y <= x; y++) { // y : *의 개수
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		


		
		
	
			// 6번 4칸 건너고 * 
			// 3칸 건너구 **
			// 
		// 챕터 5장 참조타입에서 배열을 먼저 열거타입은 enum 은 나중에
		// 챕터 5장은 배열까지만 
		
		
		// 6장 메서드 -> 필드 생성자 -> 
	}

}

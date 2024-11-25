package com.itwill.exception05;

import java.util.Scanner;

public class ExceptionMain05 {
	
	private Scanner scanner = new Scanner(System.in);
	
	private int inputInteger() {
		int input = 0;
		while(true) {
			try {
				System.out.print("입력 > ");
				input = Integer.parseInt(scanner.nextLine());				// 여기서 타입을 쓰면 밖에 리턴이 오류
				//지역변수는 사용범이가 블록안이기 때문에
				
				break; // 무한 반복문(while (true))을 끝냄.
			} catch (NumberFormatException e) {
				System.out.println("입력값은 정수여야 합니다.");
				System.out.println(e.getMessage());
			} finally {
				
			}
		}
		return input;
				
	}

	// 재귀 메서드(recursive method)
	private int inputInteger2() { //리턴타입이 있으면 반드시 리턴이 한번은 실행.
		try {
			System.out.print("정수 입력> ");
			int x = Integer.parseInt(scanner.nextLine());
			return x;
		} catch (NumberFormatException e) { // 캐치에서 리턴을 안할 수 있다.
			System.out.println("입력값은 정수...");
			return inputInteger2(); // 메서드 재귀 호출. 메서드 자기 자신을 다시 부르는 것 재귀메서드
			// 메서드 자기자신으로 다시가서 입력값을 받으면 리턴x는 캐치에 있는 리턴으로 넘어가고 메인으로 간다.?
			
		}
	}
	
	
	
	public static void main(String[] args) {
		ExceptionMain05 app = new ExceptionMain05();
//		int result = app.inputInteger();
		int result = app.inputInteger2();
		System.out.println("입력한 정수 = " + result);
		
		
	}

}

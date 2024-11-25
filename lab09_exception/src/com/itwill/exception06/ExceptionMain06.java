package com.itwill.exception06;

import java.util.Scanner;

/*
 * throws 선언문이 있는 메서드들 중에서 모든 메서드 중에서 
 * RuntimeException을 상속하는 예외 타입들은 try-catch를 사용하지 않아도 컴파일 에러가 없음.
 * (예) NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException, ...
 * 
 * RuntimeException을 상속하지 않는 예외 타입들은 반드시 
 * (1) try-catch 문장을 사용하거나, 또는
 * (2) throws 선언문을 추가해야 됨.
 * (예) IOException, SQLException, ...
 * 
 */

public class ExceptionMain06 {

	public static void main(String[] args)  {
		// Caluclater 타입 객체 생성
		Calculator calc = new Calculator();
		try {
			int result = calc.divide(123, 0); // 
			System.out.println("result = " + result);
		} catch (Exception e) {
			e.printStackTrace(); // Exception 발생한 위치를 프린트
		} // throws Exception을 써주거나 try-catch를 써야한다 
		
		try {
			int age = inputAge();
		} catch (AgeFormatException e) {
			e.printStackTrace();
		}
		  // 예외 메서드를 사용하는곳에서 예외를 넣거나 아니면 트라이캐치로 묶음.
	}
	
	
	public static int inputAge() throws AgeFormatException{ //런타임인셉션이어야 에러가 안남
		
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("나이 입력 >");
			int age = Integer.parseInt(scanner.nextLine());
			if(age >= 0) {
				return age;
			} else {
				throw new AgeFormatException();			
			} 
			
		}catch (NumberFormatException e) {
			System.out.println("나이는 정수로 입력...");
			return 0;
		}
			
	}

}

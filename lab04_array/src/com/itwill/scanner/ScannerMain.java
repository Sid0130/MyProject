package com.itwill.scanner;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		// Scanner 의 여러가지 메서드(method) : Scanner 타입 변수에서 사용할 수 있는 기능들.
		// nextInt() : 입력 버퍼(입력값들을 저장하는 임시 메모리) 에서
		// 공백 문자(스페이스, 탭, 엔터)로 구분된 입력값(토큰)을 읽어서 int 타입으로 반환.
		// 읽은 값(토큰)은 입력 버퍼에서 지움.
		// nextDouble() : 입력 버퍼에서 토큰을 읽어서 double 타입으로 반환. 읽은 값은 지움.
		// next() : 입력 버퍼에서 토큰을 읽어서 문자열(String) 타입으로 반환. 읽은 값은 지움.
		// 공백을 포함하는 문자열을 읽을 수는 없음. 한 단어만 읽을 수 있음.
		// nextLine() : 입력 버퍼에서 엔터를 만날 때까지 모든 값을 읽고 문자열을 반환.
		// 입력 버퍼의 모든 내용을 지움!
		Scanner scanner = new Scanner(System.in);

		System.out.print("메뉴 선택 > ");
		int menu = scanner.nextInt();
		System.out.println("menu = " + menu);

		System.out.print("학생수 입력 > ");
		int studentNum = scanner.nextInt();
		System.out.println("studentNum = " + studentNum);

		System.out.print("실수 입력 > ");
		double x = scanner.nextDouble();
		System.out.println("x = " + x);
		
		System.out.print("이름 입력 > ");
		String name = scanner.next();
		System.out.println("name = " + name);
		
		System.out.println("이메일 입력 > ");
		String email = scanner.next();
		System.out.println("email = " + email);
		// 입력 값에서 공백이 있으면 입력 버퍼가 비워있지 않아서 생길수 있는 문제가 있다.
		// 자기가 읽은것까지만 지우고 공백은 남겨둔다.
		
		// 입력 버퍼 항상 마지막은 엔터가 남아있다.
		
		
		scanner.nextLine(); // 입력 버퍼에 남아 있는 내용을 읽고, 버퍼를 깨끗이 지움. 
		//트릭
		
		System.out.print("메모 입력 > ");
		String memo = scanner.nextLine();
		System.out.println("memo = " + memo);
		// next 의 마지막 엔터가 남겨둬서 nextLine 은 바로 끝난다
		// nextLine은 엔터가 만나면 끝나기 때문에.
		// 정크를 싹 다 지우는게 nextLine
		// nextLine 은 문자열이기 때문에 정수,실수 등 변환하는 작업이 필요하다.
		// 섞어서 쓰는건 권장하지 않는다 실수를 할 확률이 높아서
	}

}

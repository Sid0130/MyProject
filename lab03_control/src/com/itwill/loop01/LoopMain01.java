package com.itwill.loop01; // 패키지 선언

public class LoopMain01 { //클래스 선언
						// enum 의 이름과 자바파일의 이름이 같아야한다
	public static void main(String[] args) { // 프로그램의 시작
		
		System.out.println("Java 1");
		System.out.println("Java 2");
		System.out.println("Java 3");
		System.out.println("Java 4");
		System.out.println("Java 5");
		
		// 비슷한 일을 여러번 반복하기 위해서
		
		System.out.println("-----------------------");
		
		// for 반복문
		for (int n = 1; n <= 5; n--) { // ~동안에 // 괄호안에는 세미콜론 두개만!.
			System.out.println("java " + n);
		}
		
		
		// 증가/감소 연산자 : ++(값을 1 증가), --(값을 1 감소).  정수에서만 사용가능
		// 증가/감소 연산자는 변수의 앞 또는 뒤에서 사용 가능 : ++n, n++
		// 증가/감소 연산자가 변수 앞에 사용된 경우에는 다른 연산보다 먼저 증가/감소 연산이 수행.
		// 증가/감소 연산자가 변수 뒤에 사용된 경우에는 다른 연산을 수행한 후에 증가/감소가 수행.
		int a = 1;
		int b = 1;
		int c = a + ++b; // b++; c = a + b;
		System.out.println("b = " + b + ", c = " + c);
		
		b = 1;
		c = a + b++; // c = a + b; b++;
		System.out.println("b = " + b + ", c = " + c);
		
		// 복합 할당(대입) 연산자 : +=, -=, *=, /=, %=, ...
		int x = 1;
		System.out.println("x = " + x);
		
		// x++;
		// x += 1;
		// x = x + 1;
		
		x += 2; // x = x + 2;
		System.out.println("x = " + x);
		
	}

}

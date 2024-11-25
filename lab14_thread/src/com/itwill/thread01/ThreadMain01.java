package com.itwill.thread01;

import java.util.Iterator;

/*
 * 쓰레드 사용법 1
 * 1. Thread 클래스를 상속하는 클래스를 선언.
 * 2. 1.에서 선언한 클래스에서 run() 메서드를 override(재정의) - 쓰레드가 할 일.
 * 3. 2.에서 작성한 클래스의 객체를 생성.
 * 4. 3.에서 생성한 객체의 start() 메서드를 호출 -> 쓰레드가 실행됨.
 * 
 * (주의) Thread 타입 객체의 run() 메서드를 직접 호출하면 안 됨!!!
 * 이유: start() 호출 - JRE에서 쓰레드를 초기화(메모리 할당, 스케쥴링, ...) -> run() 자동 실행.
 */


public class ThreadMain01 {

	public static void main(String[] args) {
		// 1. Thread 클래스를 상속하는 클래스를 선언.
		class MyTread extends Thread{
			private String name;
			
			public MyTread(String name) {
				this.name = name;
			}
						
			// 2. run() 메서드를 override
			@Override
			public void run() {
				// 쓰레드 객체가 할 일을 작성.
				for(int i=0; i<100; i++) {
					System.out.println(i + ": " + name);
					try {
							
						sleep(100); // Thread.sleep(long ms) - 100ms=0.1초
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}
		} // end class Thread
		
		// 3. MyThread 타입 객체 생성
		
		MyTread th1 = new MyTread("쓰레드 I");
		MyTread th2 = new MyTread("Thread II"); // 각각 같이 일을 하고 끝나는 시간은 동일하고 한번씩 반복하기도 하고 연속해서 하기도 함.
		MyTread th3 = new MyTread("안녕하세요");
		
		
		long start = System.currentTimeMillis(); // 쓰레드 시작 시간.
		
		// 4. 쓰레드 객체의 strat() 메서드를 호출
		th1.start(); // 쓰레드 실행이 시작될 수 있도록 스케쥴만 잡아준다.
		th2.start();
		th3.start();
		
		try {
			th1.join(); // main 쓰레드(프로세스)가 th1 쓰레드가 끝날 때까지 기다림.
			th2.join(); // main 쓰레드(프로세스)가 th2 쓰레드가 끝날 때까지 기다림.
			th3.join(); 
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("경과 시간 = " + (end - start) + "ms");
		
		System.out.println("----- main() 종료 -----"); // 프린터와 별개의 프로세스로 메인은 먼저 끝나고 
		// 메인과 쓰레드가 끝났을때 프로그램이 끝나는 것이다.
		// 메인은 쓰레드가 끝났을때까지 기다리는 기능이 있는데 조인이라는 기능
		
		
		
		
		//th1.run()을 쓰게되면 단일 프로세스가 될거고 하나의 작업만 한다? 그래서 run을 실행시키면 안됨.
	} // end main()
}

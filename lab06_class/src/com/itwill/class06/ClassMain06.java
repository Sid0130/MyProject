package com.itwill.class06;

public class ClassMain06 {

	public static void main(String[] args) {
		
		Account acc1 = new Account(123456, 10_000);
		System.out.println(acc1);
		acc1.info();
	
		Account acc2 = new Account(1234567890, 100_000);
		System.out.println(acc2);
		acc2.info();
		
		// acc1 계좌에 100,000원 입금
		int balance = acc1.deposit(100_000);
		
		// acc1 계좌에서 10,000원 출금
		acc1.withdraw(10_000);
		acc1.info();
		
		// acc1 계좌에서 50,000원을 acc2 계좌로 이체.
		acc1.transfer(50_000, acc2);
		acc1.info();
		acc2.info();
	}
}

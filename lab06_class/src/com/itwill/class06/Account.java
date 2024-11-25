package com.itwill.class06;

/**
 *  은행 계좌 객체. 
 *  속성(필드): 계좌번호, 잔고
 *  기능(메서드): 입금, 출금, 이체, 정보 출력.
 */
public class Account {
	// field
	int accountNo; // 계좌 번호
	int balance; //잔고
	
	// constructor
	public Account(int accountNo, int balance) {
		this.accountNo = accountNo;
		this.balance = balance;		
	}
	
	// method
	/** TODO
	 *  deposit(입금). 현재 잔고에 입급액을 더하고, 입금 후 의 잔고를 리턴.
	 *  
	 *  @param amount 입금액(int).
	 *  @return 입금 후의 잔고(balance).
	 */
	
	public int deposit(int amount) {
		this.balance += amount;
		System.out.println("입금 후 잔고 : " + this.balance);
		return this.balance;		
	}
	
	/** TODO
	 *  withdraw(출금). 현재 잔고에 출금액을 빼고, 출금 후의 잔고를 리턴.
	 *  
	 *  @param amount 출금액(int)
	 *  @return 출금 후의 잔고.
	 */
	public int withdraw(int amount) {
		this.balance -= amount;
		System.out.println("출금 후 잔고 : " + this.balance);
		return this.balance;
	}
	/** TODO
	 *  transfer(이체). 내 계좌에서는 잔고에서 이체 금액을 빼고(출금),
	 *  이체할 계좌는 이체 금액을 더함(입금).
	 *  
	 *  @param amount 이체 금액(int)
	 *  @param to 이체할 계좌.(Account 타입!)
	 *  @return true.
	 */
	public boolean transfer(int amount, Account to) {
//		this.balance -= amount;
//		to.balance += amount;
		
		this.withdraw(amount); // 내 계좌에서 출금.
		to.deposit(amount); // 상대방 계좌에 입금.
		return true;
	}
	/** TODO
	 *  계좌 정보(계좌 번호, 잔고)를 출력.
	 */
	public void info() {
		System.out.println("----계좌 정보----");
		System.out.println("계좌 입력 : " + this.accountNo);
		System.out.println("계좌 잔고 : " + this.balance);
		
	}
}

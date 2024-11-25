package com.itwill.modifier01;

public class AccessExample {
	//field 
	private int a;
	int b;
	protected int c; // 같은 패키지거나 다른패키지에 갔을때는 상속을 해야 볼 수 있음.
	public int d;
	
	// constructor
	public AccessExample(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	//method
	public void info() {
		System.out.printf("a=%d, b=%d, c=%d, d=%d\n", 
				this.a,this.b,this.c,this.d);
	}
	
	
}

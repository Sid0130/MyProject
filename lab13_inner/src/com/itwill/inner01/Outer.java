package com.itwill.inner01;

public class Outer {
	// field
	
	private int x;
	private int y;
	private String s;
	
	
	// constructor
	public Outer(int x, int y, String s) {
		this.x = x;
		this.y = y;
		this.s = s;	
	}
	
	
	// method
	public int getX() {
		return x; //this.x 
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public String toString() {
		return String.format("Outer(x=%d, y=%d, s=%s)", x,y,s); // printf 와 비슷. 첫번째는 문자, 두번째는 가변길이 인수

	}
	
	// static이 아닌(non-static)멤버 내부 클래스
	public class Inner{
		//field
		private int x;
		
		//constructor
		public Inner(int x) {
			this.x = x;
		}
		

		//method
		public int getX() {
			return x;
		}
		
		public void info() {
			System.out.println("--- Inner class ---");
			System.out.println("Inner.x= " + x); // this.x 를 간단히 쓴것 this.x, Inner.this.x 를 간단히 쓴 것.

			System.out.println("Outer.x=  " + Outer.this.x); // this는 그 타입으로 생성된 객체, super는 부모타입
//			System.out.println(getX()); // 메서드 get 이름이 겹치면 외부 클래스를 못 불러옴 
			System.out.println("Outer.y= " + y); // this는 자기자신 클래스의 객체로 쓸 수 있는데 
			System.out.println("Outer.s= " + s); // Outer.this.s
			// 내부 클래스에서는 외부 클래스의 멤버 (필드/메서드)를 사용할 수 있음.  상속하지 않고 기능을 만들기 위해. 멤버들의 이름이 겹칠수있고 우선은 자기 클래스 
			// 우선적으로 접근하려면 멤버.this.변수이름 
			// ClassName.this: ClassName 타입으로 생성된 인스턴스.
			// ClassName.super: ClassName의 상위 타입 인스턴스.
			
			System.out.println("-------------------");
		}
	}
}

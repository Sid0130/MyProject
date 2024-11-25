package com.itwill.inner01;

public class Enclosing { // 바깥은 퍼블릭, 추상
	public static int version = 1; // static 필드
	private int x; // 인스턴스 필드

	public Enclosing(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x; //this.x 
	}

	@Override
	public String toString() {
		return String.format("Enclosing(x=%d, version=%d)", x, version);
		// 인스턴스 멤버(필드/메서드)는 static 멤버를 사용할 수 있다!
	}

	// static 멤버 내부 클래스(중첩 클래스, nested class)
	public static class Nested {
		private int x; // 인스턴스 필드
		
		public Nested(int x) {
			this.x = x;
		}

		public void info() {
			System.out.println("--- Nested class ---");
			System.out.println("Nested x= " + x); // this.x, Nested.this.x
			System.out.println("Enclosing.version= " + version); // Enclosing.version  static은 class 점(.) 을 사용함.
			//System.out.println(Enclosing.this.x); // 감싸고 있는 인스턴스(생성된 객체) 접근할 수 없다.
			//-> static 내부 클래스에서는 외부 클래스의 non-static 멤버를 사용할 수 없다!!
			//-> static 내부 클래스에서는 외부 클래스의 static 멤버들만 사용할 수 있음!!.
			System.out.println("--------------------");
		}
	}
}

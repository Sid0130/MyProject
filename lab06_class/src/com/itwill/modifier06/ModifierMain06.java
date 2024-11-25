package com.itwill.modifier06;

import javax.script.ScriptException;

// "java.", "javax."으로 시작하는 패키지 이름은 JDK에서만 사용 가능. JDK 이와에는 사용 불가.

/*
 * 접근 수식어 (Access Modifier)들은 클래스의 멤버(필드, 생성자, 메서드)에서만 사용 가능.
 * 지역변수에서는 접근 수식어를 사용할 수 없음.
 * 
 * final 수식어 : 
 * - 클래스, 클래스 멤버, 지역 변수에서 사용 가능.
 * - final 의미 : 바꿀 수 없는.
 * - final 필드/지역 변수 : 한 번 초기화가 되면 더 이상 값을 변경할 수 없는 변수. 상수(constant).
 * - final 필드는 반드시 
 * 	 (1) 선언과 동시에 초기화를 하거나 , 또는 
 * 	 (2) 생성자에서 final 필드를 명시적으로 초기화해야 함! 
 * - final class, final method 는 상속을 학습한 이후에..
 * 
 * 인스턴스 멤버(필드, 메서드) vs 정적(static) 멤버
 * 1.인스턴스 멤버(필드, 메서드)
 * 	 (1) static 수식어가 없는 멤버.
 * 	 (2) 객체를 생성한 후에 참조 변수를 이용해서 사용하는 멤버.
 *	 (3) 인스턴스 필드는 JRE(Java Runtime Environment, 자바 실행 환경)이 사용하는
 *	 메모리 영역 중에 힙(heap)에 생성됨.
 * 2.static 멤버(필드, 메서드)
 * 	 (1) static 수식어가 사용된 멤버.
 * 	 (2) 객체를 생성하지 않아도 사용할 수 있는 멤버.
 * 	 (3) 클래스 이름을 이용해서 사용하는 멤버. 
 *   (예) Math.PI, Math.random(), System.in, System.out, ...
 *	 (4) static 필드는 JRE가 사용하는 메모리 영역 중에 메서드(method) 영역에 생성됨.
 *	 (5) static 멤버들은 프로그램 main() 메서드가 호출되기 전에, 프로그램 로딩 시점에 메모리에 생성됨.
 *	 (6) static 메서드는 같은 클래스의 static 필드와 static 메서드만 사용 가능.
 *
 *
 */


public class ModifierMain06 {
	// final field
	private static final int VERSION = 1; //선언과 동시에 초기화한 final 필드
	
	
	private final String message; // 생성자에서 명시적으로 초기화할 final 필드 
	// 필드에서는 선언할때 반드시 생성자
	
	public ModifierMain06(String message) {
		this.message = message; // final 필드를 명시적으로 초기화
	}
	
	// 필드에 파이널을 선언할때는 동시에 초기화 하거나
	// 따로 만들 경우 반드시 생성자를 만들어서 초기화를 해야함
	
	
//	public void VERSION(int x) {
//		this.VERSION = x;
//	}
	
	
	// field
	private int x; 

	// setter 
	public void setX(int x) {
		this.x = x;
	}
	public static void main(final String[] args) {
		System.out.println(VERSION); // static 메서드는 static 필드를 사용할 수 있음.
//		System.out.println(x); // -> static 메서드는 static 이 아닌 필드를 사용할 수 없음!
		
//		private int a;
		
		int n = 0; 
		n = 100; // final이 아닌 변수는 언제든지 값을 재할당(변경)할 수 있음.
		
		final int version = 1; // 선언만 해놓고 나중에 값을 할당이 가능한데 값을 할당하고 난 뒤에는 변경을 할 수 없다!
//		version = 1;
		// version = 2; //-> final 지역 변수는 값을 재할당(변경)할 수 없음.
		
		// SaticExample 타입의 객체 생성 전
		// 클래스 이름으로 참조해서 static 필드를 사용할 수 있음.
		System.out.println("SaticExample.y = " + StaticExample.y);
		
		// 클래스 이름으로 참조해서 static 메서드를 호출할 수 있음.
		StaticExample.printFields2();

		// StaticExample 타입 객체 생성 :
		StaticExample ex1 = new StaticExample();
		ex1.printFields();
		
		StaticExample ex2 = new StaticExample();
		ex2.x = 123;
//		ex2.y = 456; // 문법적에서 허용은 하지만 권장은 하지 않는다. 
		// ex1.printFields(); 를 불렀을때 y값도 바뀌기 때문에 직접적으로 클래스 변수로 바꾸는게 좋음.
		StaticExample.y = 456; 
		ex2.printFields();  
		ex1.printFields();  
		
		// test() 메서드 호출?
		ModifierMain06 app = new ModifierMain06("비가 내린다");
		app.test();
		
		printVersion();
	}
	
	public void test() {
		System.out.println(this.message);
	}
	
	public static void printVersion() {
		System.out.println(VERSION);
	}

}

package com.itwill.method06;

public class MethodMain06 {

	public static void main(String[] args) {
		// 메서드 오버로딩(method over loading) :
		// 메서드의 파라미터가 다르면 같은 이름으로 메서드를 여러개 선언(정의)할 수 있음.
		// (주의) 메서드의 파라미터는 동일하고 리턴 타입이 다른 메서드는 오버로딩 할 수 없음!
		System.out.println("안녕하세요.");
		System.out.println(100);
		System.out.println();
		System.out.println(true);

		System.out.println("-------------");
		newLine();
		newLine(3);
		System.out.println("-------------");
	}

	/**
	 * 콘솔에 빈 줄 한개를 출력.
	 *  
	 */
	public static void newLine() {
		System.out.println();
	}
	
	// 파라미터가 동일하고, 리턴 타입(void, int) 만 다른 메서드는 오버로딩할 수 없음!
//	public static int newLine() { // 파라미터 선언이 달라야 오류가 안난다
//		System.out.println();
//		return 1;
//	}
	
	/**
	 * 콘솔에 빈 줄 n개를 출력.
	 * 
	 * @param n 출력할 빈 줄의 개수. 양의 정수.
	 * 
	 */
	public static void newLine(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}
}

package com.itwill.method03;

public class MethodMain03 {

	public static void main(String[] args) {
		// 반환값(return value)가 없는 메서드 작성 연습 :
		countdown(5); // 메서드 호출
		System.out.println("-------------");
		countdown(-5);
		
	}
	
	
	/**
	 * 양의 정수 start를 전달 받아서, 숫자를 1씩 감소하면서 0까지를 출력. 
	 * 아규먼트가 음의 정수이면, "양의 정수를 전달해야 함!"라는 메세지를 출력.
	 * @param start 카운트다운 시작 값. 양의 정수.
	 */
	public static void countdown(int start) {
		if(start <= 0) {
			System.out.println("양의 정수를 전달해야 함!");
			return; // 메서드를 종료. 메소드를 호출한 곳으로 되돌아감. 
			//return 0 은 타입이 선언되어있지 않으면 0은 되지않는다.
		} 
		for(int i = start; i >= 0; i--) {
			System.out.println(i);
		}
		
	}
	

}

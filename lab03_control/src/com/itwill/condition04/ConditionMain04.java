package com.itwill.condition04;

import java.util.Random;
import java.util.Scanner;

public class ConditionMain04 {

	public static void main(String[] args) {
		//가위바위보 게임	
		// 가위(0), 바위(1), 보(2)
		// 컴퓨터의 선택은 - 난수, 사용자의 선택 - Scanner(콘솔 입력)
		// 누가 이겼는 지 결과 출력. (조건)
		
  		// Random 타입의 변수를 선언, 초기화.
		Random rand = new Random(); // Random : 난수 (임의의 숫자)를 만들어 주는 도구.
		int computer = rand.nextInt(3); // 0 이상 3미만의 난수를 생성.
		
		// Scanner 타입의 변수를 선언, 초기화.
		Scanner scan = new Scanner(System.in);
		System.out.println("[0] 가위");
		System.out.println("[1] 바위");
		System.out.println("[2] 보");
		System.out.println("----------------");
		System.out.print("선택 > ");
		
		int user = scan.nextInt(); // 콘솔에서 입력한 정수를 변수 user에 저장.
		
		System.out.println("computer = " + computer + ", user = " + user);

		
		// 방법 1 =========================================
		if (user == 0 && computer == 0) {
			System.out.println("Tie.");
		} else if (user == 0 && computer == 1) {
			System.out.println("Computer wins.");
		} else if (user == 0 && computer == 2) {
			System.out.println("User wins.");
		} else if (user == 1 && computer == 0) {
			System.out.println("User wins.");
		} else if (user == 1 && computer == 1) {
			System.out.println("Tie.");
		} else if (user == 1 && computer == 2) {
			System.out.println("Computer wins.");
		} else if (user == 2 && computer == 0) {
			System.out.println("Computer wins.");
		} else if (user == 2 && computer == 1) {
			System.out.println("User wins.");
		} else { //(user == 2 && computer == 2) 
			System.out.println("Tie.");
		}
		
		
		// 방법 2 ===============================================================		
		if (user == 0) { //사용자가 가위를 선택한 경우
			if (computer == 0) { //컴퓨터가 가위인 경우
				System.out.println("Tie.");
			} else if (computer == 1) { //컴퓨터가 바위인 경우
				System.out.println("Computer wins.");
			} else { //컴퓨터가 보인 경우
				System.out.println("User wins.");
			}
			
		} else if (user == 1) { //사용자가 바위를 선택한 경우
			if (computer == 0) { //컴퓨터가 가위인 경우
				System.out.println("User wins.");
			} else if (computer == 1) { //컴퓨터가 바위인 경우
				System.out.println("Tie.");
			} else { //컴퓨터가 보인 경우
				System.out.println("Computer wins.");
			}			
		} else { //  사용자가 보를 선택한 경우
			if (computer == 0) { //컴퓨터가 가위인 경우
				System.out.println("Computer wins.");
			} else if (computer == 1) { //컴퓨터가 바위인 경우
				System.out.println("User wins.");
			} else { //컴퓨터가 보인 경우
				System.out.println("Tie.");
			}			
		}
		
		// 방법 3 ================================================================
		if (user == computer) {
			System.out.println("비겼습니다.");
		} else if ((user == 0 && computer == 2) 
				|| (user == 1 && computer == 0) 
				|| (user == 2 && computer == 1)) { //사용자가 이긴 경우
			System.out.println("당신은 이겼습니다.");
		} else {
			System.out.println("당신은 졌습니다.");
		}
		
		
		
		
		
		
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("가위(0), 바위(1), 보(2) : ");		
//		int rockPaperScissors = scanner.nextInt();
//		
// 		if (rockPaperScissors == 0) {
// 			System.out.println("당신의 선택은 : 가위");
// 		} else if (rockPaperScissors == 1) {
// 			System.out.println("당신의 선택은 : 바위");
// 		} else {
// 			System.out.println("당신의 선택은 : 보");
// 		}
//
//		
//		if (number == 0) {
//			System.out.println("컴퓨터의 선택은 : 가위");
//		} else if (number == 1) {
//			System.out.println("컴퓨터의 선택은 : 바위");
//		} else {
//			System.out.println("컴퓨터의 선택은 : 보");
//		}
//					
//		if (rockPaperScissors == number) {
//			System.out.println("당신은 비겼습니다.");
//		} else if ((rockPaperScissors == 0 && number == 2) ||
//					(rockPaperScissors == 1 && number == 0) ||
//					(rockPaperScissors == 2 && number == 1))
//		{
//			System.out.println("당신은 이겼습니다.");
//		} else {
//			System.out.println("당신은 졌습니다.");
//		}
		

		


	}
}





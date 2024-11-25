package com.itwill.array12;

import java.util.Scanner;

public class ArrayMain12 {

	public static void main(String[] args) {
		boolean run = true; // 반복문을 계속할 지를 결정하는 변수.
		int studentNum = 0; // 입력받은 학생수를 저장할 변수.
		int[] scores = null; // 학생들의 점수를 저장할 배열. 배열의 길이는 학생 수가 되어야 함
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택 > ");
			int selectNo = scanner.nextInt(); // Integer.parseInt(scanner.nextLine());
			// 입력받은 숫자를 selectNo 에 넣겠다.
			if(selectNo == 1) {
				System.out.print("학생수 > ");
				studentNum = scanner.nextInt(); // 컨트롤 클릭으로 그 선언된 변수로 갈수있고 알트 방향키 왼쪽으로 이전의 변수로 돌아감
				scores = new int[studentNum]; // 배열의 길이를 학생수만큼 생성.
			} else if(selectNo == 2) {
				if(scores == null) {
					System.out.println("숫자를 다시 입력해주세요");
					continue;
				}
				for(int i = 0; i < scores.length; i++) {
					System.out.print("점수 입력 > ");
					scores[i] = scanner.nextInt();
				}
			} else if(selectNo == 3) {
				if(scores == null) {
					System.out.println("숫자를 다시 입력해주세요");
					continue;
				}
				int num = 0;
				for (int i : scores) {
					System.out.println("scores[" + num +"]"+ i);
					num++;
				}										
			} else if(selectNo == 4) {
				if(scores == null) {
					System.out.println("숫자를 다시 입력해주세요");
					continue;
				}
				int max = scores[0];
				int max2 = 0;
				for(int i : scores) {
					if(i > max) {
						max = i;
					}
					max2 += i;
				}
				System.out.println("최고점수 : " + max );
				double avg = (double) max2 / scores.length;
				System.out.println("평균점수 : " + avg );
			} else if(selectNo == 5) {
				run = false;
				break;
			} 
		
		}
		
		System.out.println("프로그램 종료");
		
	}

}

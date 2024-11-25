package com.itwill.list02;

import java.util.LinkedList;
import java.util.Scanner;

public class ListMain02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<String> list = new LinkedList<String>();
		
		// 문자열(String)을 저장하는 LinkedList를 선언, 생성.
		
		// for 문을 사용해서 리스트에 문자열 입력받고 저장. 5번 반복.
		for(int i = 0; i < 5; i++) {
			System.out.print("입력 > ");
			String x = scanner.nextLine();
			list.add(x);
		}		
		// 리스트의 모든 원소를 출력.
		System.out.println(list);
		// 인덱스 1번 위치의 원소를 삭제하고 리스트를 출력.
		list.remove(1);
		System.out.println(list);
		
		// 리스트에 저장된 문자열 1개를 삭제하고 리스트를 출력.
		System.out.print("삭제할 문자열 > ");
		String y = scanner.nextLine();
		list.remove(y);
		System.out.println(list);
		
		
	
		
	}
	

}

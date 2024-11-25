package com.itwill.array08;

public class ArrayMain08 {

	public static void main(String[] args) {
		// 다차원 배열 : 배열들을 원소로 갖는 배열. 
		// 2차원 배열 : 1차원 배열들을 원소로 갖는 배열.
		// - 2차원 배열은 인덱스를 2개 갖음. 
		
		// 문자열을 원소로 갖는 1차원 배열 : 
		String[] apink = { "손나은", "박초롱", "정은지", "오하영", "윤보미" };
		// 배열의 이름과 숫자한개가 있으면 그안에 원소를 찾는게 1차원 배열

		String[] qwer = { "쵸단", "마젠타", "히나", "시연" };
		String[] blackpink = { "제니", "지수", "로제", "리사" };
		
		// 문자열 배열들을 원소로 갖는 (2차원) 배열 :
		String [][] idols = { apink, qwer, blackpink }; //20번 문장이랑 같은 선언
		// { { "", "", ...} , { "", "", ...} , { "", "",...} }
//		String [][]	idols = {  
//				{ "손나은", "박초롱", "정은지", "오하영", "윤보미" } ,	
//				{ "쵸단", "마젠타", "히나", "시연" } ,
//				{ "제니", "지수", "로제", "리사" }
//		};
		// 배열 length 속성 : 배열의 원소들의 개수.  idols 그룹의 length 는 3
		System.out.println("idols lenght = " + idols.length);
		
		System.out.println(idols[0]); // [ 배열이고 스트링의 원소를 갖는 배열이다.
		// -> 2차원 배열 idols의 첫번째 원소 : apink(문자열 배열)
		System.out.println("idols[0] length = " + idols[0].length); // - > apink.length
		
		
		System.out.println(idols[0][0]); // -> 손나은
		System.out.println(idols[2][2]); // -> 로제
		
		// for 문장을 사용해서 2차원 배열의 모든 원소를 출력 : 
		for(int i = 0; i < idols.length; i++) { //2차원 배열의 원소개수
			for (int j = 0; j < idols[i].length; j++) { //1차원 배열의 원소개수
				System.out.print(idols[i][j] + "\t");
			}
			System.out.println();			
		}
		
		// 향상된 for 문장을 사용해서 2차원 배열의 모든 원소를 출력 :
		for (String[] group : idols) {
			for(String name : group) {
				System.out.print(name + "\t"); //값을 읽어오겠다 하면 향상된 for문 
			}									//값을 위치의 바꾸겠다 하면 일반 for 문 
			
			System.out.println();
		}
		
	}

}

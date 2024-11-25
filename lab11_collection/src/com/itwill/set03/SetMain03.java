package com.itwill.set03;

import java.util.HashSet;

public class SetMain03 {

	public static void main(String[] args) {
		// Score 타입 객체를 저장할 수 있는 HashSet을 선언, 초기화
		HashSet<Score> scores = new HashSet<>(); // new HashSet<Score>();
		
		Score s1 = new Score(0, 0, 0);
		System.out.println("s1 hash: " + s1.hashCode());
		scores.add(s1);
		System.out.println(scores);
		
		Score s2 = new Score(0, 0, 0);
		System.out.println("s2 hash: " + s2.hashCode());
		System.out.println("s1 equals s2 " + s1.equals(s2));
		scores.add(s2);
		System.out.println(scores);
		
		
		
		// 서로 다른 객체 주소값을 가져서 셋에 저장이 됨
		
		
		scores.add(new Score(100, 90, 80));
		System.out.println(scores);
		
		// 어떤 주머니에 넣어야할지 
		// set이라는 커다란 주먼이ㅔ서 첫번째 두번째 세번째 넣을건지 해쉬코드로 판별함
	}

}

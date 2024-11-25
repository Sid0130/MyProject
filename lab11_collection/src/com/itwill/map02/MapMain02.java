package com.itwill.map02;

import java.util.Set;
//		Map<String, Object>
//키는 문자열로 value 는 오브젝트로 객체를 넣으면 다양하게 만들수있음
import java.util.TreeMap;

public class MapMain02 {

	public static void main(String[] args) {
		// 문자열을 key로 하고, 정수를 값(value)으로 하는 TreeMap을 생성, 초기화.
		TreeMap<String, Integer> menu = new TreeMap<>();
		// 음식이름 , 가격
		
		menu.put("짜장면", 8000);
		menu.put("짬뽕", 9000);
		menu.put("볶음밥", 9000);
		menu.put("탕수육", 20000);
		
		System.out.println(menu); //-> key의 오름차순(ascending) 정렬.
		// 내림차순(descending)
		
		// TreeMap<K, V>. keySet(): *오름차순* 정렬된 key들의 집합(Set<K>)을 리턴.
		Set<String> KeySet = menu.keySet(); // 
		for(String k : KeySet) {
			System.out.println(k + "=" + menu.get(k)); // key 의 value도 갖고올 수 있음.
		}
		System.out.println("-----------");
		// TreeMap<K, V>.descendingKeySet(): "내림차순" 정렬된 key들의 집합을 리턴.
		Set<String> descKeySey = menu.descendingKeySet(); // 다형성 descendingKeySet는 String을 원소로 갖는 NavigableSet 타입. 
		//Set이 Super클래스이기 때문에 다형성을 쓸 수 있다.
		
		for(String k : descKeySey) {
			System.out.println(k + " : " + menu.get(k));
		}
		
		
		
	}
}



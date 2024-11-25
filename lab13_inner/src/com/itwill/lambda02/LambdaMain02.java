package com.itwill.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MyFilter {
	boolean test(Object x); // 추상 메서드 한개	
}

@FunctionalInterface
interface MyMapper{
	Object map(Object x); // 새로운 리스트의 원소
}

public class LambdaMain02 {
	
	public List<Object> map(List<Object> list, MyMapper mapper){
		List<Object> result = new ArrayList<>();
		for(Object x : list) {
			result.add(mapper.map(x));
		}
		return result;
	}
				
			
		
		
	
	public List<Object> filter(List<Object> list, MyFilter filter){
		List<Object> result = new ArrayList<>();
		
		for(Object x : list) {
			if(filter.test(x)) { // 조건에 만족하는 값을 리스트에 넣는다.
				result.add(x);	 // 
			}
		}		
		return result;
	}
	
	public static void main(String[] args) {
		// 메인 클래스의 non-static 메서드들을 사용하기 위해서, 메인 객체를 생성
		LambdaMain02 app = new LambdaMain02();
		
		List<Object> numbers = Arrays.asList(1, 2, 3, 10, 20, 30, 11, 12, 13);
		System.out.println(numbers);
		
		
		// numbers의 원소들 중에서 홀수들만 저장하는 리스트를 만들자.
		List<Object> odds = app.filter(numbers, new MyFilter() {
			
			@Override
			public boolean test(Object x) {	
				return (Integer) x % 2 == 1;
			}
		}); 
		System.out.println(odds);
		
		// numbers의 원소들 중에서 짝수들만 저장하는 리스트를 만들자.
		List<Object> evens = app.filter(numbers, x -> (Integer) x % 2 == 0);
		System.out.println(evens);
		
		// 문자열을 원소로 갖는 리스트
		List<Object> names = Arrays.asList("Java","SQL","JavaScript","HTML","Python");
		
		// names에서 5글자 이상인 문자열들만 필터링한 리스트.
		System.out.println(names);
//		List<Object> longNames = app.filter(names, new MyFilter() {
//			
//			@Override
//			public boolean test(Object x) {
//				return ((String) x).length() >= 5;
//			}
//		});
		
		List<Object> longNames = app.filter(names, x -> ((String)x).length() >= 5);
		System.out.println(longNames);
		
		
		 //names에서 "L"이 들어간 문자열들만 필터링한 리스트.
		List<Object> result = app.filter(names, x -> ((String)x).contains("L")); // 파라미터를 전달 했을 때 리턴 값 중요!
		System.out.println(result);
		
		System.out.println("------");
		// 리스트 numbers의 원소들의 제곱을 저장하는 리스트를 만들자.
		// -> 결과: [1, 4, 9, 100, 400, 900, 121, 144, 169]
//		List<Object> squares = app.map(numbers, (x) -> ((Integer)x) * ((Integer)x));
		List<Object> squares = app.map(numbers, new MyMapper() {
			
			@Override
			public Object map(Object x) {
				return (Integer) x * (Integer) x;
			}
		});
		System.out.println(squares);
				
		// 리스트 names 원소들(String)들의 길이를 저장하는 리스트를 만들자.
		
		List<Object> lengths = app.map(names, new MyMapper() {
			
			@Override
			public Object map(Object x) {
				return ((String)x).length();
			}
		});
		System.out.println(lengths);

		List<Object> lengthss = app.map(names, x -> ((String)x).length());
		System.out.println(lengthss);

	}
}

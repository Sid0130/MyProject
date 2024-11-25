package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * 람다 표현식: (파라미터 선언) -> { 코드; }
 * - 메서드 몸통이 한 문장만 있는 경우: (파라미터) -> 문장
 * - 메서드 몸통이 return 문장만 있는 경우: (파라미터) -> 리턴값
 * 
 * "메서드 참조(method reference)"를 사용한 람다 표현식: // 항상 파라미터가 1개인 메서드만 
 * (1) 람다 표현식이 파라미터가 1개이고, 람다 표현식의 몸통이 그 파라미터에서 
 *     "아규먼트를 갖지 않는" 메서드를 호출하는 경우:
 *     (예) x -> x.toUpperCase(); 람다인 경우 String::toUpperCase // 어떤 타입의 클래스인지 앞에 적어줄 필요가 있다 :: 이것을 메서드 참조
 * (2) 람다 표현식이 파라미터가 1개이고, 람다 표현식의 몸통이 메서드 호출로만 이루어진 한 문장이고,
 * 	   호출한 메서드가 람다 표현식의 파라미터만 아규먼트로 갖는 경우:  파라미터가 한개인데 몸통은 한 문장. 근데 그 한문장이 아규먼트가 람다의 파라미터로 그대로 전해지는 것.
 * 	   (예) x -> System.out.println(x) 람다 표현식인 경우, System.out::println // println은 아규먼트를 가지는데 람다의 파라미터가 그대로 아규먼트로 가져갈 경우 System.out이 println을 참조한다.
 */

public class LambdaMain03 {

	public static void main(String[] args) {
		//스트림(Stream) 클래스와 람다 표현식. 원소들이 지나가는 통로
		
		Random random = new Random();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			numbers.add(random.nextInt(100));
		}
		System.out.println(numbers); //ArrayList가 toString을 오버라이딩해서 리스트가 [...] 나옴.
		
		// for 반복문을 사용해서 numbers의 원소들을 출력.
		for(Integer x : numbers) {
			System.out.print(x + " ");
		}
		System.out.println();
		// 람다 포현식을 사용한 리스트 원소 출력
		numbers.forEach(x -> System.out.print(x + " ")); //리스트의 원소 한개한개에 대해 해야할 일. numbers에서 꺼낸 원소 1개 x  -> System.out.print(x+ " ")
		// 리턴 타입이 void인 메서드를 만들어주면 된다.	// 첫번째 아규먼트를 가지고 numbers에 넘어옴. 
		// forEach 는 원소들이 지나가는 통로이고 원소를 순서대로 하나씩 보내고 똑같은 일을 하는데 해야할 일을 괄호안에서 작성하고 x는 numvers와 같은 타입이라고 생각하고
		// 작성하면 된다.
		// forEach는 리스트의 원소를 각각에 대해서 x 를 출력하겠다. 이것이 스트림의 특징. 리스트의 들어가고 나가는 통로 
		
		// 리스트 numbers의 원소들 중에서 홀수들만 저장한 리스트를 만듦.
		// 빈 리스트 만듦.
		// numbers 원소들 반복
		// 홀수이면 결과에 저장.
		
		System.out.println("\n----------------");
		List<Integer> odds = new ArrayList<>();
		for(Integer x : numbers) {
			if(x % 2 == 1) {
				odds.add(x);
			}
		}
		System.out.println(odds);
		odds.forEach(x -> System.out.print(x + " "));
		
		System.out.println();
		// 스트림과 람다표현식을 사용:
		List<Integer> odds2 = numbers.stream().filter(x -> x % 2 == 1).toList(); // stream은 통로이고 numbers에 들어온 변수로부터
		// filter로 조건식을 작성하고 stream으로 통과한 원소들을 toList 리스트로 만들겠다.
		// 리스트의 각각 원소을 조건을 검사 그리고 그 결과를 배열 또는 리스트로 만들겠다. toList의 리턴타입이 리스트이기 때문에 List 타입에 대입한다.
		System.out.println(odds2);
		
		// 리스트 numbers의 원소들의 제곱을 저장하는 리스트를 만듦.
		System.out.println();
		List<Integer> squares = new ArrayList<>(); 
		for(Integer x : numbers) {
			squares.add(x*x);
		}
		System.out.println(squares);
		
		// Stream과 Lambda를 사용:
		List<Integer> squares2 = numbers.stream().map(x -> x*x).toList(); // numbers의 숫자가 다른 숫자(매핑)로 들어가서 리스트로 묶인다.
		System.out.println(squares2);
		
		// 리스트 numbres에서 홀수들의 제곱을 저장하는 리스트
		List<Integer> oddSquares = new ArrayList<>();
		for(Integer x : numbers) {
			if(x % 2 == 1) {
				oddSquares.add(x*x);
			}
		}
		System.out.println(oddSquares);
		
		List<Integer> oddSquares2 = numbers.stream().filter(x -> x % 2 == 1).map(x -> x*x).toList();
		System.out.println(oddSquares2);
		
		// 문자열을 원소로 갖는 리스트.
		List<String> names = Arrays.asList("Java", "SQL", "HTML","JavaScript", "Python", "C#", "Kotlin", "Swift");
		
		// names에서 5글자 이상인 문자열들만 필터링한 리스트.
		List<String> longNames = names.stream().filter(x -> x.length() >= 5).toList();
		System.out.println(longNames);
		// names의 문자들을 모두 대문자로 변환(매핑)한 리스트.
		
//		List<String> upperNames = names.stream().map(x -> x.toUpperCase()).toList(); // 메서드 호출. 메서드는 아규먼트가 없음.
		List<String> upperNames = names.stream()
				.map(String::toUpperCase) //.map(x -> x.toUpperCase())  //메서드 참조.
				.toList();
		System.out.println(upperNames);
		
		// names의 문자열들을 그 길이로 매핑한 리스트.
		List<Integer> lengthNames = names.stream()
				.map(String::length)//.map(x -> x.length()) length의 원소를 String으로 호출한다. 메서드 참조에서는 괄호를 쓰지 않는다.
				.toList();
		System.out.println(lengthNames);
		// names에서 5글자 이상인 문자열들을 모두 대문자로 변환한 리스트.
		List<String> longupperNames = names.stream()
				.filter(x -> x.length() >= 5)
				.map(x -> x.toUpperCase())
				.toList();
		System.out.println(longupperNames);
		
//		longupperNames.forEach(x -> System.out.println(x)); // 아규먼트가 그대로 들어갈 때
		longupperNames.forEach(System.out::println);
	}

}

package com.itwill.string;

public class StringEx {

	public static void main(String[] args) {
		System.out.println("Ex. 1 ---");
		// String.charAt(int index) 사용법:
		
		String ssn = "991028-2234567";
		System.out.println(ssn.charAt(7)); // 이미 만들어져있는 클래스가 있고 클래스에 많은 메서드들이 만들어져 있고
		
		System.out.println("Ex. 2 ---");
		// String.split(String s) 사용법:
		String date = "2024-10-28";
		String[] result = date.split(""); // split 타입은 배열, 배열은 반복문으로 호출! 해야 주소가 안보임.
		for(String s : result) {  // 문자열 3개 배열이 된다.
			System.out.print(s + "\t");
		}
		System.out.println();
		
		
		System.out.println("Ex. 3 ---");
		String[] languages = {"Java", "SQL", "JavaScript", "Python", "KOtlin", "HTML"};
		//배열 languages에서 5글자 이상인 문자열들만 출력.
		
		for (String x : languages) {
			if(x.length() >= 5) {
				
				System.out.println(x);
			}
		}
		System.out.println();	
		
		// length() 괄호가 있는 것은 메서드 메서드호출 , .length 배열의 가지고있는 렝스라고하는 속성이름
		System.out.println("Ex. 4 ---");
		String[] names = {"오쌤",  "Gildong"};
		//배열 names에서 문자열 "홍길동"이 처음 등장하는 인덱스를 출력: 1
		
		int index = -1;
		for(int i = 0; i < names.length; i++){
			if(names[i].equals("홍길동")) { // names. 하면 문자열배열이 갖고있는 메서드와 필드  
				// names[i]. 배열에 저장된 원소 는 스트링클래스가 갖고있는 메서드들.
				index = i;
				break;
			}
		}
		System.out.println("index = " + index);
		
	
		System.out.println("Ex. 5 ---");
		String[] tests = {"테스트", "test", "Test", "문자열 TEST", "tEST"};
		//배열 tests에서 대소문자 구분없이 "est"를 포함하는 문자열들을 출력: 4
		
		System.out.println("tEst".toLowerCase().equals("test")); //to 로 시작하면 ~로 변환하겠다 라는 뜻.
		// 전부 대문자로, 소문자로 바꾸고 비교를한다.
		// toLowerCase가 리턴하는 타입의 메서드를 호출할 수있다. 메서드를 연쇄적으로 호출한다.
		System.out.println("test".contains("")); // 주.contains("목적") 가지고 있나요? 라는 뜻
		// 아규먼트에 문자열이 포함되있으면 true
		
		for(String s : tests) {
			if(s.toLowerCase().contains("est")) { // contains가 boolean을 리턴하는 메서드는 조건식에 사용할 수 있다. 
				System.out.print(s + "\t");
			}
		}
		System.out.println();
		//스플릿
		System.out.println("Ex. 6 ---");
		String today = "2024/10/28";
		//문자열 today(YYYY/MM/DD)에서 년/월/일 정보를 int 타입 변수(들)에 저장.
		//년/월/일을 출력.
		
		String[] strArray =today.split("/");
		
		int year = Integer.parseInt(strArray[0]);
		int month = Integer.parseInt(strArray[1]);
		int day = Integer.parseInt(strArray[2]);
		
		System.out.printf("year= %d, month= %d, day=%d\n", year,month,day);
		
	}

}

package com.itwill.method07;

public class MethodMain07 {
	// 가변길이 인수(variable - length arguments) :
	// 변할 수 있는 길이가 있는 인수
	// 메서드의 아규먼트 개수가 정해져 있지 않은 경우.
	// 메서드를 호출할 때마다 아규먼트 개수가 달라질 수 있는 경우.

	public static void main(String[] args) {
		// ... 가변길의 인수
		System.out.printf("hello\n");
		System.out.printf("안녕하세요, %s!\n", "오쌤");
		System.out.printf("%d x %d = %d\n", 2, 3, 6);
		// 항상 먼저 스트링이고 그다음 아규먼트가 , , , 두번째는 하나여도되고 네개 다섯개 .. 몇개의 아규먼트를 넘겨도 상관없다.
		// 템플릿안에 퍼센트가 몇개가 들어갈지 모르기 때문에 미리 만들어 둘수는 없기에 오버로딩으로 정의하는게 아니라 가변길의 인수로 정의한다.

		int sum = addAll(1, 2, 3);
		System.out.println("sum = " + sum);

		sum = addAll(1, 2, 3, 4, 5);
		System.out.println("sun = " + sum);

		sum = addAll();
		System.out.println("sun = " + sum);

		int result = calculate("+",1,3,5);
		System.out.println("reslut = " + result);
		
		result = calculate("+");
		System.out.println("reslut = " + result);
		
		result = calculate("*",2);
		System.out.println("reslut = " + result);

		result = calculate("*");
		System.out.println("reslut = " + result);
		
	}

	
	
	/*
	 * 가변길이 인수를 갖는 메서드를 선언하는 방법 : 
	 * 가변길이 인수를 저장하는 파라미터 선언 : 타입... 변수이름 
	 * 가변길이 인수는 메서드 안에서는 배열처럼 취급. 
	 * - 가변길이 인수는 length 속성을 가지고 있음. 
	 * - for 문, 향상된 for 문을 사용할 수 있음.
	 * 가변길이 인수를 저장하는 파라미터는 반드시 마지막 파라미터여야 함! 
	 * 가변길이 인수를 저장하는 파라미터는 오직 1개뿐. 2개 이상 있을 수 없음! method(int...args1, double ... args2); 
	 * 가변길이 인수를 갖는 메서드를 호출할 대는 아규먼트 개수의
	 * 제한이 없음 -> 가변길이 인수는 아규먼트를 전달하지 않아도 됨.
	 */

	public static int addAll(int... args) {
		System.out.println("아규먼트 개수 = " + args.length);

		int sum = 0;
		for (int x : args) {
			sum += x;
		}
		return sum;
	}

	/**
	 * calculate.
	 * 
	 * @param op     연산자(Strint). "+" 또는 "*".
	 * @param values 가번길이 인수. 정수(int).
	 * @return (1)아규먼트 op가 "+"인 경우에는, 가변길이 이수 values의 합을 리턴. values가 없으면 0을 리턴.
	 *         (2)아규먼트 op가 "*"인 경우에는, 가변길이 인수 values의 곱을 리턴. values가 없으면 1을 리턴.
	 *         (3)아규먼트 op가 "+","*"가 아닌 경우에는 0을 리턴.
	 */
	public static int calculate(String op, int... values) {
		int result = 0;
		switch (op) {
		case "+":
			for (int x : values) {
				result += x;
			}
			break;
		case "*":
			result = 1;
			for (int x : values) {
				result *= x;
			}
//			break;
//		default: 
		}
		return result;

//		if (op == "+") {
//			for (int x : values) {
//				result += x;
//			}
//		} else if (op == "*") {
//			result = 1;
//			for (int n : values) {
//				result *= n;
//			}
//		}

		

	}

}

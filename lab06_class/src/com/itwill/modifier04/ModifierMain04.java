package com.itwill.modifier04;

import com.itwill.modifier05.PublicClassExample;
//import com.itwill.modifier05.PackageCalssExample;


// -> 패키지 범위의 클래스는 다른 패키지의 클래스에서 import 할 수 없음.
/*
 *  클래스 멤버의 접근 수식어 : private < (package) < protected < public
 *  클래스의 접근 수식어 : 
 *  (1) (package) : 수식어가 없는 경우. 같은 패키지 안에서만 공개된 클래스.
 * 	(2) public : 어디서든지(모든 패키지에서) 공개된 클래스.
 * 	(주의) public 클래스의 이름은 java 파일의 이름과 같아야 함!
 * 	하나의 java 파일 안에서 여러개의 클래스들을 선언하는 것은 가능.
 * 	하나의 java 파일 안에는 public 클래스 오직 1개만 선언해야 함.
 * 	하나의 java 파일 안에 여러개의 클래스를 선언한 경우, 컴파일 후에는 
 * 	각각의 클래스 파일(바이트 코드)들이 만들어 짐.
 */

// 상관은 없지만 권장하지 않는다.
class A{}

class B{}

public class ModifierMain04 { // 클래스와 파일이름은 같아야한다

	public static void main(String[] args) {
		// com.itwill.modifier05.PublicClassExample 타입의 변수, 초기화
		PublicClassExample ex = new PublicClassExample();
		
		// com.itwill.modifier05.PackageClassExample 타입의 변수, 초기화
		// com.itwill.modifier05.PackageClassExample.ex 
		// 이 클래스는 패키지수식어 때문에 클래스안에서만 사용가능하고 다른 패키지에서 불러오는것은 불가능
		
		// 회사와 특허와 공개하고 싶지 않은것들 근데 클래스로 만들어야하는 것들은 패키지 클래스로 만듬.
		// 보이느냐 안보이냐의 차이
		
	}

}

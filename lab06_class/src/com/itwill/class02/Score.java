package com.itwill.class02;

// 클래스 : 객체 설계도. 데이터(필드) + 기능(메서드) + 생성자 = 변수 타입.

//생성자(constructor):	-건설해 주는것
//객체를 생성하고, 객체의 필드들을 초기화하는 역할. 객체를 생성한다 = 메모리를 확보한다.
//생성자의 이름은 반드시 클래스의 이름과 같아야 함! - 이것은 자바의 문법!
//생성자를 작성하는 방법은 메서드 작성방법과 비슷하지만, 리턴 타입이 없음!
//클래스를 선언할 때 생성자를 하나도 정의하지 않으면,
//자바 컴파일러가 "기본 생성자"를 자동으로 작성해 줌.
//클래스를 선언할 때 생성자를 직접 정의한 경우에는,
//자바 컴파일러가 기본 생성자를 자동으로 만들어 주지 않음!
//생성자 오버로딩: 파라미터가 다른 생성자를 여러개 만들 수 있음

public class Score {
	// 클래스에서 선언하는 변수를 
	// 필드(field)/ 멤버 변수 선언 :
	// 멤버 변수는 필드, 메서드, 생성자 3가지가 있음
	// 필드 : 같은 클래스의 메서드들에서 사용할 수 있는 변수.
	int korean;
	int english;
	int math;
	
	// 필드에 값들을 채워주는 과정을 생성해주는 과정이 new Score() 필드들이 초기화
	
	// 필드 생성자 메서드순으로 작성을 많이한다.
	
	// 생성자 선언 : 
	public Score() { //반드시 클래스이름과 동일해야함.
		// 실행문이 없으면 필드의 모든 값들은 그 타입의 기본값으로 초기화됨.
		
	}
	// 생성자는 메서드와 만드는것이 비슷해서 이름, 파라미터, 바디 그리고 세미콜론
	// 메서드와 다른것은 리턴타입이 없다!!
	public Score(int korean, int english, int math) { // 생성자를 여러개 만드는것이 오버로딩
		// this : Score 타입으로 생성된 객체. 예약어, 키워드
		// this가 가르키는건 생성된 객체
		this.korean = korean;
//		korean = kor; // 구분이 되는경우라면 생략해도된다
		this.english = english;
		this.math = math;
		// 두번째 파라미터를 첫번째에 저장하겠다.
	}
	
	
	// 메서드 선언 :
	// 메서드는 필드에 할당(저장)된 값들을 사용할 수 있음.
	// 같은 클래스에서 모두 사용가능한것이 필드.
	public int getTotal() { // 객체가 가지고 있는 값들을 이용해서 결과를 내겠다 . 아규먼트가 필요없다.
		// 필드의 값들은 클래스가 가지고있는 모든 메서드가 사용이 가능
	
//		int x = 0; // 지역변수는 반드시 초기화를 해야한다.
//		int y = 0;
//		return x + y;
		
		return korean + english + math;
		
	}
	
	public double getMean() {
//		return (double) (korean + english + math) / 3 ;
		return (double) getTotal() / 3;
	}
	

}

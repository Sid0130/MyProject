package com.itwill.class05;

// 학생의 정보를 가지고 있는 객체
public class Student {
	
	// 필드
	int id; // 학생 번호
	String name; // 학생 이름
	Subject subject; // 수강 과목(java, sql, html, javaScript) 점수들
	
	
	// 생성자
	public Student() {}
	
	public Student(int id, String name, Subject subject) {
		this.id = id;
		this.name = name;
		this.subject = subject;
		
	}
	// 메서드
	public void info() {
		System.out.println("--- 학생 정보 ---");
		System.out.println("번호 : " + this.id); 
		System.out.println("이름 : " + this.name);
		if(this.subject != null) { // 안전하게 호출하는 방법 검사하는 것 
			//if else 를 사용해서 널이 아니면 호출
			this.subject.info();
		} else {
			System.out.println("과목 : null");
		}
		System.out.println("-----------------");
			
//		System.out.println("과목 = " + this.subject.java);
		
	}
	// info 학생 번호, 이름, 과목 ,점수들 ,총점, 평균을 출력.

	// jvm 가상의 컴퓨터
	// os 에게서 메모리 cpu를 빌려서 계산하는게 자바 가상 머신
	// 빌려온 메모리를 3개의 영역을 나누는데 자바 프로그램이 메모리를 용도별로 나눠서 사용하게 해주는게 자바가상머신이 하게된다.
	// 크게 메소드, 스택, 힙, 3개의 영역
	// 메소드는 바이트 코드(컴파일된 클래스)를 메모리에 올리고 staitc 변수/메소드도 저장.
	// 스택 지역 변수, 파라미터/매개변수 저장하는 영역이 스택
	// 합 인스턴스 - 클래스타입으로 생성된 객체를 힙
	
	// 자바실행환경도 os으로 부터 메모리를 빌려오고 자바 가상머신은 메소드 스택 힙에 빌려줌
	
	
}

package com.itwill.class05;

import java.lang.ProcessHandle.Info;

public class ClassMain05 {

	public static void main(String[] args) {
		// Subject, Student 객체를 생성하고, 메서드 호출
		Subject subject1 = new Subject();
		System.out.println(subject1);
		
		Subject subject2 = new Subject(88,83,55,66);
		System.out.println(subject2);
		subject2.info();
		
		System.out.println();
		
		// Student 타입 변수 선언, 초기화
		Student student1 = new Student();
		System.out.println(student1);
		student1.info();
		
		Student student2 = new Student(1, "홍길동", subject1);
		System.out.println(student2);
		student2.info();
		
		Student student3 = new Student(2, "김민석", subject2);
		System.out.println(student3);
		student3.info();
		
	}

}

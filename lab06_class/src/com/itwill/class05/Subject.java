package com.itwill.class05;

public class Subject {

	// 필드 (field)
	int java; // 자바 과목 점수
	int sql; // SQL 과목 점수
	int html; // HTML 과목 점수
	int javaScript; // JavaScript 과목 점수
		
	// 생성자
	public Subject() {}
	
	public Subject(int java, int sql, int html, int javaScript) {
		this.java = java;
		this.sql = sql;
		this.html = html;
		this.javaScript = javaScript;
	}
	
	// 메서드
	
	public int getTotal() {
		return this.java + this.sql + this.html + this.javaScript;
	}
	// getTotal : 4과목의 총점을 리턴.
	
	public double getMean() {
		return (double) getTotal() / 4;
	}
	// getMean :  4과목의 평균 (double)을 리턴.
	
	public void info() {
		System.out.println("Java = " + this.java);
		System.out.println("SQL = " + this.sql);
		System.out.println("HTML = " + this.html);
		System.out.println("JavaScript = " + this.javaScript);
		System.out.println("총점 " + this.getTotal());
		System.out.println("평균 " + this.getMean());
	}
	// info : 4과목의 점수, 총점, 평균을 출력.
	
}

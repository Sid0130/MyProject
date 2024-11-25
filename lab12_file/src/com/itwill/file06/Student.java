package com.itwill.file06;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable{
	
	@Serial // 오버라이드처럼 컴파일러에게 시리얼이라고 지시
	private static final long serialVersionUID = 738322677766212066L;
	
	private int id;
	private String name;
	private Score score;
	
	
	// constructors
	public Student(int id, String name, Score score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	
	// getters && setters
	
	// toString
}

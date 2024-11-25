package com.itwill.file06;

import java.io.Serial;
import java.io.Serializable;

public class Score implements Serializable{
	@Serial 
	private static final long serialVersionUID = 6978059665437004103L;
	
	
	private int korea;
	private int english;
	private int math;
	
	
	public Score(int korea, int english, int math) {
		this.korea = korea;
		this.english = english;
		this.math = math;
	}

	public int getKorea() {
		return korea;
	}

	public void setKorea(int korea) {
		this.korea = korea;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Score [korea=" + korea + ", english=" + english + ", math=" + math + "]";
	}
	
}

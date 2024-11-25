package com.itwill.set03;

import java.util.Objects;

public class Score {
	private int java;
	private int sql;
	private int html;

	public Score(int java, int sql, int html) {
		this.java = java;
		this.sql = sql;
		this.html = html;
	}

	@Override // -> 컴파일러에 오버라이드 문법이 맞는지 지시.
	public String toString() {

		return "Score(java= " + java + ", sql= " + sql + ", html= " + html + ")";
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Score) {
			Score other = (Score) obj;
			result = (this.java == other.java) // 내가 갖고있는 자바 다른애가 갖고있는 자바.
					&& (this.sql == other.sql) 
					&& (this.html == other.html);
		}
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(java, sql, html);
//		return java * 8 + sql * 4 + html * 2;
//		return java + sql + html;

	}
}

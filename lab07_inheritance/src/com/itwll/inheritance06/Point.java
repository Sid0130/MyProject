package com.itwll.inheritance06;

import java.util.Objects;
import java.util.function.Predicate;

// 2차원 평면에서의 점의 좌표를 나타내는 객체.
public class Point {
	// field
	private double x;
	private double y;
	
	
	// constructor : (1) 기본 (2) x,y를 아규먼트
	public Point() {}
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
		
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 두 객체의 주소값이 같으면
			return true; // true
		if (obj == null) // 아규먼트가 null ..
			return false;
		if (getClass() != obj.getClass()) // 클래스에 대한 정보를  , 서로 클래스 타입 다름ㄻ= 
			return false;
		Point other = (Point) obj; //오브젝트를 포인터로 바꿔서 
		
		// 필드들의 값을 각각 비교
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	} 

	
	// Object 클래스에서 상속받은 toString() 메서드를 override:
	// 리턴하는 문자열에는 필드 x, y의 값이 표현되야 함.

	
	// equals() 메서드를 override: 
	// 필드 x, y의 값이 서로 같으면 true, 그렇지 않으면 false.

	
	// hashCode() 메서드를 override:
	// equals()가 true인 두 객체의 hashCode 값은 같아야 함.
//	@Override
//	public int hashCode() {
//		int z = (int) x + (int) y;
//		
//		return z;
//	}
}

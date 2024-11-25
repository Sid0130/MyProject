package com.itwill.datetime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeEx {

	public static void main(String[] args) {
		// java.util 패키지의 Date, Calendar 클래스.
		// Java 8 버전부터 새로 생긴 java.time 패키지의 날짜/시간 관련 클래스.
		
		LocalDate today = LocalDate.now(); // 날짜
		System.out.println(today);		// 날짜와 시간은 LocalDateTime
		System.out.println(today.getYear());
		System.out.println(today.getMonth()); //-> Month enum 상수 리턴
		System.out.println(today.getMonthValue()); //-> 정수 리턴.
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfWeek()); //-> DayOfWeek enum 상수 리턴.
		System.out.println(today.isLeapYear()); //-> 윤년 여부(true/false) 리턴.
		System.out.println(today.plusDays(7));
		System.out.println(today.minusWeeks(2));
		
		// 가져와야하는 것은 get으로 시작하는게 많고
		// 참인지 거짓은 is로 시작하는 메서드를 찾아보면 된다.
		
		LocalDate birthday = LocalDate.of(2000, 12, 31); // 날짜가 없는 상태에서 숫자들을 가지고 날짜를 만드려면 객체를 만들어주는 static 클래스 메서드 이용. 
		System.out.println(birthday);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		LocalDateTime time = LocalDateTime.of(2024,10,29,12,10); // 아규먼트로 데이터타입을 보고 만들면 된다.
		// 일정관리 앱을 만든다 하면 시작시간, 종료시간 입력할때 사용할 수 있겠다.
		System.out.println(time);
		
		// 데이터베이스에 날짜/시간을 저장하거나, 저장된 시간을 읽어올 때는
		// java.sql 패키지의 Date, Timestamp 타입을 사용함. 둘다 년원일을 담고있고 소수점까지는 Timestamp다
		// LocalDateTime ---> Timestamp 변환 
		Timestamp ts = Timestamp.valueOf(time);
		System.out.println(ts);
		System.out.println(ts.getTime());
		// 1970-01-01 00:00:00를 기준으로 1/1000초마다 1씩 증가하는 정수. 기준시간부터 일정시간마다 1씩 증가하는 숫자 
		
		// Timestamp ---> LocalDateTime 변환 / DB에 있는걸 로컬에 넣어야함 나중에 DB를 사용하려면 필요하다
		LocalDateTime dt = ts.toLocalDateTime();
		System.out.println();
	}

}

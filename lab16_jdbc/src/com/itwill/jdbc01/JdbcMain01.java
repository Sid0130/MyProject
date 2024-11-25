package com.itwill.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import oracle.jdbc.OracleDriver; 
// ojdbc17.jar 파일을 빌디 패스에 추가해야 import가 가능. (1)번을 했기 때문에 가능했던 것. 

// 클래스/인터페이스에서 static으로 선언한 상수 이름들을 import.

import static com.itwill.jdbc.oracle.OracleJdbc.*;
//import static com.itwill.jdbc.oracle.OracleJdbc.URL;
//import static com.itwill.jdbc.oracle.OracleJdbc.PASSWORD;
//import static com.itwill.jdbc.oracle.OracleJdbc.USER;


/*
 * JDBC(Java Database Connectivity):
 * 자바 프로그램에서 데이터베이스 서버에 접속하고, SQL 문장을 실행해서 그 결과를 처리.
 * 
 * 1. Oracle JDBC 라이브러리(jar 파일)을 다운로드하고, 이클립스 프로젝트의 빌드 패스에 추가
 * 	  (1) Oracle JDBC 다운로드 페이지에서 ojdbc17.jar 파일을 다운로드
 * 			-> 구글검색: ojdbc jar download  버전에 맞게 다운.
 * 	  (2) 이클립스 프로젝트에 lib 폴더를 만들고, 다운로드한 jar 파일을 복사.
 * 	  (3) jar 파일을 오른쪽 클릭 -> Build Path -> Add to build path
 *  
 * 2. 데이터베이스(Oracle) 서버에 접속하기 위한 정보들(URL, USER, PASSWORD)을 상수로 정의.
 * 
 * 3. 프로그램에서 JDBC 라이브러리를 메모리에 로딩. - 여기서부터 메인에서 작성
 * 4. 데이터베이스 서버에 접속.
 * 5. Statement 타입 객체를 생성 - DB에서 실행할 SQL 문장을 작성하고 실행할 수 있는 객체.
 * 6. Statement 인스턴스의 메서드를 호출해서 SQL 문장을 실행.
 *    (1) executeQuery(): select 문장 실행. 
 *    (2) executeUpdate(): insert/update/delete 문장 실행. - DML
 * 7. 메서드 실행 결과(리턴 값)을 처리. 
 * 8. 사용했던 모든 리소스들을 해제(close).
 */

public class JdbcMain01 {

	public static void main(String[] args) throws SQLException { // 코드 순서에 집중하기 위해 throws
		// select 문장 실행, 결과 처리

		// 3. 오라클 JDBC 라이브러리(드라이버)를 메모리에 로딩.
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("JDBC 드라이버 등록 성공");

		// 4. 오라클 데이터베이스 서버에 접속.
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); // 리소스중 하나
		System.out.println("데이터베이스 서버 접속 성공");
		
		// 5. Statement 타입 객체 생성.
		// DB 서버에서 실행할 SQL 문장 (주의) 세미콜론(;)을 쓰지 않음!
		final String sql = "select * from blogs order by id desc"; // <- 글 안에 세미콜론 x
		PreparedStatement stmt = conn.prepareStatement(sql); // 위의 문장, 템플릿을 만들고  
		
		// 접속한다 connection
		// 전송을 할수 있는 객체가 Prepared 가 sql 문장을 전송할 수 있고 준비한다.
		// 그리고 execut를 실행하면 데이터베이스에 전송한다
		// DB 결과를 테이블을 받아주는게 resultset에 받는다.
		// 
		// 접속을 계속하고 있으면 안되니까 close()
		
		// 6. Statement 인스턴스의 메서드 호출 - 작성된 SQL 문장을 DB 서버로 전송해서 실행시킴.
		ResultSet rs = stmt.executeQuery();
		//ResultSet을 테이블이라고 생각.. 반복문을 사용 
		
		
		
		// 7. SQL 실행 결과 처리
		while (rs.next()) { // 첫번째 행이 있으면 true를 리턴하고 가르키고 있는 포인터의 위치를 다음 위치로 바꿔줌 이거 next
			int id = rs.getInt("ID"); // id 컬럼에서 정수값을 읽겠다.
			String title = rs.getString("TITLE"); // 타이틀이라는 문자열에서 문자를 읽겠다.
			String content = rs.getString("CONTENT");
			String author = rs.getString("AUTHOR");
			Timestamp createdTime = rs.getTimestamp("CREATED_TIME");
			Timestamp modifiedTime = rs.getTimestamp("MODIFIED_TIME");
			
			String blog = String.format("%d | %s | %s | %s | %s | %s", 
					id, title,content,author, createdTime, modifiedTime);
			System.out.println(blog);
//			System.out.println(id + ": " + title);  // 아이디 컬럼에 있는 값을 리턴, 타이틀 컬럼의 값을 출력
			
			
			// 행이 있으면 true 
			// 다음 행이 없으면 false. false 리턴하면 반복문 끝.
		}
		
		//첫번째행 을 가리키고있고  화살표가 가르키는 행이 있나 하는게 next() 메서드.
		// 넥스트는 지금 리절트 위치에서 행이 있는가를 리턴해주는 것
		
		// 8. 사용했던 모든 리소스 해제. - 객체들이 생성된 순서와 반대로 close()를 호출.
		rs.close(); // ResultSet 리소스 해제.
		stmt.close(); // Statement 리소스 해제.
		conn.close(); // 데이터베이스 서버와의 접속을 끊음(로그아웃).
		
		System.out.println("데이터베이스 서버 접속 해제 성공");
		
		
	}
}

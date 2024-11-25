package com.itwill.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.oracle.OracleJdbc.*;

public class JdbcMain02 {

	public static void main(String[] args) {
		// insert 문장 실행, 결과 처리
		
		Scanner scanner = new Scanner(System.in); // 콘솔 입력
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 오라클 JDBC 드라이버를 등록(메모리에 로딩).
			DriverManager.registerDriver(new OracleDriver());
			
			// DB에 접속.
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// Statement 객체 생성.
			final String sql = 
					"insert into blogs (title, content, author, created_time, modified_time) "
					+ "values (?, ?, ?, systimestamp, systimestamp)"; // 데이터 베이스 시스템 시간을 넣어주면 됨
			stmt = conn.prepareStatement(sql); 
			// 실행시키기전에 준비가 된 템플릿을 채워줘야하는데.. 그것을 채워주는 역할이 set
			
			// 제목, 내용, 작성자를 콘솔에서 입력받음.
			System.out.print("제목>>> ");
			String title = scanner.nextLine();
			
			System.out.print("내용>>> ");
			String content = scanner.nextLine();
			
			System.out.print("작성자>>> ");
			String author = scanner.nextLine();
			
			// PreparedStatement 인스턴스 SQL 문장에서 ? 부분을 입력받은 값으로 채움.
			stmt.setString(1, title); //첫번째 ? 를 title 값으로 채움. - 알아서 작은 따옴표로 감싸준다 ' '
			stmt.setString(2, content);
			stmt.setString(3, author);
			
			int result = stmt.executeUpdate(); // 변경된 행의 개수를 리턴.
			// insert는 삽인된 행의 개수
			// delete는 삭제된 행의 개수
			System.out.println(result + "개 행이 삽입됐습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제.
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
}

//JDBC : 자바가 디비로 보내고 디비는 자바프로그램에 보내고 자바는 결과를 보여준다.
// DELETE ID FROM WHERE ID ? ..

// update는 id로 글을 찾고 제목, 내용을 바꿀 수 있겠다.
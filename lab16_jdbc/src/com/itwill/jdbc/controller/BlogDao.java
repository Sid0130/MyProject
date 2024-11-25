package com.itwill.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.model.Blog.Entity.*;
import static com.itwill.jdbc.oracle.OracleJdbc.*;

// MVC 아키텍쳐에서 Controller를 담당하는 객체. DAO(Data Access Object)..
// CRUD(Create, Read, Update, Delete) 크루드
// DB 테이블에서 select, insert, update, delete 쿼리를 실행하고 결과를 리턴하는 기능.
public enum BlogDao {
	INSTANCE; // BlogDao 타입의 싱글톤(singleton) 객체.
	
	// 생성자 - enum 타입의 생성자는 private만 가능. private은 생
	BlogDao(){
		
		// 메인에 기능을 한번만해서 생성자로 기능을 만든다.
		try {
			// 오라클 JDBC 드라이버(라이브러리)를 등록(메모리에 로딩).
			DriverManager.registerDriver(new OracleDriver());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if(rs != null) rs.close(); // Null 오류가 날 수있음
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeResources(Connection conn, Statement stmt) {  // insert update 할때 항상 final에 들어가는 코드 들이서 이용
		closeResources(conn, stmt, null);
	} 
	
	 
	private Blog getBlogFromResultSet(ResultSet re) throws SQLException { //타입에 맞게 각각 데이터들을 읽어온다.
		int id = re.getInt(COL_ID); // 상수들을 import 한것들이 여기에 아규먼트에 들어감.
		String title = re.getString(COL_TITLE);
		String content = re.getString(COL_CONTENT);
		String author = re.getString(COL_AUTHOR);
		Timestamp createdTime = re.getTimestamp(COL_CREATED_TIME);
		Timestamp modifiedTime = re.getTimestamp(COL_MODIFIED_TIME);
		// 이 상수들이 블로그 클래스에서 내부에 상수로 쓰인 것들이 이쪽으로 get 읽어오기.
		// 가독서으 유지보수를 위해서
		
		
//		return new Blog(id, title, content, author, createdTime.toLocalDateTime(), modifiedTime.toLocalDateTime()); 
		
		return Blog.builder()
				.id(id)
				.title(title)
				.content(content)
				.author(author)
				.createdTime(createdTime)
				.modifiedTime(modifiedTime)
				.build();
	}
	
	// 전체 목록 보기에서 사용할 SQL 문장.
	private static final String SQL_SELECT_ALL = String.format(
			"select * from %s order by %s desc"
			, TBL_BLOGS, COL_ID);
			// 테이블이름, 컬럼
	
	// Read(select 문장)을 실행하는 메서드.
	public List<Blog> read() { // 메인에서 블로그들의 원소를 받을 수 있고 그것들을 JTable에 그려주면 됨.
		// DB 테이블에서 검색한 레코드들을 저장할 리스트 생성.
		List<Blog> blogs = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; // 테이블과 같은 형태의 객체
		try { 
			// DB 서버에 접속.
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			
			// DB 서버로 전송할 Statement 객체. (SQL 문장)
			stmt = conn.prepareStatement(SQL_SELECT_ALL); // SQL_SELECT_ALL 메서드
			
			
			// SQL 문장을 DB 서버에서 실행하고, 그 결과를 처리.
			rs = stmt.executeQuery();			
			// 이터레이터 반복자실행
			while (rs.next()) { // 결과처리.. // 다음행으로 넘어가는게 next가 하는일
				Blog blog = getBlogFromResultSet(rs); // Exception 처리는 다됨 // getBlog.. 는 각각 데이터를 읽어오는일
				blogs.add(blog); // 리스트에 추가 를 계속 반복..
			} //반복문이 끝나면..
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 사용했던 리소스들을 해제.
			closeResources(conn, stmt, rs); // 메소드로 클로즈 한번에 처리.
		}
		
		return blogs;
	}
	
	// 새 블로그 작성에서 사용할 SQL 문장.
	private static final String SQL_INSERT = String.format(
			"insert into %s (%s, %s, %s, %s, %s) values (?, ?, ?, systimestamp, systimestamp)", // 타이틀  
			TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_AUTHOR, COL_CREATED_TIME, COL_MODIFIED_TIME);
	
	// Create(insert 문장)을 실행하는 메서드 - 위쪽의 메서드를 호출해서 물음표를 채워주고 실행하는 역할.
	public int create(Blog blog) { // SQL을 실행했을때 리턴해주는 값이 int 값이니까 리턴값도 int 
		int result = 0; 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// DB 서버에 접속.
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB에 접속
			
			// Statement 객체 생성.
			stmt = conn.prepareStatement(SQL_INSERT); //파라미터 받아서
			
			// PreparedStatement의 파라미터(?)를 값으로 채움.(parameter binding)
			stmt.setString(1, blog.getTitle()); 
			stmt.setString(2, blog.getContent());
			stmt.setString(3, blog.getAuthor());
			
			
			// SQL 문장을 DB 서버에서 실행.
			result = stmt.executeUpdate(); // 쿼리는 select 나머지는 Update
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 리소스 해제
			closeResources(conn, stmt);
		}		
		return result; // 1이면 성공, 0이면 실패
		// 리턴이 되면 호출한 곳에게 준다 
	}
	
	// 블로그 아이디(PK)로 행 1개를 삭제하는 SQL.
	private static final String SQL_DELETE_BY_ID = String.format(
			"delete from %s where %s = ?",
			TBL_BLOGS, COL_ID);
	
	// Delete를 실행하는 메서드.
	public int delete(Integer id) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// DB 접속.
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// Statement 생성.
			stmt = conn.prepareStatement(SQL_DELETE_BY_ID);
			
			// PreparedStatement parameter binding
			stmt.setInt(1, id);
			
			// SQL 실행
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		return result;
	}
	
	// 블로그 아이디(PK)로 행 1개를 검색하는 SQL.
	// select * from blogs where id = ?
	private static final String SQL_SELECT_BY_ID = String.format(
			"select * from %s where %s = ?",
			TBL_BLOGS, COL_ID);
	
	// PK로 검색하는 메서드.
	
	public Blog read(Integer id) {
		Blog blog = null;
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			
			stmt.setInt(1, id);
			rs = stmt.executeQuery(); // 셀렉트는 쿼리
			
			if(rs.next()) {
				blog = getBlogFromResultSet(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		// TODO
		
		
		
		return blog;
	}
	
	// 해당 블로그 아이디의 제목, 내용, 수정시간을 업데이트 하는 SQL
	// update blogs set title = ?, content = ? , modified_time = systimestamp where id = ?
	
	private static final String SQL_UPDATE_BY_ID = String.format(
			"update %s set %s = ?, %s = ?, %s = systimestamp where %s = ?",
			TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_MODIFIED_TIME, COL_ID);
	
	//private int update(String title, String content, Integer id) {}
	public int update(Blog blog) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_UPDATE_BY_ID);
			
			stmt.setString(1, blog.getTitle());
			stmt.setString(2, blog.getContent());
			stmt.setInt(3, blog.getId());
			
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		
		return result;
	}
	
	// 대/소문자 구분없이 제목에 포함된 문자열로 검색하기.
	private static final String SQL_SELECT_BY_TITLE = String.format(
			"select * from %s where upper(%s) like upper(?) order by %s desc", 
			TBL_BLOGS,COL_TITLE, COL_ID);
			// format에 %는 특별한 의미를 갖기 때문에 '%' 는 대체하겠다는 의미인데 이런건 없는 의미,
			//그러므로 '%%' 를 쓰거나 ? 로 다른 메서드에서
	
	// 대/소문자 구분없이 내용에 포함된 문자열로 검색하기.
	private static final String SQL_SELECT_BY_CONTENT = String.format(
			"select * from %s where upper(%s) like upper(?) order by %s desc",
			TBL_BLOGS,COL_CONTENT, COL_ID);
	
	// 대/소문자 구분없이 작성자에 포함된 문자열로 검색하기.
	private static final String SQL_SELECT_BY_AUTHOR = String.format(
			"select * from %s where upper(%s) like upper(?) order by %s desc",
			TBL_BLOGS,COL_AUTHOR, COL_ID);
	
	// 대/소문자 구분없이 제목 또는 내용에 포함된 문자열로 검색하기.
	private static final String SQL_SELECT_BY_TITLE_OR_CONTENT = String.format(
			"select * from %s where upper(%s) like upper(?) or upper(%s) like upper(?) order by %s desc",
			TBL_BLOGS,COL_TITLE, COL_CONTENT, COL_ID);
	
	// 제목, 내용, 제목+내용, 작성자 검색을 수행하는 메서드
	public List<Blog> read(int type,String keyword) { 
		//콤보박스의 선택된 아이템을 찾거나 인덱스도 찾을 수 있다. 제목 0 내용 1 ...
		List<Blog> result = new ArrayList<>();
		
		Connection conn =  null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// like 검색을 사용하기 위해서, 검색어에 "%"를 붙임.
			String searchKeword = "%" + keyword + "%";
			switch(type) { // 검색타입에 따라서..
			case 0: //제목 검색
				stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE); // 제목 이라하는 SQL문장을 찾아서
				stmt.setString(1, searchKeword); // 퍼센트를 붙힌 키워드를 넣어준다.
				break;
			case 1: //내용 검색
				stmt = conn.prepareStatement(SQL_SELECT_BY_CONTENT);
				stmt.setString(1, searchKeword);
				break;
			case 2: //제목+내용 검색
				stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_CONTENT);
				stmt.setString(1, searchKeword);
				stmt.setString(2, searchKeword); // 물음표에 넣을 동일한 키워드.
				break;
			case 3: //작성자 검색
				stmt = conn.prepareStatement(SQL_SELECT_BY_AUTHOR);
				stmt.setString(1, searchKeword);
				break;
			}
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Blog blog = getBlogFromResultSet(rs); // 블로그를 만들어서 리턴해주는 메서드.
				result.add(blog); // 그럼 리스트에 한개가 add
		
			} // 그 다음 다음 행의 결과가 있으면 반복 없으면 리턴.
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		
		
		return result;
	}
}


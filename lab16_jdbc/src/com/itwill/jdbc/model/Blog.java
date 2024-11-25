package com.itwill.jdbc.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

// MVC 아키텍쳐에서 Model을 담당하는 객체.
public class Blog {

	// 데이터베이스 테이블의 테이블 이름과 컬럼 이름들을 상수로 정의하는 내부 클래스.
	// 테이블에 컬럼들을 저장할 용도로 문자열들의 클래스
	public static final class Entity{ 
		public static final String TBL_BLOGS = "BLOGS"; // 테이블의 접두사
		public static final String COL_ID = "ID"; // 컬럼의 접두사 - 컬럼의 이름을 저장하는 곳이라서 String
		public static final String COL_TITLE = "TITLE";
		public static final String COL_CONTENT = "CONTENT";
		public static final String COL_AUTHOR = "AUTHOR";
		public static final String COL_CREATED_TIME = "CREATED_TIME";
		public static final String COL_MODIFIED_TIME = "MODIFIED_TIME";
	} // 상수들로 정의를 해두면 수정할 때 여기만 고치면 됨.
	
	private Integer id; // blogs 테이블의 PK
	private String title;
	private String content;
	private String author;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;
	// 블로그가 가져야할 중요한 속성
	

	public Blog() {} // 기본 생성자.

	public Blog(Integer id, String title, String content, String author, LocalDateTime createdTime,
			LocalDateTime modifiedTime) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Blog [id= " + id + ", title= " + title + ", content= " + content + ", author= " + author
				+ ", createdTime= " + createdTime + ", modifiedTime= " + modifiedTime + "]";
	}

	
	
	
	
	// Builder 디자인 패턴

	public static BlogBuilder builder() {
		return new BlogBuilder();
	}
	
	
	public static class BlogBuilder {
		private Integer id;
		private String title;
		private String content;
		private String author;
		private LocalDateTime createdTime;
		private LocalDateTime modifiedTime;

		private BlogBuilder() {
		}

		public BlogBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public BlogBuilder title(String title) {
			this.title = title;
			return this;
		}

		public BlogBuilder content(String content) {
			this.content = content;
			return this;
		}

		public BlogBuilder author(String author) {
			this.author = author;
			return this;
		}

		public BlogBuilder createdTime(LocalDateTime createdTime) {
			this.createdTime = createdTime;
			return this;
		}

		public BlogBuilder createdTime(Timestamp createdTime) { // null을 제약을 안줬기 때문에 nullpointer 를 발생하기 때문에  
			// Timestamp 타입 객체를 LocalDateTime 타입 객체로 변환해서 필드에 저장.
			if (createdTime != null) {
				this.createdTime = createdTime.toLocalDateTime();
			}
			return this;
		}
				
		
		
		public BlogBuilder modifiedTime(LocalDateTime modifiedTime) {
			this.modifiedTime = modifiedTime;
			return this;
		}

		public BlogBuilder modifiedTime(Timestamp modifiedTime) { // null을 제약을 안줬기 때문에 nullpointer 를 발생하기 때문에 
			// Timestamp -> LocalDateTime
			if(modifiedTime != null) {
				this.modifiedTime = modifiedTime.toLocalDateTime();
			}
			return this;
		}
				
		
		public Blog build() {
			return new Blog(id, title, content, author, createdTime, modifiedTime);
		}
	}

}

package com.itwill.blog.controller;

import com.itwill.blog.model.Blog;

//MVC 아키텍쳐에서 Controller 역할을 담당하는 구현 클래스.
public class BlogDaoImpl implements BlogDao {

	
	// ------ singleton 구현 시작
	
	private static BlogDaoImpl instance = null;
	
	private BlogDaoImpl() {}
	// 스태틱메서드가 없기때문에 객체를 리턴해줄수 있는 클래스가 필요한데
	public static BlogDaoImpl getInstance() {
		if(instance == null) {
			instance = new BlogDaoImpl();
		}
		return instance;
	}
	
	//------- singleton 구현 끝
	
	private static final int MAX_LENGTH = 3; // 블로그 배열의 길이(원소 개수).
	
	private Blog[] blogs = new Blog[MAX_LENGTH]; // 블로그들을 저장할 배열. 미리 NULL로 초기화 MAX_LENGTH의 길이
	
	private int count = 0; // 배열 blogs에 저장된 원소 개수. 새 블로그가 저장될 때마다 ++.
	
	/**
	 * 블로그를 저장하는 배열이 가득 차 있으면 true, 빈 공간(null)이 있으면 false를 리턴.
	 * @return true/false 
	 */
	public boolean isMemoryFull() {
		return (count == MAX_LENGTH); //현재 저장된 개수와 배열의 길이가 같으면 true 
	}
	
	/**
	 * 인덱스가 배열의 유효한 인덱스인 지를 검사.
	 * 인덱스가 0 이상이고, 배열에 저장된 원소 개수보다 작으면 유효한 인덱스(true),
	 * 그렇지 않으면 유효하지 않은 인덱스(false).
	 * @param index 유효한 지 여부를 검사할 인덱스. 정수.
	 * @return true/false.
	 */
	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < count);
	}
	
	@Override
	public int create(Blog blog) {
		if(isMemoryFull()) {
			return 0;
		}
		// 배열 blogs에 원소를 저장하고 count를 증가.
		blogs[count] = blog;
		count++;
		
		return 1;
	}

	@Override
	public Blog[] read() {
		// 배열 blogs에서 null이 아닌 원소들만 복사해서 리턴.
		Blog[] result = new Blog[count]; // 현재까지 저장된 원소 개수로 배열을 생성.
		for(int i = 0; i<count; i++) {
			result[i] = blogs[i]; // 배열 blogs의 원소를 result에 복사.
		}		
		return result;
	}

	@Override
	public Blog read(int index) { 
		if(isValidIndex(index)) {
			return blogs[index];
		} else {
			return null; //리턴할만한 타입이 없으면 null
		}
			
	}

	@Override
	public int update(int index, Blog blog) {
		if(!isValidIndex(index)) {
			return 0;
		}		
		blogs[index].setTitle(blog.getTitle());
		blogs[index].setContent(blog.getContent());
		return 1;
	}

}

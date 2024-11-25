package com.itwill.contact.ver02;

import com.itwill.contact.ver01.Contact;

// MVC 아키텍쳐에서 Controller 역할을 담당하는 인터페이스. (메서드를 선언)
// -> TODO: 인터페이스 구현 클래스 작성.
public interface ContactDao {
	
	/**
	 * 연락처 저장 기능.
	 * 연락처(이름, 번호, 이메일)를 배열에 저장하는 메서드
	 * @param contact Contact 타입의 객체이며, 이름, 번호, 이메일을 데이터로 갖는 객체
	 * @return 배열에 저장을 성공하면 1, 실패하면 0을 리턴.
	 */
	int create(Contact contact);
	
	/**
	 * 인덱스 목록 기능.
	 * 배열에 저장된 연락처(이름, 번호, 이메일) 목록을 보여주는 메서드
	 * @return 배열에 저장된 연락처를 리턴.
	 */
	Contact[] read();
	
	/**
	 * 인덱스 검색 기능.
	 * 배열에 저장된 연락처(이름, 번호, 이메일) 목록에서 인덱스를 사용해서 원하는 데이터를 출력하는 메서드
	 * @param index 검색에 필요한 0 이상의 정수
	 * @return 
	 */
	Contact read(int index);
	
	/**
	 * 연락처 업데이트(수정)기능 
	 * 연락처에 저장된 인덱스의 값을 받아서 해당 인덱스의 이름, 번호, 이메일을 수정하는 기능
	 * @param index 수정할 인덱스 0이상의 정수
	 * @param contact 수정할 이름, 번호, 이메일을 저장하고 있는 데이터
	 * @return 저장에 성공하면 1, 실패하면 0을 리턴.
	 */
	int update(int index, Contact contact);
	
}

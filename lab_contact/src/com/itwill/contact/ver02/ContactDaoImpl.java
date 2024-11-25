package com.itwill.contact.ver02;

import com.itwill.contact.ver01.Contact;

public class ContactDaoImpl implements ContactDao{
	//-----> singleton
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {}
	
	public static ContactDaoImpl getInstance() {
		if(instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	private static final int MAX_LENGTH = 3;
	private Contact[] contacts = new Contact[MAX_LENGTH];
	private int count = 0;
	
	public boolean indexMaxFullValue() {
		return (count == MAX_LENGTH);
	}
	
	public boolean indexLimitValue(int value) {
		return ((value >= 0) && (value < count));
	}
	
	@Override
	public int create(Contact contact) {
		contacts[count] = contact;
		count++;
		return 1;
	} //리스트 에드
	
	@Override 
	public Contact[] read() { // 리스트만 리턴
		Contact[] result = new Contact[count]; // Contact 배열타입의 result 변수를 만들어 Contact[count]의 크기를 같는 객체를 생성.
		for(int i = 0; i < count; i++) { // count 크기만큼 반복
			result[i] = contacts[i]; // coutacts 배열의 i번째를 resutl 배열 i에 대입?
		}
		return result; // 메인 메서드 dao.read()에 리턴. 
	} // 객체를 다시 생성하는 이유는 원본의 데이터를 보호하고 필요한 데이터를 반환.

	@Override
	public Contact read(int index) { // 인덱스의 값으로 연락처 검색. 인덱스를 받아서 리턴
		if(indexLimitValue(index)) { // 검색 입력했을때 배열 범위 안의 값을 입력 했을 경우 리턴 그게 아니라면 null
			return contacts[index]; 		
		} else {
			return null;
		} //리스트 겟 
	}

	@Override
	public int update(int index, Contact contact) { // 수정할 인덱스 데이터를 받아서 contact 에 있는 내용을 
		contacts[index].setName(contact.getName()); // get으로 불러와서 set으로 수정.
		contacts[index].setPhone(contact.getPhone());
		contacts[index].setEmail(contact.getEmail());
//		contacts[index]	= contact;
		return 1; // 성공했다는 가정에 항상 1을 리턴.
	} //리스트 겟
	
}

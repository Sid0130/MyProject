package com.itwill.list05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMain05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Member 타입을 저장하는 리스트 선언, 객체 생성.
		List<Member> members = new ArrayList<>(); 
		// 5번 반복. id와 password를 입력 - Member 타입 객체를 생성. 리스트에 Member 객체 저장.
		
		for (int i = 0; i < 5; i++) {
			System.out.print("ID > ");
			String id = scanner.nextLine();
			System.out.print("Password> ");
			String password = scanner.nextLine();
			Member m = new Member(id, password);
			
			members.add(m);
		}

		// Member들의 리스트의 원소들을 출력. for문도 상관없음.
		
		for(Member m: members) {
			System.out.println(m);
		}
		
		
		/*
		 * 회원 아이디 검색할 아이디 물어보기. 검색결과도 리스트 검색어 스캐너로 입력
		 * 
		 * id 검색어를 입력받고, id에 검색어가 포함된 멤버들의 리스트를 만들고 출력.
		 * 검색어는 대/소문자를 구분없이 검색이 가능해야 함. 찾은거를 add add 
		 * 이름에 포함된 해당하는거 다 찾기 
		 * 
		 */
		ArrayList<Member> searchResult = new ArrayList<>();
		System.out.print("ID 검색어>");
		String keyword = scanner.nextLine();
		
		for(Member m : members) {
			if(m.getId().toLowerCase().contains(keyword.toLowerCase())) {
				searchResult.add(m);
			}
		}
		System.out.println(searchResult);
		
			
			
		// 삭제할 id를 입력 받고, 처음 id가 일치하는 멤버 객체를 리스트에서 삭제.
		// 삭제 후 리스트를 출력.
		System.out.print("삭제할 ID> ");
		String idToDel = scanner.nextLine();
		Member memToDel = new Member(idToDel, null); //해쉬코드랑 이퀄스가 있었기 때문에 가능
		members.remove(memToDel); // 같은 객체를 지운다.
		// 아이디가 같으면 같은 멤버다라고 오버라이드 했고 해쉬코드와 이퀄스도 오버라이드가 됬기 때문에 삭제하는게 가능했다.
		
		System.out.println(members);
		
		System.out.print("삭제할 ID2 > "); // 멤버의 이퀄스가 없을 때 사용하는 방법.
		String id = scanner.nextLine()	;
		for(Member m : members) {
			if(m.getId().equals(id)) {
				members.remove(m);
				break;
			}
		}
		System.out.println(members);
	}
}

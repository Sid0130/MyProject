package com.itwill.contact.ver04.view;

import java.util.List;
import java.util.Scanner;

import com.itwill.contact.ver04.controller.ContactDao;
import com.itwill.contact.ver04.model.Contact;

// MVC 아키텍쳐에서 View 역할 담당.
public class ContactMain04 {
	
	private Scanner scanner;
	private ContactDao dao;
	
	public ContactMain04() {
		scanner = new Scanner(System.in);
		dao = ContactDao.INSTANCE;
	}
	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.4 ***");
		boolean run = true;
		ContactMain04 app = new ContactMain04();
		while(run) {
			MainMenu menu = app.setMainMenu();
			switch(menu) {
			case QUIT:
				run = false;
				break;
			case CREATE:
				app.createNewContact();
				break;
			case READ_ALL:
				app.readAllContacts();
				break;
			case READ_BY_INDEX:
				app.readContactByIndex();
				break;
			case UPDATA:
				app.updataContact();
				break;
			case DELETE:
				app.deleteContact();
				break;
			default:
				System.out.println("메뉴 [0 ~ 5]를 다시 입력하세요.");				
			}
		}
		System.out.println("프로그램 종료");
		
	}
	
	private void deleteContact() {
		System.out.println("-------------- 연락처 삭제--------------");
		System.out.print("인덱스 선택> ");
		int select = inputInteger();
		
		int result = dao.delete(select);
		if(result == 1) {
			System.out.println(">>> 삭제 성공");
		} else {
			System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다.");
		}
		
	}
	private void updataContact() {
		System.out.println("-------------- 연락처 수정--------------");
		System.out.print("인덱스 선택 > ");
		int select = inputInteger();
		
		if(!dao.isValidIndex(select)) {
			System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다.");
			return;
		}
		
		System.out.println("수정 전: " + dao.read(select));
		
		System.out.print("이름 > ");
		String name = scanner.nextLine();
		System.out.print("전화번호 > ");
		String phone = scanner.nextLine();
		System.out.print("이메일 > ");
		String email = scanner.nextLine();
		Contact after = new Contact(null, name, phone, email);
		
		System.out.println("수정 후: " + after);
		int result = dao.updata(select, after);
		if(result == 1) {
			System.out.println(">>> 업데이트 성공");
		} else {
			System.out.println(">>> 업데이트 실패");
		}
	}
	private void readContactByIndex() {
		System.out.println("-------------- 연락처 검색 --------------");
		System.out.print("검색 > ");
		int select = inputInteger();
		Contact contact = dao.read(select);
		if(contact != null) {
			System.out.println(contact);
			
		} else {
			System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다.");
		}
//		if(!dao.isValidIndex(select)) {
//			System.out.println("번호가 없습니다.");
//			return;
//		} 
//		Contact index = dao.read(select);
//		System.out.println(index.toString());
	}
	private void readAllContacts() {
		System.out.println("-------------- 연락처 목록 --------------");
		List<Contact> list = dao.read();
		for(int i = 0; i <list.size(); i++) {
			System.out.printf("[%d] %s\n", i, list.get(i));
		}
		System.out.println("-----------------------------------------");
		
	}
	private void createNewContact() {
		System.out.println("-------------- 연락처 저장 --------------");
//		System.out.print("선택 > ");
//		int select = Integer.parseInt(scanner.nextLine());
		System.out.print("이름 > ");
		String name = scanner.nextLine();
		System.out.print("전화번호 > ");
		String phone = scanner.nextLine();
		System.out.print("이메일 > ");
		String email = scanner.nextLine();
		
		Contact contacts = new Contact(null, name, phone, email);
		int result = dao.create(contacts);
		if(result == 1) {
			System.out.println(">>> 저장 성공");
		} else {
			System.out.println(">>> 저장 실패");
		}
		
		
	}
	public MainMenu setMainMenu() {
		System.out.println("\n----------------------------------------------------");
		System.out.println("0.종료 | 1.저장 | 2.목록 | 3.검색 | 4.수정 | 5.삭제" );
		System.out.println("----------------------------------------------------");
		System.out.print("선택 > ");
		int select = inputInteger();
		
		return MainMenu.getMainMenu(select);
	}
	
	private int inputInteger() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
				
			} catch (NumberFormatException e) {
				System.out.print("정수 입력 > ");
			}
		}
	}
}

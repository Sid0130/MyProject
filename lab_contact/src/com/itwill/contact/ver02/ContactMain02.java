package com.itwill.contact.ver02;

import java.util.Scanner;

import com.itwill.contact.ver01.Contact;

//MVC 아키텍쳐에서 View(UI) 역할을 담당하는 클래스.
public class ContactMain02 {
	
	private Scanner scanner = new Scanner(System.in);
	private ContactDao dao = ContactDaoImpl.getInstance(); // 클래스이름 메서드이름이 getInstance 클래스 타입과 동일한경우 싱글톤일 확률이 높음.
	
	public static void main(String[] args) {
		System.out.println("\t*** 연락처 프로그램 v0.2 ***");
		
		ContactMain02 apps = new ContactMain02(); //메인이 스테틱이 아닌 메서드를 호출하려면 객체를 생성해야지 클래스,필드에 선언된 메서드들을 사용할 수 있다.
		boolean run = true;
		
		while(run) {
			
			MainMenu menu = apps.selectMainMenu(); // 이넘타입의 menu 변수를 메인 클래스메서드를 호출? 
			switch(menu) {
			case QUIT:
				run = false;
				break;
			case CREATE:
				apps.contactCreate();
				break;
			case READ_ALL:
				apps.readContactAll();
				break;
			case READ_BY_INDEX:
				apps.readContactByIndex();
				break;
			case UPDATE:
				apps.contactUpdate();
				break;
			default:
				System.out.println("번호를 다시 입력...");	
			}
		}
		System.out.println("프로그램 종료");
	}
			
	
	private void contactUpdate() { // 수정
		System.out.println("\n--------------- 연락처 수정 ---------------");
	
		System.out.print("수정 번호 > ");
		int choice = Integer.parseInt(scanner.nextLine());
		if(!((ContactDaoImpl)dao).indexLimitValue(choice)) {
			System.out.println("번호 다시 선택...");
			return;
		}
		Contact before = dao.read(choice);
		System.out.println("수정 전 > " + before);
		System.out.print("이름 >");
		String name = scanner.nextLine();
		System.out.print("전화번호 > ");
		String phone = scanner.nextLine();
		System.out.print("이메일 > ");
		String email = scanner.nextLine();
		
		Contact after = new Contact(name, phone, email);
		int result = dao.update(choice, after);
		if(result == 1) {
			System.out.println("수정 성공!");
		} else {
			System.out.println("수정 실패!");
		}

				
	}


	private void readContactByIndex() { // 연락처 검색은 번호를 선택하면 나오게 출력
		System.out.println("\n--------------- 연락처 검색 ---------------");
		System.out.print("번호 선택 > ");
		int choice = Integer.parseInt(scanner.nextLine());
		if(!((ContactDaoImpl)dao).indexLimitValue(choice)) {
			System.out.println("번호 다시 선택...");
			return;
		}
				
		Contact index = dao.read(choice);
		System.out.println(index.toString());
			
	}


	private void readContactAll() {
		System.out.println("\n--------------- 연락처 목록 ---------------");
		Contact[] contacts = dao.read();
		for(int i = 0; i < contacts.length; i++) { // 목록을 반복문으로 배열 길이만큼 데이터를 받아서 get으로 출력
			System.out.printf("[%d] name= %s, phone= %s, email= %s\n", 
					i, contacts[i].getName(), contacts[i].getPhone(), contacts[i].getEmail()); 
		}
	}


	private void contactCreate() {
		System.out.println("\n--------------- 연락처 저장 ---------------");
		if(((ContactDaoImpl)dao).indexMaxFullValue()){
			System.out.println("저장 공간 부족...");
			return;	
		}
		
		System.out.print("이름 > ");
		String name = scanner.nextLine();
		System.out.print("전화번호 > ");
		String phone = scanner.nextLine();
		System.out.print("이메일 > ");
		String email = scanner.nextLine();		
		Contact contacts = new Contact(name, phone, email); // 데이터를 입력 받아서 다오에 넘겨줘야함
		
		int result = dao.create(contacts); // 다오에서 성공했는지 안했는지 result로 넘겨야함 1또는 0.
		if(result == 1) { // 저장에 성공했으면 view에 출력 
			System.out.println("저장 성공!");
		} else {
			System.out.println("저장 실패!");
		}	
		
	}
			
		
			
	private MainMenu selectMainMenu() {
		System.out.println("\n-------------------------------------------");
		System.out.println("0.종료 | 1. 저장 | 2.목록 | 3.검색 | 4.수정");
		System.out.println("-------------------------------------------");
		System.out.print("선택 > ");
		int select = Integer.parseInt(scanner.nextLine());
				
		return MainMenu.getMainMenu(select);
	}

}

package com.itwill.contact.ver01;

import java.util.Scanner;


public class ContactMain {
	// 상수 정의
	private static final int MAX_LENGTH = 3;
	
	// ContactMain 클래스의 field를 선언과 동시에 초기화
	private Scanner scanner = new Scanner(System.in); // 콘솔 입력
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처 저장하기 위한 배열
	private int count = 0; // 배열 contacts에 새로운 연락처가 저장될 때 값을 1씩 증가.

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.1 ***");
		
		// ContactMain 타입의 변수 선언, 초기화 : ContactMain의 static이 아닌 멤버들을 사용하기 위해
		ContactMain app = new ContactMain();
		
		boolean run = true; // while 문을 계속 반복할 지 여부를 결정.
		
		while(run) {
			int menu = app.selectMainMenu();
			
			switch(menu) {

			case 0:
				run = false;
				break;
			case 1:
				app.saveNewContact();
				break;
			case 2:
				if(app.count < 0) {
					System.out.println("저장된 번호가 없습니다.");
					continue;
				} 	
				app.printContactList();
				break;
			case 3:
				if(app.count < 0) {
					System.out.println("저장된 번호가 없습니다.");
					continue;
				} 				
				app.selectContactByIndex();
				
				break;
			case 4:
				if(app.count < 0) {
					System.out.println("저장된 번호가 없습니다.");
					continue;
				} 
				
				app.updateContactByIndex();
				break;
			default :
				System.out.println("번호를 다시 선택하세요.");
			}
		}
		System.out.println("프로그램 종료");
	}
	
	public int selectMainMenu() {
		System.out.println("\n==============================================");
		System.out.println("0.종료 | 1.저장 | 2.리스트 | 3.검색 | 4.수정");
		System.out.println("==============================================");
		System.out.print("번호를 선택 하세요 > ");
		
		int menu = Integer.parseInt(scanner.nextLine());
		
	
		return menu;
	
	}
	
	public void saveNewContact() {
		if(count == MAX_LENGTH) {
			System.out.println(">>> 저장 공간 부족 ");
			return; // 메서드 종료
		}
		
		System.out.println("\n============== 새 연락처 저장 ==============");
		
		
		System.out.print(" 이름 입력 > ");
		String name = scanner.nextLine();
		System.out.print(" 번호 입력 > ");
		String phone = scanner.nextLine();
		System.out.print(" 메일 입력 > ");
		String email = scanner.nextLine();
		Contact c = new Contact(name, phone, email);
		
			
		
		
		contacts[count] = c;
		count++;
		
//		if(count >= contacts.length) {
//			System.out.println(">>> 번호가 꽉찼습니다!!!");
//			return;
//		} else {
//			contacts[count] = c;
//			count++;
//			// 필드에 변수를 생성해두면 다른 메서드에서 사용 가능
//		}	
		System.out.println(">>> 연락처 저장 성공!");
	}
	
	public void printContactList() {
		System.out.println("\n============== 내 연락처 리스트 ==============");
		
		for(int i = 0; i < count; i++) {
//			System.out.println("[" + i + "] " + contacts[i].toString()); // 문자열에 보이드에 더할순없다
			System.out.printf("[%d] %s\n", i, contacts[i].toString());
		}
			
		System.out.println("==============================================");
	}
	
	public void selectContactByIndex() {
		System.out.println("\n=============== 내 연락처 검색 ===============");
		System.out.print("검색할 번호 > ");
		int index = Integer.parseInt(scanner.nextLine());
		System.out.println("\n==============================================");
		
		if(index >= 0 && index < count) {
			// 해당 인덱스의 배열 원소를 출력.
			System.out.println(contacts[index].toString());
		} else {
			System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다.");
		}
		
//		if((index >= contacts.length || index < 0) || (contacts[index] == null)) {
//			System.out.println("검색된 번호가 없습니다.");
//		} else {
//			System.out.printf("[%d]",index);
////			contacts[index].info();
//			System.out.println(contacts[index].toString());
//		}
			
	}
	public void updateContactByIndex() {
		System.out.println("\n=============== 내 연락처 수정 ===============");
		System.out.print("수정할 번호 > ");
		int index = Integer.parseInt(scanner.nextLine());
			
		if(index < 0 || index >= count) {
			System.out.println(">>> 해당 인덱스에는 수정할 연락처 정보가 없습니다");
			return;
		}
//		if((index >= contacts.length || index < 0) || (contacts[index] == null)) {
//			System.out.println("수정할 번호가 없습니다.");
//		} else {
			System.out.print("수정 전 >>> ");
			System.out.println(contacts[index].toString());
//			contacts[index].info();

			System.out.print("이름 입력 > ");
//			contacts[index].setName(scanner.nextLine());
			String name = scanner.nextLine();
			
			System.out.print("전화번호 입력 > ");
//			contacts[index].setPhone(scanner.nextLine());
			String phone = scanner.nextLine();
			
			System.out.print("이메일 입력 > ");
//			contacts[index].setEmail(scanner.nextLine());
			String email = scanner.nextLine();
			contacts[index] = new Contact(name, phone, email);
			
			System.out.print("수정 후 >>> ");
			System.out.println(contacts[index].toString());
//			contacts[index].info();
//		}
			
        System.out.println("\n==============================================");
	}

}

package com.itwill.contact.ver03;

import java.util.List;
import java.util.Scanner;

import com.itwill.contact.ver01.Contact;
import com.itwill.contact.ver02.MainMenu;

// MVC 아키텍쳐에서 View(UI) 역할을 담당하는 클래스.
public class ContactMain03 {
    
    private Scanner scanner = new Scanner(System.in);
    private ContactDao dao = ContactDao.INSTANCE; // 유일한 상수인 인스턴스를 dao가 저장
    // 이제 dao. 하면 ContactDao가 가지고 있는 메서드들을 호출할 수 있다.
    
    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.3 ***");
     
        ContactMain03 app = new ContactMain03();
        
        boolean run = true;
        while (run) {
            MainMenu menu = app.selectMainMenu();
            switch (menu) {
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
            case UPDATE:
                app.updateContact();
                break;
            case DELETE:
                app.deleteContact();
                break;
            default:
                System.out.println("메뉴(0 ~ 5)를 다시 선택하세요.");
            }
        }

        
        System.out.println("*** 프로그램 종료 ***");
    }

    private int inputInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("정수 입력> ");
            }
        }
    }
    
    private void deleteContact() {
        System.out.println("\n--- 연락처 삭제 ---");
        
        System.out.print("삭제할 인덱스> ");
        int index = inputInteger();
        if (!dao.isValidIndex(index)) {
            System.out.println(">>> 해당 인덱스에는 삭제할 연락처 정보가 없습니다.");
            return; // 메서드 종료
        }
        
        int result = dao.delete(index);
        if (result == 1) {
            System.out.println(">>> 연락처 삭제 성공");
        } else {
            System.out.println(">>> 연락처 삭제 실패");
        }
    }

    private void updateContact() {
        System.out.println("\n--- 연락처 업데이트 ---");
        
        System.out.print("수정할 인덱스> ");
        int index = inputInteger();
        
        if (!dao.isValidIndex(index)) {
            System.out.println(">>> 해당 인덱스에는 수정할 연락처 정보가 없습니다.");
            return; // 메서드 종료
        }
        
        // 컨트롤러 메서드를 호출해서 업데이트 전의 연락처 정보를 읽어옴.
        Contact before = dao.read(index);
        System.out.println(">>> 수정 전: " + before);
        
        System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
        Contact after = new Contact(name, phone, email);
        
        // 컨트롤러 메서드를 호출해서 해당 인덱스의 연락처 정보를 업데이트함.
        int result = dao.update(index, after);
        if (result == 1) {
            System.out.println(">>> 연락처 업데이트 성공");
        } else {
            System.out.println(">>> 연락처 업데이트 실패");
        }
    }

    private void readContactByIndex() {
        System.out.println("\n--- 인덱스 검색 ---");
        
        System.out.print("인덱스> ");
        int index = inputInteger();
        
        if (!dao.isValidIndex(index)) {
            System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }
        
        // 컨트롤러 메서드를 호출해서 해당 인덱스의 연락처 정보를 검색.
        Contact contact = dao.read(index);
        System.out.println(contact);
    }

    private void readAllContacts() {
        System.out.println("\n--- 연락처 목록 ---");
        
        // 컨트롤러 메서드를 호출해서 연락처 목록(배열)을 읽어옴.
        List<Contact> contacts = dao.read();
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("[%d] %s\n", i, contacts.get(i));
        }
    }

    private void createNewContact() {
        System.out.println("\n--- 새 연락처 저장 ---");
        
        System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(name, phone, email);
        
        // 컨트롤러의 메서드를 호출해서 입력받은 연락처 정보를 배열에 저장.
        int result = dao.create(contact);
        if (result == 1) {
            System.out.println(">>> 새 연락처 저장 성공");
        } else {
            System.out.println(">>> 새 연락처 저장 실패");
        }
    }

    private MainMenu selectMainMenu() {
        System.out.println("\n-----------------------------------------------------");
        System.out.println("0.종료 | 1.저장 | 2.리스트 | 3.검색 | 4.수정 | 5.삭제");
        System.out.println("-----------------------------------------------------");
        System.out.print("선택> ");
        int choice = inputInteger(); // <- try-catch가 포함된 메서드
        
        return MainMenu.getMainMenu(choice);
    }

}

// 메인(뷰)은 다오의 메서드를 호출하면서 create(Contact) 다오에게 호출하고 필요한 데이터를 준다. 컨트롤러는 그 아규먼트를 이용해서 리턴을 해준다. 
// 메인(뷰) 컨트롤러에 메서드를 호출 컨트롤러는 그 결과를 리턴해준다. 모델은 그 사이에서 메서드에 아규먼트, 리턴타입으로 사용됨. 이것이 MVC구조


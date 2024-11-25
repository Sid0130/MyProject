package com.itwill.file08;

import java.io.File;

/*
 * 파일, 폴더(디렉토리) 관리 - 정보, 생성, 삭제, 이름변경, ...
 * 
 * 현재 작업 폴더(CWD: Current Working Directory):
 *  - 현재 프로그램(프로세스)가 실행되는 폴더 위치.
 *  - 이클립스에서 자바 프로그램을 실행(Run as a Java app.)할 때,
 *  현재 작업 폴더의 위치는 프로젝트 폴더!.
 * 절대 경로(absolute path):
 * 	- 시스템의 루트(C:\, D:\, /)부터 파일 또는 폴더가 있는 위치까지를 찾아가는 방식
 *  - (MS Windows 예) C:\java157\workspace\lab_java\...txt  폴더와 폴더를 구분할때 백슬래쉬
 *  - (Linux, MacOS 예) /users/itwill/documents/...txt    슬래쉬
 * 상대 경로(relative path):
 *  - 현재 작업 폴더를 기준으로 파일 또는 폴더가 있는 위치를 찾아가는 방식.
 *  -(MS Windows 예) data\...txt
 *  -(Linux, MacOS 예) data/...txt   자바는 자동으로 
 *  
 */


public class FileMain08 {

	public static void main(String[] args) {
		// 절대 경로
		String path1 = "C:\\java157\\workspaces\\lab-java\\lab12_file\\data\\ANSI.txt";
		System.out.println(path1);
		// 상대 경로
//		String path2 = "data\\ASNI.txt"; // MS-Windows에서만 사용 가능한 표기법
//		String path2 = "data/ANSI.txt"; // 쓰여진 그대로 쓰임.
		//시스템마다 구분하면서 써야하기 때문에 그럴 필요 없이 separator를 사용
		
		// File.separator: OS에 의존적인 파일 구분자(/ 또는 \)를 자동으로 선택.
		String path2 = "data" + File.separator + "ANSI.txt"; // 시스템의 의존적인 구분자 윈도우에서 백슬래시 맥에서는 슬래쉬로 변환해준다. 
		System.out.println(path2);
		
		// File 클래스: 
		// 파일(txt, jpg, mp4, ...)과 폴더(디렉토리)에 관련된 기능(메서드)들을 가지고 있는 클래스(타입). 
		// -> 프로그램에서 좁은 의미의 파일과 담고있는 폴더를 함께 가르키는 객체가 File 객체
		File f = new File(path2); // 파일을 관리하기 위한 객체.
		System.out.println("절대 경로: " + f.getAbsolutePath()); // 상대 경로로해도 절대 경로를 알수있다.
		System.out.println("존재 여부: " + f.exists()); 
		System.out.println("파일 여부: " + f.isFile());
		System.out.println("폴더 여부: " + f.isDirectory());
		System.out.println("파일 크기: " + f.length() + " byte"); // 단위는 바이트
		
		// 새 폴더 만들기
		File testFolder = new File("data", "test"); // 상대 경로 data/test 상위 하위
		if(testFolder.exists()) {
			System.out.println("이미 test 폴더가 존재합니다.");
		} else {
			boolean result = testFolder.mkdir(); // make directory  폴더 생성.
			if(result) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}		
		} 
		
		// 폴더 삭제
		if(testFolder.exists()) { // 폴더, 파일 삭제 가능
			boolean result = testFolder.delete();
			if(result) {
				System.out.println("폴더 삭제 성공");
			} else {
				System.out.println("폴더 삭제 실패");
			}
		} else {
			System.out.println("test 폴더가 존재하지 않습니다.");
		}
	}

}

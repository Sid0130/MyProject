package com.itwill.file01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * 입/출력 스트림(Input/Output Stream): 프로그램이 데이터(값)을 입력받거나 출력하는 통로. // 데이터가 지나가는 통로가 스트림 
 * 프로그램 파일에 작성한다라고하면 자바프로그램이 데이터를 하드디스크 파일로 보내주는데 작성하라고 지시하거니 반대로 파일 내용을 가져올때 통로를 통해서 프로그램으로 들어온다. 
 *  (예) System.in: (콘솔) 입력 스트림 객체. 인풋
 *  (예) System.out: (콘솔) 출력 스트림 객체. 아웃풋
 *  
 * 자바는 입/출력을 같이 만들 수는 없고 각각 만들어야한다.
 *  
 * 프로그램 ===> OutputStream (write) ===> 출력 장치(콘솔, 모니터, 프린터, 파일, ...)
 * OutputStream 은 추상클래스 그 추상메서드를 사용해 하나하나 어떤 출력장치에 따라 각각 클래스가 만들어졌고
 * 그거에 따라 만들어진 클래스를 호출 및 사용.
 * 스트림 = 통로
 * 프로그램 <=== InputStream (read) <=== 입력 장치(콘솔, 키보드, 마우스, 파일, ...)
 * 
 * 프로그램 ===> FileOutputStream (write) ===> 파일
 * 프로그램 <=== FileInputStream (read) <=== 파일
 * 
 * java.io.InputStream: 프로그램이 데이터를 읽어들이는 통로.
 * |__ FileInputStream: 프로그램이 파일에서 데이터를 읽어들이는 통로.
 *   (1) FileInputStream 객체 생성.
 *   (2) FileInputStream 객체의 read 관련 메서드 호출.
 *   (3) FileInputStream 객체를 닫음(close). 다른 인풋스트림 아웃풋이 이용할수있도록 닫아줘야하고 열어놓으면 메모리가 사용이되기 때문에.
 *    
 * java.io.OutputStream: 프로그램이 데이터를 쓰는 통로.
 * |__ FileOutputStream: 프로그램이 파일에 데이터를 쓰는 통로.
 * 	 (1) FileOutputStream 객체 생성.
 *   (2) FileOutputStream 객체의 write 관련 메서드 호출.
 *   (3) FileOutputStream 객체를 닫음(close).
 *   
 */
public class FileMain01 {

	public static void main(String[] args) {
		// data/hello.txt 파일의 내용을 읽고, data/hello_copy.txt 파일로 복사.
		String origin = "data/hello.txt"; // 텍스트 파일이 아니라 여러가지 파일들.
		String destination = "data/hello_copy.txt";
		
		
		FileInputStream in = null; // 파일 읽기 통로 -  지역 변수 바깥에서 선언
		// in은 파일이 없으면 에러.
		// try-catch에 작성하지 않는 이유: 
		FileOutputStream out = null; // 파일 쓰기 통로
		try { 
			in = new FileInputStream(origin); // FIS 객체 생성 
			// 예외상황을 처리하지 않아서 오류가 뜸. 그래서 try-catch
			// FileNotFoundException 발생할수있다.
			
			out = new FileOutputStream(destination);
			
			while(true) { // 무한 반복문
				int read = in.read(); // 파일에서 1바이트를 읽음.
				if(read == -1) { // 파일 끝(EOF, end-if-file)에 도달했을 때.
					break; // 무한 반복문 종료.
				}
				//System.out.println((char) read); // (char) read 한글은 2바이트가 필요한데 1바이트 1바이트 쪼개서 출력하니 글자가 조합할 수 없다.
				
				out.write(read); // 1바이트를 파일에 씀. int 4바이트에서 나머지 바이트는 0으로 채워져있다.
			}	//읽어드린 내용을 파일에 쓰겠다.
			// 파일의 1byte만 읽음. 파일 끝에 도달했을때 -1
			System.out.println("파일 복사 종료");
			
		} catch (Exception e) {// IOException에서 IO는 인풋아웃풋
			e.printStackTrace(); // Exception이 발생하면 로그 찍어줘서 남겨둠.
		} finally { //close는 finally에서 닫음.
			try {
				in.close(); // FIS 닫음.
				out.close(); // FOS 닫음.
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} // close 는 별개의 공간이기 때문에 try-catch를 별도로 작성.
		// 에러가 read 또는 객체 생성에서 발생했을때 cloes가 try안에 있을 경우 실행이 안되니까 무조건 실행하는 finally에 작성.
		
	}

}

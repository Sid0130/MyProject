package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain06 {

	
	public static void main(String[] args) {
		// Student 타입 객체 100만개를 저장하는 ArrayList더미 데이터를 생성.
		// 더미 데이터를 파일에 쓰면써 경과 시간을 측정.
		// 파일에서 데이터를 읽고, 경과 시간을 측정. 데이터 확인.
		
		final String fileName = "data/student.dat";
		
		Random random = new Random();
		ArrayList<Student> students = new ArrayList<>(); // 직렬화를 하려면 모든 클래스 타입에 직렬화를 해줘야 파일을 쓸 수 있다. 기본타입은 괜찮
		for(int i = 0; i < 1_000_000; i++) {
			int korean = random.nextInt(101);
			int english = random.nextInt(101);
			int math = random.nextInt(101);
			Score scores = new Score(korean, english, math);
			Student student = new Student(i, "학생" + i , scores);
			students.add(student);
		}
		System.out.println(students.size());
		System.out.println("frist: " + students.getFirst());
		System.out.println("last: " + students.getLast());
		int index = random.nextInt(1_000_000);
		System.out.println("[" + index + "]" + students.get(index));
		
		try(
				FileOutputStream out = new FileOutputStream(fileName);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				ObjectOutputStream oss = new ObjectOutputStream(bos); 
				
		){
			long start = System.currentTimeMillis();
			
			oss.writeObject(students);
			
			long end = System.currentTimeMillis();
			
			System.out.println("파일 쓰기 경과 시간 " + (end-start) + "ms");
				
				
		} catch(Exception e) { 
			e.printStackTrace();
		}
		
		try( // 리소스 생성 -> 자동으로 close() 메서드가 호출.
				FileInputStream in = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(in);
				ObjectInputStream ois = new ObjectInputStream(bis);	
				//int x = 1; 제약 
		){
			long start = System.currentTimeMillis();
			
			ArrayList<Student> result = (ArrayList<Student>) ois.readObject();
			
			long end = System.currentTimeMillis();
			System.out.println("파일 읽기 경과 시간: " + (end-start)+ "ms");
			
			System.out.println("first: " + result.getFirst());
			System.out.println("last: " + result.getLast());
			System.out.println("[" + index + "]" + result.get(index));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}

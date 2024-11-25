package com.itwill.inner02;

public class InnerMain02 {

	public static void main(String[] args) {
		// Book 타입 변수 선언, 초기화.
		Book book1 = new Book("일론 머스크", "월터 아이작슨", "21세기북스"); 
		System.out.println(book1);
		//1 파라미터들의 모든 조합을 나타낼 수 있는 생성자 모든 조합을 오버로딩할 수 없다
		//2 아규먼트가 여러개인 생성자를 만들었을때 각각 무슨역할을 하는건지 문서를 보기 전에는 알 수 없다.
		// -> 그래서 빌더 디자인 패턴
		
		// BookBuilder를 사용한 Book 타입 객체 생성:
		Book book2 = Book.builder()
				.title("일론 머스크")
				.author("월터 아이작슨")
				.publisher("21세기북스")
				.build();
		System.out.println(book2);
		Book book3 = new Book(null, "한강", null); // 아규먼트 순서와 생성자를 찾아서 필요없는 값들을 null로 채워야하는 단점
		System.out.println(book3);
		
		Book book4 = Book.builder().author("한강").build(); // 코드가 길어진다는 단점은 있지만 원하는 변수를, 메서드를 제어할 수 있는 장점 
		System.out.println(book4);
		//(1) BookBuider 각각 변수에 null 
		//(2) author 변수를 호출하면 값이 입력 
		//(3) build 메서드를 부르면 Book을 생성하고 BookBuider에 있는 값을 리턴 받는다.
	}
}
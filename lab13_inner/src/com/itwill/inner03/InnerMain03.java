package com.itwill.inner03;

import com.itwill.inner03.Button.OnClickListener;

public class InnerMain03 {

	public static void main(String[] args) {
		//Button 타입 객체 생성
		Button btnFinish = new Button("종료");
		
		// OnClickListener를 구현하는 FinishButtonListener 타입 객체 생성.
		OnClickListener listener = new FinishButtonListener(); // 다형성
		// 생성된 Button 타입 객체의 setter 호출: 리스너 객체를 세팅
		// 리스너 객체의 역할: 버튼이 클릭됐을 때 할 일을 정의/.
		btnFinish.setOnClickListener(listener);
		
		// 종료 버튼을 클릭
		btnFinish.click();
		//Finish 클래스가 여러곳에 필요하면 새로 클래스를 만들고 메서드를 만드는게 맞는데 
		//btn 에 만 사용이되면 클래스선언을 메서드에서 하면되지 않을까. 
		
		//--- 지역 클래스(local class)를 사용한 버튼 객체 생성과 리스너 설정:
		// Button 객체 생성, 생성자 호출 -> this.name이 Add
		Button btnAdd = new Button("Add");  
		
		
		// 지역 클래스 선언(정의) (객체 생성x)
		class AddButtonListener implements OnClickListener { // 지역 클래스
			@Override
			public void onClick() {
				System.out.println("파일 추가.");
			} 
		} 
		
		
		// 지역 클래스 타입(OnClickListener) 객체 생성
//		OnClickListener addBtnListener = new AddButtonListener(); (1)
		
		// btnAdd버튼에 OnClickListener 설정 - 버튼이 클릭됐을 때 할 일(기능)을 설정.
//		btnAdd.setOnClickListener(addBtnListener); (2)
		btnAdd.setOnClickListener(new AddButtonListener()); // (1),(2)을 한줄로 쓴 
		btnAdd.click();
		
		
		//--- 익명 클래스를 사용한 버튼 객체 생성, 리스너 설정.
		//Button 타입 객체 생성
		Button btnBrowse = new Button("Browse");
		
		// 익명 클래스 선언과 객체 생성
		OnClickListener browseBtnListener = new OnClickListener() { 
			// 이런 클래스타입의 객체를 생성
			// 불러줄 이름은 수퍼 클래스
			@Override
			public void onClick() {
				System.out.println("파일 검색.");
			}
		};
		
		// btnBrowse 버튼에 리스너 설정.
		btnBrowse.setOnClickListener(browseBtnListener);
		btnBrowse.click();
		
		//--- 익명 클래스 사용:
		//Button 타입 객체 생성
		Button btnCancel = new Button("취소");
		
		//btnCancel의 리스너를 설정 - btnCancel이 할 일(기능)을 설정.
		btnCancel.setOnClickListener(new OnClickListener() {	
			// 버튼이 해야할 일을 세팅. 
			//아규먼트 자리에 클래스 생성과 메서드 오버라이딩.
			@Override
			public void onClick() {
				System.out.println("취소하고 창 닫기.");
			}
		}); 
		
		// btnCancel 버튼을 클릭.
		btnCancel.click();
		
	}
	

}

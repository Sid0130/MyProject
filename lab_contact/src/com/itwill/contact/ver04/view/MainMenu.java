package com.itwill.contact.ver04.view;

public enum MainMenu {

	QUIT,
	CREATE,
	READ_ALL,
	READ_BY_INDEX,
	UPDATA,
	DELETE,
	UNKNOWN;
	
	public static MainMenu getMainMenu(int index) {
		MainMenu[] menu = values();
		
		return (index >=0) && (index< menu.length) ? menu[index]:UNKNOWN;
	}
}

// 생성자에서 이니셜ㄹ라이저

// 파일이 존재하면 한번 불러오고 리스트에 저장
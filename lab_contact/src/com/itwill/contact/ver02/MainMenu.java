package com.itwill.contact.ver02;

//ContactMain (UI)의 switch-case 구문에서 사용할 상수들을 선언.
public enum MainMenu  {
	QUIT,
	CREATE,
	READ_ALL,
	READ_BY_INDEX,
	UPDATE,
	DELETE,
	UNKNOWN;
	
	
	public static MainMenu getMainMenu(int n) { 
		MainMenu[] menu = values(); 
		int size = menu.length;
		
		return (n >= 0 && n < size) ? menu[n] : UNKNOWN;
	}
	
}

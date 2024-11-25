package com.itwill.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class AppMain01 {

	private JFrame frame;
	private JLabel lblTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// JRE에 의해서 실행될 쓰레드를 등록함.
		// invokeLater 메서드의 아규먼트 Runnable - 쓰레드가 할 일(task)
		EventQueue.invokeLater(new Runnable() { // 나중에 실행할 쓰레드를 이벤트에 등록하겠다.
			@Override
			public void run() {	// 등록하고 스케쥴링하고 시간이 남을 때 스케쥴표를 만드대로 쓰레드를 실행 해주는게 바디안에 있는 것.
				try { //
					AppMain01 window = new AppMain01(); // AppMain01 타입 객체를 생성.
					window.frame.setVisible(true); // JFrame 객체를 화면에 보여줌. 창을 띄워주는것
				} catch (Exception e) {
					e.printStackTrace();
				} // 쓰레드가 하는일은 클래스 객체를 생성하고 그 클래스가 가지고 있는 필드와 메서드를 호출. 끝.
			}
		});
	}

	/**
	 * Create the application. 생성자.
	 */
	public AppMain01() { //생성자는 initialize가 끝나면 끝.
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //JFrame 객체 생성.
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JFrame의 시작 좌표(x, y)와 크기(width, height)를 설정. 시작 지점은 좌측 상단.
		frame.setBounds(400, 400, 533, 400);
		
		
		// JLabel 타입 객체 생성
		lblTitle = new JLabel("안녕하세요, Swing!");
		lblTitle.setToolTipText("Text입니다.");
		lblTitle.setForeground(new Color(204, 0, 255));

		// 레이블 문자열의 정렬 위치 - 가운데로 설정.
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		// 레이블의 폰트 설정 
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 50));
		
		//***
		// JFrame의 컨텐트 패널에 레이블을 추가. - 레이블이 보이게 됨.
		frame.getContentPane().add(lblTitle, BorderLayout.CENTER);
		
	
	}

}

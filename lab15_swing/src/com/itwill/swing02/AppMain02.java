package com.itwill.swing02;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AppMain02 {

	private JFrame frame;
	private JLabel lblTitle;
	private JTextField textField;
	private JButton btnInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컨텐트 패널의 기본 레이아웃은 BorderLayout.
		// -> 컨텐트 패널의 레이아웃을 absolute 레이아웃으로 변경.
		frame.getContentPane().setLayout(null); // absolute 레이아웃 설정
		
		lblTitle = new JLabel("* 텍스트를 입력하세요 *");
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 50));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(43, 51, 600, 100);
		frame.getContentPane().add(lblTitle);
		
		textField = new JTextField();
		textField.setFont(new Font("D2Coding", Font.PLAIN, 30));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(50, 178, 582, 210);
		frame.getContentPane().add(textField);
		textField.setColumns(10); // 중요하진 않음.
		
		btnInput = new JButton("저장");
		
		// 버튼의 이벤트 리스너(핸들러)를 설정(등록) -  버튼 기능을 작성.
		btnInput.addActionListener(new ActionListener() { // 익명 클래스
			@Override
			public void actionPerformed(ActionEvent e) { // 이벤트를 처리하는 객체 이벤트 핸들러. 이벤트 리스너 이벤트가 일어날 때까지 듣고있다
				// 내부 클래스는 바깥 클래스의 멤버(필드, 메서드)를 사용할 수 있음.
				handleBtnInputClick();
				
				// 발생하면 처리하는 일을 해주는것.  핸들러 리스너 같은 개념.
				// 버튼이 할 일을 작성
				// textField에 입력된 내용 읽기 -> lblTitle에 입력된 내용 쓰기 -> textField 지움.
				
//				String text = textField.getText();
//				lblTitle.setText(text);
//				textField.setText(""); // 익명!! 내부클래스는 바깥쪽 외부 클래스의 메서드들을 사용할 수 있다.!!!		
			}
		});
//		btnInput.addActionListener(e -> handleBtnInputClick()); 
		//람다 표현식이 익명 클래스를 구현하는 상황에서 사용하는거니까... 줄여쓰는게 가능한거
		
		
		
		btnInput.setFont(new Font("D2Coding", Font.BOLD, 23));
		btnInput.setBounds(190, 435, 300, 80);
		frame.getContentPane().add(btnInput);
	}
	
	// btnInput 버튼을 클릭했을 때 할 일(기능)을 작성:
	private void handleBtnInputClick() {
		// 1. textField에 입력된 내용을 읽어 옴.
		String text = textField.getText();
		
		// 2. 입력 내용을 lblTitle에 씀.
		lblTitle.setText(text);
		
		// 3. textField에 입력된 내용을 지움.
		textField.setText(""); // 덮어씌우면 지워짐.
	}
}

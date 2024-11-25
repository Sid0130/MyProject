package com.itwill.swing08;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// JFrame의 부모 컴포넌트를 저장하기 위해서.
	private Component parentComponent;
	
	// AppMain08 객체의 참조값을 저장하기 위해서.
	private AppMain08 app;

	private JLabel lblTitle;
	private JTextField textField;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void showMyFrame(Component parentComponent, AppMain08 app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame(parentComponent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. 생성자.
	 */
	public MyFrame(Component parentComponent, AppMain08 app) { // 필드 초기화!!
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}

	public void initialize() { // 메서드
		// JFrame 기본 닫기 버튼의 동작을 설정.
		// - EXIT_ON_CLOSE: 전체 프로세스를 (프로그램) 종료.
		// - DISPOSE_ON_CLOSE: 현재 창(JFrame)만 닫고(종료하고) 메인 프로세스는 계속 진행.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// JFrame의 좌표(x,y)와 크기(width, height) 설정.
		int x = 100;
		int y = 100;
		if (parentComponent != null) {
			x = parentComponent.getX(); // 부모 컴포넌트의 x 좌표
			y = parentComponent.getY();// 부모 컴포넌트의 y 좌표
		}
		setBounds(x, y, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// JPanel 객체를 컨텐트 페인으로 설정.
		setContentPane(contentPane);

		// 컨텐트 페인의 레이아웃을 absolute layout으로 설정.
		contentPane.setLayout(null);

		lblTitle = new JLabel("입력하세요");
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblTitle.setBounds(12, 10, 410, 61);
		contentPane.add(lblTitle);

		textField = new JTextField();
		textField.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textField.setBounds(12, 79, 410, 71);
		contentPane.add(textField);
		textField.setColumns(10);

		btnSave = new JButton("저장");

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// AppMain08 클래스의 saveInputMessage() 메서드 호출
//				AppMain08 app = new AppMain08() // 또다른 객체를 만들어서 정보를 주는것이기 때문에 새로 만들면 안됨.

				// 텍스트 필드에 입력된 문자열을 읽음.
				String msg = textField.getText(); 
				// 메세지는 MyFrame이 가지고 있고 그것을 메인에 전달하기 위해 변수에 담아서
				// AppMain08 클래스의 saveInputMessage() 호출 -> 입력값을 AppMain08에게 전달.
				app.saveInputMessage(msg);
				
				// 현재 창 닫기
				dispose();
				
			}
		});

		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btnSave.setBounds(12, 160, 410, 71);
		contentPane.add(btnSave);
	}
}

// 메인 frame 이 정보를 전달하고 싶으면 MyFrame 클래스의 메서드를 호출해서 아규먼트를 넘기면 되고
// 반대로 MyFrame 클래스에서 메인에 정보를 전달하고 싶으면 메인의 메서드를 호출해서 값을 넘기면 됨.
// 메서드를 호출할때 this 라는 정보에는 주소값이 있기 때문에 필드에 넣으면 메인의 주소값을 받을 수 있음.


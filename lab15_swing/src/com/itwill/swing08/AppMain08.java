package com.itwill.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnInputDlg;
	private JButton btnCoustomDlg;
	private JButton btnCoustomFrame;
	
	
	public void saveInputMessage(String msg) {
		btnCoustomFrame.setText(msg);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain08 window = new AppMain08();
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
	public AppMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog"); // 버튼에 쓰여지는 텍스트
		btnMsgDlg.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메세지 다이얼로그 보여주기:
//				JOptionPane.showMessageDialog(btnMsgDlg, "안녕하세요~"); //
				//JOptionPane.showMessageDialog( 1 , 2 ) 1번은 부모 컴포넌트 역활은 메세지 다이얼로그를 어디의 한가운데 뜰건지
				//지정하지 않으면 모니터의 한가운데 뜬다.
				
				JOptionPane.showMessageDialog(
						frame, 					  // 부모 컴포넌트 - 메세지 다이얼로그가 보여지는 위치가 결정.
						"안녕하세요, swing!",     // 다이얼로그에서 보여 줄 메세지. 
						"메시지", 				  // 다이얼로그의 타이틀(제목줄). 
						JOptionPane.WARNING_MESSAGE // 메세지 타입. - int 타입이지만 메세지 타입을 쓸 수 있다. 상수
						);
				
			}
		});
		
		btnMsgDlg.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnMsgDlg.setBounds(12, 10, 414, 57);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Confirm(확인) 다이얼로그 보여주기:
//				int result = JOptionPane.showConfirmDialog(frame, "정말 삭제?"); 
				int result = JOptionPane.showConfirmDialog(
						frame, // 부모 컴포넌트 
						"정말 삭제할까요?", // 메세지 - 어떤 타입도 올 수 있는 Object
						"삭제 확인", // 타이틀 
						JOptionPane.YES_NO_OPTION, // 옵션 타입(확인 버튼 종류, 개수)
						JOptionPane.QUESTION_MESSAGE // 메세지 타입.(메세지 옆의 아이콘 설정)
						);
				btnConfirmDlg.setText("confirm dlglog result = " + result); // 확인하기 위한 창
			}
		});
		btnConfirmDlg.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnConfirmDlg.setBounds(12, 77, 414, 57);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력(Input) 다이얼로그 보여주기:
				// String result = JOptionPane.showInputDialog("검색어");
				
				
				final String[] selectionValues = { "인*", "너튜브", "X" };
				Object result = JOptionPane.showInputDialog(
						frame, //부모 컴포넌트
						"검색어 입력", //메세지
						"검색", //타이틀
						JOptionPane.QUESTION_MESSAGE, // 메세지 타입
						null, // 아이콘 
						selectionValues, // 선택 값들의 배열 - 콤보박스가 만들어짐.
						selectionValues[1] // 초기 선택 값 - 인덱스.
				);
				// selectionValues가 null인 경우에는 입력 다이얼로그에 텍스트 필드가 보임.
				// selectionVakues가 배열인 경우에는 콤보박스가 보임.
				btnInputDlg.setText("input dialog result = " + result);
			}
		});
		
		btnInputDlg.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnInputDlg.setBounds(12, 144, 414, 57);
		frame.getContentPane().add(btnInputDlg);
		
		btnCoustomDlg = new JButton("Custom Dialog");
		btnCoustomDlg.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDialog.showMyDialog(frame); 
				
			}
		});
		
		btnCoustomDlg.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnCoustomDlg.setBounds(12, 211, 414, 57);
		frame.getContentPane().add(btnCoustomDlg);
		
		btnCoustomFrame = new JButton("Custom Frame");
		btnCoustomFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyFrame.showMyFrame(frame, AppMain08.this); // 생성된 appMain의 주소값을 준 것.
			}  //여기는 스태틱 메서드
		});
		btnCoustomFrame.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnCoustomFrame.setBounds(12, 278, 414, 57);
		frame.getContentPane().add(btnCoustomFrame);
	}

}

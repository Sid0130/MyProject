package com.itwill.swing08;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel; // = new JPanel(); // 선언과 동시에 객체 
	private JPanel buttonPanel;
	private JButton cancelButton;
	private JButton okButton;
	
	// MyDialog의 부모 컴포넌트를 저장하기 위해서.
	private Component parentComponent;
	// 객체를 생성할때 필드 변수를 초기화 하기 위해서 생성자한테 프레임에가 주고 생성자는 필드에 할당. 
	// 다른 메서드에서 저장된 필드를 사용. // JOptionPane.showInputDialog 를 참고...

	/**
	 * Launch the application.
	 */
	public static void showMyDialog(Component parentComponent) { // 창을 띄우는데 부모 컴포넌트 기준으로 다이얼로그를 띄움.
		try {														// 
			MyDialog dialog = new MyDialog(parentComponent); // 초기화 선언 하려면 생성자가 있어야함. 
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MyDialog(Component parentComponent) {
		this.parentComponent = parentComponent; // 생성자 호출할때 부모컴포넌트가 저장이되어서 이용이 될 수 있음.
		initialize();
	}
	
	
	public void initialize() { // 자기 클래스, 부모 클래스가 가지고 있는 메서드를 그냥 호출 할 수 있음.
		
		// 다이얼로그의 기본 닫기 버튼(x)의 동작을 설정:
		// DISPOSE_ON_CLOSE: 현재 다이얼로그만 닫고(종료), 메인 프로세스는 계속 실행.
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // 부모가 가지고있는 메서드 호출
		
		// 다디얼로그가 보여지는 좌표(x, y)와 다이얼로그의 크기(width, height)를 설정:
		setBounds(100, 100, 450, 300);
		
		if(parentComponent != null) {
			setLocationRelativeTo(parentComponent); 
			// -> setBounds 메서드에서 설정한 x, y 좌표를 무시하고, 
			// 부모 컴포넌트에 상대적으로(부모의 가운데 위치에) 다이얼로그를 배치.
		}
			
		
		// 컨텍트 페인의 레이아웃 설정
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // 필드에서 객체가 생성되있음.
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		// 컨텐트 패널의 레이아웃 absolute layout을 설정.
		contentPanel.setLayout(null);

		// ctrl + shift + F : 코드 들여쓰기 자동 맞춤
		buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		okButton = new JButton("OK");
		buttonPanel.add(okButton); // 계층구조로 버튼패널에 ok 버튼 넣고
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPanel.add(cancelButton);  // 계층구조로 버튼패널에 cancel 버튼 넣고
		
		// 다른 컴포넌트를 포함할 수 있는 것들을 Containers. 
		// 자식 컴포넌트를 가지실 수 있는 패인,패널

	}
}

package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox; // 여러가지 원소타입을 가지고 있는게 콤보박스 . 
	private JButton btnInfo;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPrivate = new JRadioButton("private");
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);				
			}
		});
		rbPrivate.setSelected(true);
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 15));
		rbPrivate.setBounds(34, 19, 104, 48);
		frame.getContentPane().add(rbPrivate);
		
		rbPackage = new JRadioButton("package");
		rbPackage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 15));
		rbPackage.setBounds(151, 19, 104, 48);
		frame.getContentPane().add(rbPackage);
		
		rbPublic = new JRadioButton("public");
		rbPublic.addActionListener(this::handleRadioButtonClick); // 메서드 참조를 사용한 람다 표현식.
		buttonGroup.add(rbPublic);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 15));
		rbPublic.setBounds(376, 19, 104, 48);
		frame.getContentPane().add(rbPublic);
		
		
		rbProtected = new JRadioButton("protected");
		rbProtected.addActionListener(e -> handleRadioButtonClick(e)); // 람다 표현식.
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 15));
		rbProtected.setBounds(259, 19, 104, 48);
		frame.getContentPane().add(rbProtected);
		
		// 체크박스
		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckButtonClick(e);
			}
		});
		cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 15));
		cbAbstract.setBounds(34, 69, 104, 48);
		frame.getContentPane().add(cbAbstract);
		
		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener(e -> handleCheckButtonClick(e));
		cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 15));
		cbFinal.setBounds(151, 69, 104, 48);
		frame.getContentPane().add(cbFinal);
		
		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(this::handleCheckButtonClick);
		cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 15));
		cbStatic.setBounds(259, 69, 104, 48);
		frame.getContentPane().add(cbStatic);
		
		comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleComboBoxChange(e);
			}
		});
		
		
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		//****
		final String[] items = {"naver.com", "kakao.com", "gmail.com", "yahoo.com"};
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items); // element타입
		
		comboBox.setModel(model);
		comboBox.setBounds(34, 123, 221, 23);
		frame.getContentPane().add(comboBox); // 프레임에 넣었다.add
		
		btnInfo = new JButton("확인");
		btnInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handleInfoButtonClick();
			}
		});
		btnInfo.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btnInfo.setBounds(259, 123, 104, 23);
		frame.getContentPane().add(btnInfo);
		
		scrollPane = new JScrollPane(); // 기본 생성자.
		scrollPane.setBounds(34, 168, 423, 147);
		frame.getContentPane().add(scrollPane); 
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 15));
		scrollPane.setViewportView(textArea); // <- 스크롤페인의 setViewportView 메서드에 textArea를 넣은 것! 
	} // 스크롤 패인 먼저넣고 그다음 에이리어를 넣어야 함.
	
	
	private void handleInfoButtonClick() {
		// JTextArea에 출력할 문자열들을 붙여 나갈 버퍼
		StringBuffer buf = new StringBuffer();
		
		// 어떤 라디오버튼이 선택됐는 지 체크
		// 라디오 버튼은 하나가 체크하면 다른것은 체크못해서 if-else if로 해준다.
		if(rbPrivate.isSelected()) {
			buf.append(rbPrivate.getText());
			
		} else if(rbPackage.isSelected()) {
			buf.append(rbPackage.getText());
			
		} else if(rbProtected.isSelected()) {
			buf.append(rbProtected.getText());
		} else {
			buf.append(rbPublic.getText());
		}
		buf.append("라디오 버튼 선택됨.\n");
		
		// 어떤 체크박스들이 선택됐는 지 체크.
		// 중복체크가 가능해서 if를 각각 해줘야함.
		if(cbAbstract.isSelected()) { 
			buf.append(cbAbstract.getText()).append(" ");
		} 
		if(cbFinal.isSelected()) {
			buf.append(cbFinal.getText()).append(" ");
		}
		if(cbStatic.isSelected()) {
			buf.append(cbStatic.getText()).append(" ");
		}
		buf.append("체크박스가 선택됨.\n");
		
		
		Object item = comboBox.getSelectedItem();
		buf.append(item).append("콤보박스 아이템 선택됨.");
		
		textArea.setText(buf.toString());
	}

	private void handleComboBoxChange(ActionEvent e) {
		int index = comboBox.getSelectedIndex();
		Object item = comboBox.getSelectedItem(); // 다형성 리턴타입의 모든타입의 모든 메서드들을 호출할 수 있다.
		textArea.setText("콤보박스 인덱스 = " + index + ", 콤보박스 아이템 = " + item);
	}

	private void handleCheckButtonClick(ActionEvent e) {
//		String text = e.getActionCommand();
		
		
		JCheckBox cb = (JCheckBox)e.getSource();
		String text = cb.getText();
		boolean selected = cb.isSelected();
		textArea.setText(text + " - " + selected);
	}

	
	
	// getsorce는 javax가 이벤트가 발생한 위치를 표현
	private void handleRadioButtonClick(ActionEvent e) {
		// 4개의 라디오버튼들 중에서 누가 클릭 됐는 지 확인:
//		textArea.setText(e.toString()); // 4곳 전부 발생위치정보 확인
		JRadioButton btn = (JRadioButton)e.getSource(); // 이벤트가 발생한 GUI 컴포넌트
		
		// get이나 isSele 메서드는 obj가 갖고있지 않아서 캐스팅해서 찾아야함.  
		// <- obj 타입이라는걸 아니까 casting해버린다.
		String text = btn.getText(); // 라디오 버튼의 텍스트
		boolean selected = btn.isSelected(); // 이게 라디오가 선택됬는지 안됬는지 까지 알고 싶으면 casting해야함. 	
		//기본적으로 커맨드로 다 찾아서 가능함.
		
		textArea.setText(text + " - " + selected);		
	
		
	}
	// 첫번째 콤보는 서울, 경기, 부산
	// 두번째는 모델이 없는 상태로. 
	// 첫번째가 선택(이벤트핸들러) 각각 두번째 모델이 채워지면 되는것 
	
	// 확인 (이벤트핸들러) = 1 + 2 선택된것을 TextFiled에 출력해주면됨.
	
}

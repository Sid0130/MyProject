package com.itwill.contact.ver05.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.contact.ver05.controller.ContactDao;
import com.itwill.contact.ver05.model.Contact;

public class ContactCreateFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JTextField textName;
	private JLabel lblName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblEmail;
	private JButton btnCancel;
	private JLabel lblPhone;
	private JButton btnSave;
	
	private ContactMain05 mainApp;
	private ContactDao dao;
	private Component parentComponent;

	/**
	 * Launch the application.
	 */
	public static void showContactCreateFrame(Component parentComponent, ContactMain05 mainApp) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parentComponent,mainApp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private ContactCreateFrame(Component parentComponent, ContactMain05 mainApp) {
		this.dao = ContactDao.INSTANCE;
		this.parentComponent = parentComponent;
		this.mainApp = mainApp;
		
		initialize();
	}
	
	private void initialize() {
		setTitle("새 연락처 추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if(parentComponent != null) {
			x = parentComponent.getX() + parentComponent.getWidth();
			y = parentComponent.getY();
		}
		setBounds(x, y, 450, 300); //부모 좌표에 넣는것
		
		if(parentComponent == null) {
			setLocationRelativeTo(null); //화면의 한가운데에 JFrame을 보여줌.  상대적인 위치가 없으면 중앙에 보이게 한다. 
		}	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblName.setBounds(12, 10, 115, 44);
		mainPanel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textName.setBounds(140, 10, 272, 44);
		mainPanel.add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textPhone.setColumns(10);
		textPhone.setBounds(140, 64, 272, 44);
		mainPanel.add(textPhone);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblPhone.setBounds(12, 64, 115, 44);
		mainPanel.add(lblPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(140, 118, 272, 44);
		mainPanel.add(textEmail);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblEmail.setBounds(12, 118, 115, 44);
		mainPanel.add(lblEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("저장");
		
		btnSave.addActionListener(e -> createNewContact());
		
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 15));
		buttonPanel.add(btnSave);
		
		btnCancel = new JButton("취소");
		
		btnCancel.addActionListener(e -> dispose());
		
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 15));
		buttonPanel.add(btnCancel);
	}
	
	private void createNewContact() {
		// JTextField에서 이름, 전화번호, 이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// Contact 타입 객체 생성.
		Contact contact = new Contact(null, name, phone, email);
		
		
		// DAO 메서드를 호출해서 파일에 저장.
		int result = dao.create(contact);
		if(result == 1) { // 주소를 알아야 
			// 연락처 메인 프레임에게 연락처 추가 성공을 알려줌.
			mainApp.notifyContactCreated(); 
			// 메세지 다이얼로그가 뜨는데 그 창을 닫아줘야 그다음 dispose..
			
			
			// 현재 창(연락처 추가 창)을 닫음. 
			dispose(); // 창이 닫히는것은 메서드가 완전히 끝나면 닫힘
		} else {
			// TODO
			
		}
		
		
	}
}

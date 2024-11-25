package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class AppMain04 {

	private JFrame frame;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldEamil;
	private JButton btnInput;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 823, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setOpaque(true);
		lblName.setAutoscrolls(true);
		lblName.setForeground(SystemColor.text);
		lblName.setBackground(SystemColor.activeCaption);
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 30));
		lblName.setBounds(98, 99, 137, 66);
		frame.getContentPane().add(lblName);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setBackground(SystemColor.activeCaption);
		lblPhone.setOpaque(true);
		lblPhone.setForeground(SystemColor.text);
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 30));
		lblPhone.setBounds(98, 190, 137, 66);
		frame.getContentPane().add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setOpaque(true);
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setBackground(SystemColor.activeCaption);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 30));
		lblEmail.setBounds(98, 282, 137, 66);
		frame.getContentPane().add(lblEmail);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(260, 95, 286, 70);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(260, 190, 286, 66);
		frame.getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldEamil = new JTextField();
		textFieldEamil.setBounds(260, 282, 286, 66);
		frame.getContentPane().add(textFieldEamil);
		textFieldEamil.setColumns(10);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInputEmail();
			}
		});
		btnInput.setBackground(new Color(192, 192, 192));
		btnInput.setBounds(589, 282, 142, 66);
		frame.getContentPane().add(btnInput);
		
		textArea = new JTextArea();
		textArea.setBounds(97, 392, 634, 117);
		frame.getContentPane().add(textArea);
	}

	

	protected void btnInputEmail() {
		// 텍스트 필드의 내용을 읽어들인다.
		String name = textFieldName.getText();
		
		String phone = textFieldPhone.getText();
		
		String email = textFieldEamil.getText();
			
		StringBuffer buf = new StringBuffer(); //**** 덧붙히고 덧붙히고
		buf.append("이름 : ").append(name).append("\n")
			.append("전화번호: ").append(phone).append("\n")
			.append("이메일: ").append(email).append("\n");
		// textArea에 내용을 씀.
//		textArea.setText(buf); // 상속관관계가 아니라서 안됨
		
		textArea.setText(buf.toString());
		
		
		// 모든 텍스트 필드의 입력 내용을 지움.
		textFieldName.setText("");
		textFieldPhone.setText("");
		textFieldEamil.setText("");	
	}


}

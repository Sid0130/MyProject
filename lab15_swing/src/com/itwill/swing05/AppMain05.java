package com.itwill.swing05;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AppMain05 {

	private JFrame frame;
	private JLabel lblNum1;
	private JLabel lblNum2;
	private JButton btnPlus;
	private JButton btnMin;
	private JButton btnMulti;
	private JButton btnDiv;
	private JTextArea textResult;
	private JTextField textField2;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 371, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNum1 = new JLabel("num1");
		lblNum1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNum1.setOpaque(true);
		lblNum1.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum1.setBounds(23, 28, 98, 40);
		frame.getContentPane().add(lblNum1);
		
		lblNum2 = new JLabel("num2");
		lblNum2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNum2.setOpaque(true);
		lblNum2.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum2.setBounds(23, 91, 98, 40);
		frame.getContentPane().add(lblNum2);
		
		textField1 = new JTextField();
		textField1.setBackground(SystemColor.inactiveCaptionBorder);
		textField1.setBounds(133, 30, 204, 40);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBackground(SystemColor.inactiveCaptionBorder);
		textField2.setBounds(133, 93, 204, 40);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		btnPlus = new JButton("+");
		btnPlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPlus.setBackground(SystemColor.control);
		btnPlus.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { //액션 이벤트를 전달, 
				handleButtonClick(e);
				
			}
		});
		
		btnPlus.setBounds(23, 163, 66, 51);
		frame.getContentPane().add(btnPlus);
		
		btnMin = new JButton("-");
		btnMin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				handleButtonClick(e);
			}
		});
		btnMin.setBackground(SystemColor.control);
		btnMin.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnMin.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnMin.setBounds(108, 163, 66, 51);
		frame.getContentPane().add(btnMin);
		
		btnMulti = new JButton("X");
		btnMulti.addActionListener(e -> handleButtonClick(e)); // 이벤트를 전달받으면 핸들클릭 메서드에 전달하고 핸들버튼클릭을 메서드를 호출.
		btnMulti.setBackground(SystemColor.control);
		btnMulti.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnMulti.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btnMulti.setBounds(192, 163, 66, 51);
		frame.getContentPane().add(btnMulti);
		
		btnDiv = new JButton("/");
		btnDiv.addActionListener(this::handleButtonClick); // this의는 initialize 메서드의 메인이 갖고있으니 this는 자기 타입의 생성된 객체.
		// initialize 메서드안에 있고 가지고있는 main 클래스 객체를   호출하려는 메서드의  this가 갖고있는 핸들버튼클릭
		
		btnDiv.setBackground(SystemColor.control);
		btnDiv.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDiv.setFont(new Font("D2Coding", Font.PLAIN, 20));
		
		btnDiv.setBounds(270, 163, 66, 51);
		frame.getContentPane().add(btnDiv);
		
		textResult = new JTextArea();
		textResult.setBackground(SystemColor.inactiveCaptionBorder);
		textResult.setBounds(23, 236, 313, 116);
		frame.getContentPane().add(textResult);
	}

//	protected void divBtn() {
//		double num1	= Double.parseDouble(textField1.getText());
//		double num2 = Double.parseDouble(textField2.getText());
//		double div = num1 / num2;
//		textArea.setText("" + div);
//		
//		textField1.setText("");
//		textField2.setText("");
//		
//	}

//	protected void multiBtn() {
//		double num1	= Double.parseDouble(textField1.getText());
//		double num2 = Double.parseDouble(textField2.getText());
//		double multi = num1 * num2;
//		textArea.setText("" + multi);
//		
//		textField1.setText("");
//		textField2.setText("");
//	}
//
//	protected void minusBtn() {
//		double num1	= Double.parseDouble(textField1.getText());
//		double num2 = Double.parseDouble(textField2.getText());
//		double minus = num1 - num2;
//		textArea.setText("" + minus);
//		
//		textField1.setText("");
//		textField2.setText("");
//	}
//
//	private void sumBtn() {
//		double num1	= Double.parseDouble(textField1.getText());
//		double num2 = Double.parseDouble(textField2.getText());
//		double sum = num1 + num2;
//		textArea.setText("" + sum);		
//		
//		textField1.setText("");
//		textField2.setText("");
//	}
	
	private void handleButtonClick(ActionEvent e) { //액션 리스너를 만들 때 액션 이벤트라는 객체에서 어떤 정보를 뽑을 수 있을지.
		System.out.println(e);						
		System.out.println("action command = "+ e.getActionCommand());
		System.out.println("event type id = " + e.getID());
		
		Object source = e.getSource();		// 이벤트가 발생한 소스를 찾는 방법
		System.out.println("event Source = " + e.getSource()); //이벤트가 발생한 소스
		if(source instanceof JButton) {
			JButton btn = (JButton) source; 
//			System.out.println(btn == btnPlus); 
			System.out.println(btn.getText()); //그 타입이 가지고 있는 속성들.
			
		} // 이벤트의 액션커맨드나 소스를 비교해서 어떤 버튼인지 찾아내고 그거에 따라 덧셈,뺄셈,곱하기,나누기 기능을 만들고 써주기.
		
		textResult.setText(""); //JTextArea에 이전에 입력된 문자열들을 지움.
		
		// JTextField 2개에 입력된 문자열을 읽어서 숫자로 변환.
		double x = 0;
		double y = 0;
		try {
			x = Double.parseDouble(textField1.getText());
			y = Double.parseDouble(textField2.getText());
			
			
		} catch (NumberFormatException ex) {
			textResult.setText("Number1과 Number2는 반드시 숫자여야 합니다.");
			return; // 메서드 종료
		}
		
		// 버튼 종류에 따라서 사칙연산을 수행.
		double result = 0; // 사칙연산 결과를 저장할 변수.
		String operator = null; // 사칙연산 종류 (문자열) 저장할 변수.
		if(source == btnPlus) {
			result = x+y;
			operator = "+";
		} else if(source == btnMin) {
			result = x-y;
			operator = "-";
		} else if(source == btnMulti) {
			result = x*y;
			operator = "x";
		} else if(source == btnDiv) {
			result = x/y;
			operator = "/";
		}
		
		String msg = String.format("%f %s %f = %f", x, operator, y, result);
		textResult.setText(msg);	
	}
	
	// when 은 시간, on ~에서 javax 버ㄴ튼 클래스에서 이벤트,
}

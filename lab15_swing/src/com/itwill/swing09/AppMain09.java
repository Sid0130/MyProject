package com.itwill.swing09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AppMain09 {
	// 테이블 컬럼 이름
	private static final String[] COLUMN_NAMES = {
			"국어", "영어", "수학", "총점", "평균",
	};
	private JFrame frame;
	private JLabel lblKorean;
	private JTextField textKorean;
	private JLabel lblEnglish;
	private JTextField textEnglish;
	private JLabel lblMath;
	private JTextField textMath;
	private JButton btnSave;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain09 window = new AppMain09();
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
	public AppMain09() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblKorean.setBounds(12, 10, 93, 70);
		frame.getContentPane().add(lblKorean);
		
		textKorean = new JTextField();
		textKorean.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textKorean.setBounds(117, 10, 305, 70);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblEnglish.setBounds(12, 101, 93, 70);
		frame.getContentPane().add(lblEnglish);
		
		textEnglish = new JTextField();
		textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textEnglish.setColumns(10);
		textEnglish.setBounds(117, 101, 305, 70);
		frame.getContentPane().add(textEnglish);
		
		lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.CENTER);
		lblMath.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblMath.setBounds(12, 193, 93, 70);
		frame.getContentPane().add(lblMath);
		
		textMath = new JTextField();
		textMath.setFont(new Font("D2Coding", Font.PLAIN, 20));
		textMath.setColumns(10);
		textMath.setBounds(117, 193, 305, 70);
		frame.getContentPane().add(textMath);
		
		btnSave = new JButton("저장");
		
		btnSave.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				inputScoreToTable(); 
				// 이벤트의 타입을 알아내야 한다면 메서드에 아규먼트를 전달하면 되고 이벤트에 대한 정보가 필요없으면 비우면 된다.
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnSave.setBounds(12, 286, 93, 70);
		frame.getContentPane().add(btnSave);
		
		btnDelete = new JButton("삭제");
	
		btnDelete.addActionListener(e -> deleteScoreFromTable()); // 이벤트가 전달됬을때 메서드를 호출함.
		
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnDelete.setBounds(117, 286, 93, 70);
		frame.getContentPane().add(btnDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 366, 410, 157);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("D2Coding", Font.PLAIN, 15));
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
	}
	private void deleteScoreFromTable() {
		// JTable에서 선택된 행의 인덱스를 찾음.
		int index = table.getSelectedRow();
		if(index == -1) { // 테이블에서 선택된 행이 없을 때
			JOptionPane.showMessageDialog(
					frame, // 부모 컴포넌트
					"삭제할 행을 먼저 선택하세요!", // 메시지
					"경고", // 타이틀
					JOptionPane.WARNING_MESSAGE // 메시지 타입
			);
			return;
		}
//		System.out.println(index);
		
		// 삭제 여부를 사용자에게 확인.
		int confirm = JOptionPane.showConfirmDialog(
				frame, // 부모 컴포넌트
				"정말 삭제합니까?", // 메세지
				"삭제 확인", // 타이틀
				JOptionPane.YES_NO_OPTION // 메세지 옵션 타입
		);
		// 사용자가 YES를 선택했을 때 테이블 모델에서 행을 삭제.
		if(confirm == JOptionPane.YES_OPTION) { // 사용자가 YES를 선택했을때 리턴되는값이 YES_OPTION
			model.removeRow(index); // 행의 인덱스를 삭제
		}
		
		
	}
	
	
	private void inputScoreToTable() {
		// 1. JTextField에 입력된 과목 점수들을 읽음.
		int korean = 0;
		int english = 0;
		int math = 0;
		
		try {
		
			korean = Integer.parseInt(textKorean.getText()); //try 바깥에서 선언해야 korean 변수를 바깥에서도 사용할 수 있기 때문에 안에서 수식을 적어준다
			english = Integer.parseInt(textEnglish.getText()); // get으로 읽어들임.
			math = Integer.parseInt(textMath.getText());
		
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog( // 잘못되는 부분이 있으면 메시지 다이얼로그로 창을 띄워서 표시 해줘야함.
					frame, // 부모 컴포넌트
					"국어, 영어, 수학 점수는 정수로 입력하세요.", //메시지
					"입력 오류", // 타이틀(제목)
					JOptionPane.ERROR_MESSAGE // 메시지 타입.
			);
			return; // 메서드 종료.
		}
		
		// 2. Score 타입 객체 생성.
		Score score = new Score(korean, english, math); 
		
		
		// 3. JTable에 행(row)을 추가.
		Object[] row = {
				score.getKorean(),
				score.getEnglish(),
				score.getMath(),
				score.getTotal(),
				score.getMean(),			
		};
		//행에 추가 해주는 메서드는 model . table model이 행을 추가해주는 메서드를 갖고있음.
		model.addRow(row); // 1차원 배열을 만들고 그것을 add - addRow가 Object 배열 타입.
		
		
		// 4. JTextFile에 입력된 내용들을 지움.
		textKorean.setText("");
		textEnglish.setText("");
		textMath.setText("");
	}
}

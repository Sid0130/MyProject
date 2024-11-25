package com.itwill.contact.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.contact.ver05.controller.ContactDao;
import com.itwill.contact.ver05.model.Contact;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ContactMain05 {
	
	// 테이블 컬럼 이름
	private static final String[] COLUMN_NAMES = { "이름", "전화번호" };
	
	private JFrame frame;
	private JPanel buttonPanel;
	private JButton btnSave;
	private JButton btnSearch;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	
	private ContactDao dao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
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
	public ContactMain05() {
		this.dao = ContactDao.INSTANCE;
		
		initialize();
		
		loadContactData();
	}

	/**
	 * Initialize the contents of the frame. 프레임의 여러가지 컨텐츠들을 초기화.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\itwill\\Downloads\\dw_jpg\\logo.png"));
		frame.setBounds(100, 100, 412, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("연락처 v0.5");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		
		btnSave = new JButton("추가");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactCreateFrame.showContactCreateFrame(
						frame,
						ContactMain05.this
						);
			}
		});
		
		
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 15));
		buttonPanel.add(btnSave);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactSearchFrame.showContactSearchFrame(frame);
			}
		});
		
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 15));
		buttonPanel.add(btnSearch);
		
		btnUpdate = new JButton("수정");
		
		btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btnUpdate.addActionListener(e -> updateContact());		// 주소값이 있어야 넘겨주고 받고함.
		
		buttonPanel.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		
		btnDelete.addActionListener(e -> deleteContact());
		
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 15));
		buttonPanel.add(btnDelete);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		
		table.setModel(model);
		
		
		scrollPane.setViewportView(table);
	}
	
	private void updateContact() {
		// 테이블에서 선택된 행의 인덱스를 찾음.
		int index = table.getSelectedRow();
		
		if(index == -1) {
			JOptionPane.showMessageDialog(
					frame,
					"업데이트할 행을 먼저 선택하세요",
					"수정 확인",
					JOptionPane.WARNING_MESSAGE
					);
			return;
		}
		
		// 선택한 연락처 인덱스를 업데이트 프레임에게 전달하면서 화면에 띄움.
		ContactUpdateFrame.showContactUpdateFrame(frame, ContactMain05.this, index);
		// 그클래스의 메서드를 호출하면서 아규먼트게 값을 주면
		// 클래스에게 주고 클래스는 저장
	}

	private void deleteContact() {
		
		// 테이블에서 선택된 행의 인덱스를 찾음.
		int index = table.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(
					frame,
					"삭제할 행을 먼저 선택하세요?",
					"경고",
					JOptionPane.WARNING_MESSAGE
					);
			return;
		}
		
		// 사용자에게 삭제할 것인 지 확인.
		int confirm = JOptionPane.showConfirmDialog(
				frame,
				"정말 삭제할까요?",
				"삭제 확인",
				JOptionPane.YES_NO_OPTION);
		
		if(confirm == JOptionPane.YES_OPTION) {
			
			// DAO 메서드를 호출해서 연락처를 삭제하고, 파일에 저장.
			int result = dao.delete(index);
			if(result == 1)	{
				
				// 테이블 갱신.
				resetTable();
				JOptionPane.showMessageDialog(frame, "연락처 삭제 성공!");
				
			} else {
			
				// TODO 삭제 실패 메시지 다이얼로그
				JOptionPane.showMessageDialog(frame, "삭제 실패!!");
			}
				
			
		}
		
			
	}
	
	
	private void resetTable() { // 초기화해서 파일 테이블에 보여주는 기능
		model = new DefaultTableModel(null, COLUMN_NAMES); // 모델을 새로 만들어서 set하고 데이터를 새로 가져옴.
		loadContactData();
		table.setModel(model);
		
		// 유지할 수 있는 기능.??
		
	}
	
	
	// ContactCreateFrame에서 새로운 연락처를 파일에 저장한 경우 호출할 메서드. 
	
	public void notifyContactCreated() { // 퍼블릭 공개
		// 테이블을 처음부터 다시 새로 그림.
		resetTable();
		
		// 사용자에게 메시지 다이얼로그를 보여줌.
		JOptionPane.showMessageDialog(frame, "연락처 저장 성공!");
		
	}
	
	// ContactUpdateFrame에서 연락처 업데이트 성공했을 때 호출할 메서드.
	public void notifyContactUpdated() {
		resetTable();
		JOptionPane.showMessageDialog(frame, "연락처 업데이트 성공!");
		
	}
	
	 // 테이블 모델들이 생성 됬을테니까 끝난 다음에 파일을 읽어오겠다 하면 테이블모델과 행을 생성을 하겠다
	// 데이터 엑세서 모델을 이용해서 데이터를 읽어오고 로우 모델을 이용해 에드 로우 파일을 실행 시킬 때 마다 데이터들이 보인다. 
	private void loadContactData() {
		// DAO의 메서드를 호출해서 파일에 저장된 연락처 데이터를 읽어옴.
		List<Contact> list = dao.read();
		
		// 리스트의 연락처(이름, 전화번호)를 테이블 모델에서 행(row)에 추가.
		for(Contact c : list) { // dao에 저장된 데이터를 list에 할당 받아서 for문으로 하나씩 뽑는다.
			 // list에 있는 내용을 이름과 전화번호 내용을 받아서 오브젝트 타입 배열 row 에 담는다.
			// addRow 를 쓰려면 Object[] 타입이여야 하기 때문에 행으로 출력하려면 Object[]에 담아야함.
			Object[] row = { c.getName(), c.getPhone()} ;
			model.addRow(row);
		}
	}

	
	

	

	

}

//보더레이아웃 그대로 해서 널스에 판넬을 배치를 했고 센터에도 스크롤판넬을 넣고 테이블을 넣음.

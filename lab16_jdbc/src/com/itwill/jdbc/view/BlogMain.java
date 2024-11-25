package com.itwill.jdbc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;
import com.itwill.jdbc.view.BlogCreateFrame.CreateNotify;
import com.itwill.jdbc.view.BlogDetailsFrame.UpdateNotify;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;


// MVC 아키텍쳐에서 View를 담당하는 객체.
public class BlogMain implements CreateNotify, UpdateNotify{
	
	
	
	// JComboBox의 아이템 이름들을 상수로 선언.
	private static final String[] SEARCH_TYPE = { // 콤보박스에 쓰려고
			"제목", "내용", "제목+내용", "작성자"
	};
	// JTable의 컬럼 이름들을 상수로 선언.
	private static final String[] COLUMN_NAMES = { // 칼럼에 쓸려고
			"번호", "제목", "작성자", "작성시간"
	};
	// 윈도우 빌더
	private JFrame frame;
	private JPanel searchPanel;
	private JComboBox<String> comboBox;
	private JTextField textSearchKeyword;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JPanel buttonPanel2;
	private JButton btnReadAll;
	private JButton btnCreate;
	private JButton btnDetails;
	private JButton btnDelete;

	// MVC 아키텍쳐에서 Controller 객체
	private BlogDao blogDao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BlogMain window = new BlogMain();
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
	public BlogMain() {
		blogDao = BlogDao.INSTANCE; // 객체 생성ㄴ 필드를 초기화 싱글톤으로. 그러면 블로그다오의 메서드들을 호출가능.
		initialize(); // J프레임,테이블, 판넬 윈도우 화면을 보여주는 것들.
		initializeTable(); // 다오의 메서드를 호출해서
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("블로그 앱 v1.0");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		searchPanel = new JPanel();
		frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
		
		comboBox = new JComboBox<>();
		
		// JComboBox의 아이템 설정.
		final DefaultComboBoxModel<String> comboBoxModel = 
				new DefaultComboBoxModel<>(SEARCH_TYPE); // 생성까지
		comboBox.setModel(comboBoxModel);
		
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 20));
		searchPanel.add(comboBox);
		
		textSearchKeyword = new JTextField();
		textSearchKeyword.setFont(new Font("D2Coding", Font.PLAIN, 20));
		searchPanel.add(textSearchKeyword);
		textSearchKeyword.setColumns(15); // 텍스트필드의 크기
		
		
		btnSearch = new JButton("검색");
		
		btnSearch.addActionListener(e -> searchBlogs());
		
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 20));
		searchPanel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
		
		// JTable의 컬럼 이름 설정.
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		// 테이블의 글자나 크기는 테이블에서. 상단의 글꼴과 크기는 모델에서
		
		buttonPanel2 = new JPanel();
		frame.getContentPane().add(buttonPanel2, BorderLayout.SOUTH);
		
		btnReadAll = new JButton("전체 목록");
		btnReadAll.addActionListener(e -> initializeTable());
		btnReadAll.setFont(new Font("D2Coding", Font.PLAIN, 20));
		buttonPanel2.add(btnReadAll);
		
		btnCreate = new JButton("새 블로그 작성");
		
		btnCreate.addActionListener(e ->  BlogCreateFrame.showBlogCreateFrame(frame, BlogMain.this));
		
		btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		buttonPanel2.add(btnCreate);
		
		btnDetails = new JButton("상세보기");
		
		
		btnDetails.addActionListener(e -> showBlogDetails());
		
		
		btnDetails.setFont(new Font("D2Coding", Font.PLAIN, 20));
		buttonPanel2.add(btnDetails);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(e -> deleteBlog());
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
		buttonPanel2.add(btnDelete);
	}
	
	private void searchBlogs() {
		// 검색 종류(제목, 내용, 제목+내용, 작성자)를 찾음.
		int type = comboBox.getSelectedIndex(); // 숫자가 나오는 메서드.
		
		// 검색어 JTextField 
		String keyword = textSearchKeyword.getText();
		if(keyword.equals("")) {
			JOptionPane.showMessageDialog(
					frame,
					"검색어를 입력하세요.",
					"경고",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		List<Blog> blogs = blogDao.read(type, keyword);
		resetTableModel(blogs);
	}
	
	
	private void showBlogDetails() {
		// JTable에서 선택된 행의 인덱스를 찾음.
		int index = table.getSelectedRow();
		if(index == -1) { // 선택된 행이 없는 경우.
			JOptionPane.showMessageDialog(
					frame,
					"테이블에서 상세보기를 할 행을 먼저 선택하세요.",
					"경고",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// 선택된 행에서 블로그 아이디 값을 찾음.
		Integer id = (Integer)model.getValueAt(index, 0);
		
		// 블로그 상세보기 창을 실행.
		BlogDetailsFrame.showBlogDetailsFrame(frame, BlogMain.this, id);
		// 블로그 메인이 블로그의 아이디를 알고 있기 때문에 디테일프레임 클래스에도 알려줘야함
		
		
	}
	
	
	private void deleteBlog() {
		// JTable에서 선택된 행을 찾고, 선택된 행의 블로그 번호(ID)로 삭제.
		int index = table.getSelectedRow();
		if(index == -1) { // 선택된 행이 없는 경우
			JOptionPane.showMessageDialog(
					frame,
					"테이블에서 삭제할 행을 먼저 선택하세요",
					"경고",
					JOptionPane.WARNING_MESSAGE);			
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(frame,
				"정말 삭제할까요",
				"삭제 확인",
				JOptionPane.
				YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			// TODO: JTable에서 선택된 행의 첫번째 컬럼(번호 - 블로그 아이디) 값을 읽고,
			Integer id = (Integer)model.getValueAt(index, 0); // 셀하나 x번째 행 y번째 열의 컬럼을 리턴
										// 셀의 값을 읽어올때 getValueAt <- table model이 이 메서드를 갖고이씅ㅁ
			
			// DAO 메서드를 호출해서, DB 테이블에서 행을 삭제.
			int result = blogDao.delete(id);
			if(result == 1) { // 1개 행이 삭제됨.
				JOptionPane.showMessageDialog(frame, "삭제 성공");
				
				initializeTable(); // JTable을 새로고침
				
			} else { //삭제 실패
				JOptionPane.showMessageDialog(frame, "삭제 실패");
			}
		}
	}
	
	
	
	
	private void initializeTable() { // 생성자에서 호출됨.
		// 컨트롤러의 메서드를 호출해서 DB에 저장된 데이터를 읽어옴.
		// 메인은 호출하면 데이터를 받을 수 있다의 메인이 하는 일.
		List<Blog> list = blogDao.read(); 
		
		resetTableModel(list);
		
//		model = new DefaultTableModel(null, COLUMN_NAMES);
//		for (Blog b: list) {
//			//J테이블에 들어갈 행들을 하나씩 만드는 역할.
//			Object [] rowData = { 
//					b.getId(), b.getTitle(), b.getAuthor(), b.getCreatedTime()
//					// 각 원소들이 타입들이 다 다르기 때문에 Object[]에 추가.
//					
//			}; //번호 제목 작성자 작성시간.
//			
//			model.addRow(rowData); //각각 행들을 추가해서 
//		}
//		table.setModel(model); // 테이블에 setModel로 화면에 보여주게됨
//		
//		 //다오에게 리스트를 받아서 테이블의 모델을 새로 만들어서 데이터를 비우고 리스트에서 블로그를 꺼내서
//		// 
	}
	
	private void resetTableModel(List<Blog> list) {
		model = new DefaultTableModel(null, COLUMN_NAMES); 
		// 처음 데이터가 생성될때 데이터가 비워져있고
		// 모델 
		for(Blog b : list) {
			Object[] rowData = {
				b.getId(), b.getTitle(), b.getAuthor(), b.getCreatedTime()	
			};
			model.addRow(rowData); // 테이블 모델에 행으로 추가
		}
		table.setModel(model);
	}

	// BlogCreateFrame.CreateNotify 인터페이스 구현(implements)하기 위해서.
	// 새 블로그 작성 성공했을 때(DB 테이블에 insert가 됐을 때), BlogCreateFrame이 호출할 메서드.
	@Override
	public void notifyCreateSuccess() {
		initializeTable(); // 테이블 새로고침.
	}
	// 메인 -> createframe jFrame, main.this ->

	// BlogDetailsFrame.UpdateNotify 인터페이스를 구현하기 위해서.
	// 블로그 제목/내용 업데이트 성공했을 때, BlogDetailsFrame이 호출할 메서드.
	@Override
	public void notifyUpdateSuccess() {
		initializeTable(); // 테이블 새로고침하면 반영이 될거임.
		
	}
}

package com.itwill.contact.ver05.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.contact.ver05.controller.ContactDao;
import com.itwill.contact.ver05.model.Contact;

public class ContactSearchFrame extends JFrame {

	private static final String[] COLUMN_NAMES = { "이름", "전화번호" ,"이메일"};
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private ContactMain05 mainApp;
	private ContactDao dao;
	private Component parentComponent;
	private JTextField textKeyword;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void showContactSearchFrame(Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactSearchFrame frame = new ContactSearchFrame(parentComponent);
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
	private ContactSearchFrame(Component parentComponent) {
		this.dao = ContactDao.INSTANCE;
		this.parentComponent = parentComponent;
		this.mainApp = mainApp;
		
		initialize();
	}
	
	private void initialize() {
		setTitle("연락처 검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if(parentComponent != null) {
			x = parentComponent.getX() + parentComponent.getWidth();
			y = parentComponent.getY();
		}
		setBounds(x, y, 450, 499); 
		
		if(parentComponent == null) {
			setLocationRelativeTo(null);
		}	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textKeyword = new JTextField();
		textKeyword.setBounds(23, 10, 265, 57);
		contentPane.add(textKeyword);
		textKeyword.setColumns(10);
		
		btnSearch = new JButton("검색");
		
		btnSearch.addActionListener(e -> contactNewSearch()); // 이벤트가 왔을때
		
		btnSearch.setBounds(300, 10, 108, 57);
		contentPane.add(btnSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 96, 410, 354);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
	}
	
	private void contactNewSearch() {
		
		String Search = textKeyword.getText();
		if(Search == null || Search.equals("")) {   
			JOptionPane.showMessageDialog(this, "경고");
			
			return;
		}
		
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		List<Contact> list = dao.search(Search);
				
		for(Contact c : list) {
			Object[] row = { c.getName(), c.getPhone(), c.getEmail()};
			model.addRow(row);
		}
		table.setModel(model);
	}
}

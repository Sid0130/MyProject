package com.itwill.project.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.itwill.project.controller.PetDao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PetMain {

	
	private static final String[] SEARCH_TYPE = { 
			"보호자", "이름", 
	};
	
	private static final String[] COULMN_CUSTOMER = { // 고객 목록. 
			"번호","이름","분류","성별","나이","체중","보호자"
	};
	private static final String[] COULMN_RECEPTION = { // 접수 목록. 
			"예약시간", "주치의", "번호", "이름", "분류", "상태"
	};
	private JFrame frame;
	private JTable tableCustomerView;
	private JPanel buttonPanel;
	private JPanel searchPanel;
	private JScrollPane scrollPaneReception;
	private JScrollPane scrollPaneCustomer;
	private JPanel customerPanel;
	private JButton btnCreateNew;
	private JButton btnCreateDoctor;
	private JButton btnSearch;
	private JComboBox<String> searchComboBox;
	private DefaultTableModel model;
	
	private JLabel lblDeleteCustmoer;
	private JLabel lblEditCustmoer;
	private JTextField textSearch;
	private JTable tableReceptionView;
	private PetDao petDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetMain window = new PetMain();
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
	public PetMain() {
		petDao = PetDao.INSTANCE; 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("동물병원 접수 프로그램 v1.0");
		frame.setBounds(100, 100, 800, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 555, 760, 37);
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		btnCreateNew = new JButton("신규등록");
		btnCreateNew.addActionListener(e -> PetCreateFrame.showPetCreateFrame(frame));
		btnCreateNew.setBounds(679, 8, 81, 23);
		buttonPanel.add(btnCreateNew);
		
		btnCreateDoctor = new JButton("주치의");
		btnCreateDoctor.addActionListener(e -> PetDoctorFrame.showDoctorCreateFrame(frame));
		btnCreateDoctor.setBounds(594, 8, 81, 23);
		buttonPanel.add(btnCreateDoctor);
		
		searchPanel = new JPanel();
		searchPanel.setBounds(12, 10, 760, 33);
		frame.getContentPane().add(searchPanel);
		searchPanel.setLayout(null);
		
		btnSearch = new JButton("검색");
		btnSearch.setBounds(691, 5, 69, 23);
		searchPanel.add(btnSearch);
		
		textSearch = new JTextField();
		textSearch.setBounds(483, 6, 207, 21);
		searchPanel.add(textSearch);
		textSearch.setColumns(10);
		
		searchComboBox = new JComboBox<>();
		searchComboBox.setBounds(377, 5, 103, 23);
		searchPanel.add(searchComboBox);
		
		scrollPaneReception = new JScrollPane();
		scrollPaneReception.setBounds(12, 75, 366, 470);
		frame.getContentPane().add(scrollPaneReception);
		
		tableReceptionView = new JTable();
		scrollPaneReception.setViewportView(tableReceptionView);
		model = new DefaultTableModel(null, COULMN_RECEPTION);
		tableReceptionView.setModel(model);
		
		scrollPaneCustomer = new JScrollPane();
		scrollPaneCustomer.setBounds(390, 75, 382, 470);
		frame.getContentPane().add(scrollPaneCustomer);
		
		tableCustomerView = new JTable();
		scrollPaneCustomer.setViewportView(tableCustomerView);
		model = new DefaultTableModel(null, COULMN_CUSTOMER); 
		tableCustomerView.setModel(model);
		
		customerPanel = new JPanel();
		customerPanel.setLayout(null);
		customerPanel.setBounds(390, 43, 382, 33);
		frame.getContentPane().add(customerPanel);
		
		lblDeleteCustmoer = new JLabel("삭제");
		lblDeleteCustmoer.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteCustmoer.setBackground(UIManager.getColor("Button.background"));
		lblDeleteCustmoer.setBounds(331, 10, 39, 15);
		customerPanel.add(lblDeleteCustmoer);
		
		lblEditCustmoer = new JLabel("수정");
		lblEditCustmoer.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditCustmoer.setBounds(280, 10, 39, 15);
		customerPanel.add(lblEditCustmoer);
	}


}

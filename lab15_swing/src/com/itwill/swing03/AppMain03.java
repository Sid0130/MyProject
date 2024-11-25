package com.itwill.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {
	// 이미지 파일들의 경로를 저장하는 배열
	private static final String[] IMAGES = {
			"images/photo1.jpg",
			"images/photo2.jpg",
			"images/photo3.jpg",
			"images/photo4.jpg",
			"images/photo5.jpg",
	};
	
	// 현재 화면에 보이는 이미지의 배열 인덱스.
	
	private int index;
	private JFrame frame; 
	private JLabel lblImage;
	private JButton btnPrev;
	private JButton btnNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
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
	public AppMain03() {
		initialize(); // 초기화 작업.
		// 초기화할때 같이 메서드 호출
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		index = 0;
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 438, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblImage = new JLabel("");
		
		// 아이콘을 세팅, 아이콘 객체를 생성하고  아이콘 인터페이스를 구현하는 클래스에서 이미지 아이콘(폴더상대경로)을 불러옴. 15번째 줄
		lblImage.setIcon(new ImageIcon(IMAGES[index])); 
		lblImage.setBounds(12, 10, 400, 400);
		frame.getContentPane().add(lblImage);
		
		btnPrev = new JButton("<");
		btnPrev.addActionListener(e -> showPreviousImage());
		btnPrev.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnPrev.setBounds(50, 420, 118, 97);
		frame.getContentPane().add(btnPrev);
		
		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 내부 클래스는 바깥 클래스의 메서드를 호출할 수 있음.
				showNextImage();
			}

		});
		btnNext.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnNext.setBounds(258, 420, 118, 97);
		frame.getContentPane().add(btnNext);
	}

		
	  private void showPreviousImage() {
	        if (index > 0) {
	            index--;
	        } else {
	            index = IMAGES.length - 1;
	        }
	        lblImage.setIcon(new ImageIcon(IMAGES[index]));
	    }

	private void showNextImage() {
		if(index < IMAGES.length - 1) {
			index++;	
		} else {
			index =0;
		}
		lblImage.setIcon(new ImageIcon(IMAGES[index]));
	}
	
	

}

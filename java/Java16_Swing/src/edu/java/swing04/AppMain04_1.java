package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04_1 {
	// 이미지 파일의 경로들을 저장하는 배열.
	private static final String[] IMAGES = {
			"images/num1.jpg", 
			"images/num2.jpg", 
			"images/num3.jpg",
			"images/num4.jpg", 
			"images/num5.jpg" 
			};
	
	private int curIndex;	// 현재 화면에 보여지는 이미지 파일의 인덱스
	private JFrame frame;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04_1 window = new AppMain04_1();
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
	public AppMain04_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 607, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblImage = new JLabel(new ImageIcon(IMAGES[curIndex]));
		// new ImageIcon("images/num1.jpg")
		lblImage.setBounds(43, 38, 503, 368);
		frame.getContentPane().add(lblImage);
		
		btnPrev = new JButton("<");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// btnPrev 버튼이 클릭됐을 때 할 일을 작성.
				showPrevImage();
			}
		});
		btnPrev.setBounds(85, 482, 121, 70);
		frame.getContentPane().add(btnPrev);
		
		btnNext = new JButton(">");
		// 람다 표현식
		btnNext.addActionListener((ActionEvent e) -> showNextImage());
		
		btnNext.setBounds(385, 482, 121, 70);
		frame.getContentPane().add(btnNext);
	}

	private void showNextImage() {
		if(curIndex < IMAGES.length - 1) {
			curIndex++;
		} else {
			curIndex = 0;
		}
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
	}

	private void showPrevImage() {
		if(curIndex > 0) {
			curIndex--;
		} else {
			curIndex = IMAGES.length - 1;
		}
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
	}
}

package edu.java.swing04;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AppMain04 {

	private JFrame frame;
	private JButton btnLeft;
	private JButton btnRight;
	private JLabel Images;
	
	private int index;
	private static final String[] IMAGES = { "images/num1.jpg", "images/num2.jpg", "images/num3.jpg",
											  "images/num4.jpg", "images/num5.jpg" };
	
	
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
		frame.setBounds(100, 100, 502, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Images = new JLabel("image");
		Images.setBounds(36, 39, 399, 400);
		Images.setIcon(new ImageIcon(IMAGES[index]));
		frame.getContentPane().add(Images);
		
		
		btnLeft = new JButton("<");	
		btnLeft.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index > 0) {
					index--;
				} else {
				}
				Images.setIcon(new ImageIcon(IMAGES[index]));
			}
		});
		
		btnLeft.setFont(new Font("굴림", Font.BOLD, 30));
		btnLeft.setBounds(36, 459, 121, 80);
		frame.getContentPane().add(btnLeft);
		
		
		btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index < IMAGES.length-1) {
					index++;
				} else {
				}
				Images.setIcon(new ImageIcon(IMAGES[index]));
			}
		});
		btnRight.setFont(new Font("굴림", Font.BOLD, 30));
		btnRight.setBounds(314, 459, 121, 80);
		frame.getContentPane().add(btnRight);
	}
	
	

}

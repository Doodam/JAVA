package edu.java.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JTextField textInput;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
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
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblResult = new JLabel("입력하세요...");
		lblResult.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
		lblResult.setBounds(12, 10, 432, 126);
		frame.getContentPane().add(lblResult);
		
		textInput = new JTextField();
		textInput.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textInput.setBounds(12, 146, 432, 223);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JButton btnInput = new JButton("입력");
		btnInput.addActionListener(new ActionListener() { // 인터페이스
			@Override
			public void actionPerformed(ActionEvent e) { // 익명클래스
				handleButtonClick();	// 내부 클래스에서 외부 클래스의 메서드를 호출할 수 있다.
			}
		});
		btnInput.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		btnInput.setBounds(295, 392, 149, 45);
		frame.getContentPane().add(btnInput);
	}

	private void handleButtonClick() {
		// JTextField의 입력 내용을 읽음.
		String msg = textInput.getText();
		// 읽은 내용을 JLabl에 씀.
		lblResult.setText(msg);
		// JTextFiel의 내용을 지움.
		textInput.setText("");
	}
}
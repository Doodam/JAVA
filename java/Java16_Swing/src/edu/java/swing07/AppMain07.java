package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {
	// JTable에서 사용할 컬럼 이름들
	private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};

	private DefaultTableModel model; // 테이블의 행, 열에 대한 정보를 갖는 객체
	private JFrame frame;
	private JTextField textKorean;
	private JLabel lblKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JLabel lblEnglish;
	private JLabel lblMath;
	private JButton btnInsert;
	private JButton btnIDelete;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setFont(new Font("굴림", Font.PLAIN, 20));
		lblKorean.setBounds(43, 58, 47, 29);
		frame.getContentPane().add(lblKorean);
		
		textKorean = new JTextField();
		textKorean.setBounds(113, 60, 192, 29);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setFont(new Font("굴림", Font.PLAIN, 20));
		lblEnglish.setBounds(43, 115, 47, 29);
		frame.getContentPane().add(lblEnglish);
		
		textEnglish = new JTextField();
		textEnglish.setColumns(10);
		textEnglish.setBounds(113, 117, 192, 29);
		frame.getContentPane().add(textEnglish);
		
		lblMath = new JLabel("수학");
		lblMath.setFont(new Font("굴림", Font.PLAIN, 20));
		lblMath.setBounds(43, 171, 47, 29);
		frame.getContentPane().add(lblMath);
		
		textMath = new JTextField();
		textMath.setColumns(10);
		textMath.setBounds(113, 173, 192, 29);
		frame.getContentPane().add(textMath);
		
		btnInsert = new JButton("입 력");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ButtonClick(e);
			}
		});
		btnInsert.setBounds(28, 240, 122, 55);
		frame.getContentPane().add(btnInsert);
		
		btnIDelete = new JButton("삭 제");
		btnIDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = table.getSelectedRow();
				model.removeRow(select);
				table.updateUI();
				
			}
		});
		btnIDelete.setBounds(216, 240, 122, 55);
		frame.getContentPane().add(btnIDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 318, 312, 282);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		Object[][] data = {}; // 테이블에 사용할 데이터
		model = new DefaultTableModel(data, COLUMN_NAMES);
//		Object[] row = {new Score(x, y, z), Score.}; 
//		model.addRow(row); 1차원 배열 넘기기 .입력버튼 눌렀을때 가져오면됨.
//		model.removeRow(0); // 행 인덱스 -> 삭제버튼에 연결.
		table.setModel(model);
		scrollPane.setViewportView(table);
		
	}

	private void ButtonClick(ActionEvent e) {
		
	
	try {		
		int num1 = Integer.parseInt(textKorean.getText());
		int num2 = Integer.parseInt(textEnglish.getText());
		int num3 = Integer.parseInt(textMath.getText());
		Score sc = new Score(num1, num2, num3);
		Object[] row = {num1, num2, num3, sc.total(), sc.average()};
		model.addRow(row);
	} catch (NumberFormatException a) {
		
	}
		
	
		
	}
}

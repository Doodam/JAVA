package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AppMain07_1 {
	private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};
	private DefaultTableModel model; // 테이블의 행, 열에 대한 정보를 갖는 객체
	
	private JFrame frame;
	private JTextField textKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JLabel lblKorean;
	private JLabel lblEnglish;
	private JLabel lblMath;
	private JButton btnInsert;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07_1 window = new AppMain07_1();
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
	public AppMain07_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setBounds(35, 28, 57, 15);
		frame.getContentPane().add(lblKorean);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setBounds(35, 65, 57, 15);
		frame.getContentPane().add(lblEnglish);
		
		lblMath = new JLabel("수학");
		lblMath.setBounds(35, 101, 57, 15);
		frame.getContentPane().add(lblMath);
		
		textKorean = new JTextField();
		textKorean.setBounds(123, 25, 201, 21);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		textEnglish = new JTextField();
		textEnglish.setColumns(10);
		textEnglish.setBounds(123, 62, 201, 21);
		frame.getContentPane().add(textEnglish);
		
		textMath = new JTextField();
		textMath.setColumns(10);
		textMath.setBounds(123, 98, 201, 21);
		frame.getContentPane().add(textMath);
		
		btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertScoreToTable();
			}
		});
		btnInsert.setBounds(55, 163, 97, 23);
		frame.getContentPane().add(btnInsert);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteRowFramTable();
			}
		});
		btnDelete.setBounds(255, 163, 97, 23);
		frame.getContentPane().add(btnDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 197, 399, 139);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Object[][] data = {}; // 테이블에 사용할 데이터
		model = new DefaultTableModel(data, COLUMN_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

		private void deleteRowFramTable() {
			// 1. 테이블에서 삭제하기 위해 선택된 행의 인덱스를 찾음.
			int index = table.getSelectedRow();
			if(index == -1) {	// 테이블에서 아무 행도 선택되지 않은 경우. 인덱스 0부터 시작하니까 아무 행도 선택 안되는곳은 -1
				JOptionPane.showConfirmDialog(
						frame,
						"제대로 선택해서 삭제하렴" ,
						"테이블 선택 오류",
						index ,
						JOptionPane.WARNING_MESSAGE);
				return; // 메서드 종료.
			} 
			
			// 2. 해당 인덱스의 행을 테이블 모델에서 삭제.
			int confirm = JOptionPane.showConfirmDialog (
					frame, 
					index + "인덱스 행을 정말 삭제하시겠습니까?", 
					"삭제 확인", 
					JOptionPane.YES_NO_OPTION );
			
			if (confirm == JOptionPane.YES_OPTION) {
				model.removeRow(index);
			}
	}

		private void insertScoreToTable() {
			// 1. JTextField에서 3과목의 점수를 읽음.
			int korean = 0;
			int english = 0;
			int math = 0;
			
			try {
				korean = Integer.parseInt(textKorean.getText());
				english = Integer.parseInt(textEnglish.getText());
				math = Integer.parseInt(textMath.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(
						frame, 
						"국어, 영어, 수학 점수는 반드시 정수로 입력 : " + e.getMessage(), 
						"입력 에러",
						JOptionPane.ERROR_MESSAGE);
				return; // 메서드 종료
			}
		
		// 2. Score 타입 객체 생성.
		Score score = new Score(korean, english, math);
		
		// 3. JTable에 행(row)을 추가.
		Object[] row = {
				score.getKorea(),
				score.getEnglish(),
				score.getMath(),
				score.total(),
				score.average()
				};
		model.addRow(row);	// addRow 메서드 보면 object[]타입 파라미터를 가짐.
		
		// 모든 JTextField의 입력 내용을 지움.
		clearAllTextFields(); // 기능 더 추가하고 싶으면 숫자입력 안된 곳만 지우게 만들어 보기.
	}
		private void clearAllTextFields() {
			textKorean.setText("");
			textEnglish.setText("");
			textMath.setText("");
		}
}

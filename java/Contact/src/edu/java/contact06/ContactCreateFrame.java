package edu.java.contact06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact05.ContactDaoImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {
	
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();

	private JPanel contentPane;
	private JPanel panel;
	private JPanel buttonPanel;
	private JLabel lblname;
	private JTextField textName;
	private JTextField textPhone;
	private JLabel lblPhone;
	private JTextField textEmail;
	private JLabel lblEmail;
	private JButton btnCreate;
	private JButton btnCancel;
	
	private Component parent; // 부모 컴포넌트(JFrame)를 저장하기 위한 필드.
	private ContactMain06 app;	// notifyContactCreated 메서드를 가지고 있는 객체.

	/**
	 * Launch the application.
	 */
	public static void showContactCreateFrame(Component parent, ContactMain06 app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parent, app);
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
	public ContactCreateFrame(Component parent, ContactMain06 app) {
		this.parent = parent;
		this.app = app;
		initialize();	// GUI 컴포넌트들을 생성하고 초기화.
	}
	
	
	public void initialize() {
		setTitle("새 연락처 저장"); // Design에서 보면 창 위쪽에 이름 바뀌어 있음.
		
		// 닫기(X) 버튼의 기본 동작을 현재 창만 닫기(dispose)로 설정.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// JFrame이 화면에 보이는 좌표
		int x = 100;
		int y = 100;
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 490, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblname = new JLabel("이 름");
		lblname.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblname.setBounds(43, 25, 97, 53);
		panel.add(lblname);
		
		textName = new JTextField();
		textName.setBounds(152, 25, 251, 53);
		panel.add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(152, 88, 251, 53);
		panel.add(textPhone);
		
		lblPhone = new JLabel("전 화 번 호");
		lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblPhone.setBounds(43, 88, 97, 53);
		panel.add(lblPhone);
		
		lblEmail = new JLabel("이 메 일");
		lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblEmail.setBounds(43, 151, 97, 53);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(152, 151, 251, 53);
		panel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnCreate = new JButton("저 장");
		btnCreate.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewContact();
			}
		});
		btnCreate.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		buttonPanel.add(btnCreate);
		
		btnCancel = new JButton("취 소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 창 닫기.
			}
		});
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		buttonPanel.add(btnCancel);
	}

	private void createNewContact() {
		// JTextField에서 이름/전화번호/이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// Contact 타입 객체 생성.
		Contact contact = new Contact(0, name, phone, email);
		
		// 리스트에 추가. 파일 업데이트. -> DAO
		dao.create(contact);
		
		// ContactMain에게 새 연락처가 저장됐다고 알려줌.
		app.notifyContactCreated();
		
		// 현재 창 닫기
		dispose();
	}

}

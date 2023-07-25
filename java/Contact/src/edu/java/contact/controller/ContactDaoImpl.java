package edu.java.contact.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;
import oracle.jdbc.OracleDriver;

import static edu.java.contact.model.Contact.Entity.*;
import static edu.java.contact.ojdbc.OracleConnect.*;


public class ContactDaoImpl implements ContactDao {
	
	private static ContactDaoImpl instance = null;
	private ContactDaoImpl() {}
	public static ContactDaoImpl getInstance() {
		if(instance == null) {
			instance = new ContactDaoImpl();
		}
		
		return instance;
	}
	
	// 오라클 DB에 접속한 Connection 객체를 리턴.
	private Connection getConnection() throws SQLException {
		// 오라클 JDBC 드라이버(라이브러리) 등록.
		DriverManager.registerDriver(new OracleDriver());
		// 오라클 DB에 접속.
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
	}
	
	// closeResources -- overloading
	private void closeResources(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}
	
	private void closeResoutces(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		closeResources(conn, stmt);
	}
		
	
	// SELECT * FROM contacts ORDER BY cid
	private static final String SQL_SELECT_ALL = "SELECT * FROM " + TBL_NAME + " ORDER BY " + COL_CID;
	@Override
	public List<Contact> read() {
		ArrayList<Contact> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while(rs.next()) {	// select 결과에서 행(row) 데이터가 있으면
				// 각 컬럼의 값들을 읽음.
				int cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getNString(COL_EMAIL);
				
				Contact contact = new Contact(cid, name, phone, email);
				list.add(contact);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResoutces(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return list;
	}

	
	// SELECT * FROM contacts WHERE cid = ?;
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM " + TBL_NAME + " WHERE " + COL_CID + " = ?";
	@Override
	public Contact read(int cid) {
		Contact contact = null; // select 결과를 저장하고 리턴하기 위한 변수.
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_BY_ID);
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, cid);
			rs = stmt.executeQuery();
			if(rs.next()) {	// 검색된 행(row) 데이터가 있다면 
				int id = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				contact = new Contact(id, name, phone, email);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResoutces(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return contact;
	}
	
	private static final String SQL_SELECT_BY_KEYWORD =
			"SELECT * FROM CONTACTS " + " WHERE LOWER(NAME) LIKE LOWER(?) " 
									  + "OR LOWER(PHONE) LIKE LOWER(?) "
									  + "OR LOWER(EMAIL) LIKE LOWER(?) "
									  + "ORDER BY CID";
	
	@Override
	public List<Contact> read(String keyword) {
		ArrayList<Contact> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_BY_KEYWORD);
			stmt = conn.prepareStatement(SQL_SELECT_BY_KEYWORD);
			
//			keyword = "%" + keyword + "%";
			String key = "%" + keyword + "%";
			System.out.println("keyword=" + keyword + ", key=" +key);
			
			stmt.setString(1, key);
			stmt.setString(2, key);
			stmt.setString(3, key);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				Contact contact= new Contact(cid, name, phone, email);		
				list.add(contact);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResoutces(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	// INSERT INTO contacts (name, phone, email) VALUES (?, ?, ?);
	private static final String SQL_INSERT = 
			"INSERT INTO " + TBL_NAME + " (" + COL_NAME + ", " + COL_PHONE + ", " + COL_EMAIL + ") " + "VALUES(?, ?, ?)";
	
	@Override
	public int create(Contact contact) {
		int result = 0;	// insert 결과를 저장하고 리턴할 변수.
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println(SQL_INSERT);
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// UPDATE contacts SET name = ?, phone = ?, email = ? WHERE cid = ?;
//	String s = "UPDATE contacts SET name = ?, phone = ?, email = ? WHERE cid = ?"; 가능!
	private static final String SQL_UPDATE = "UPDATE " + TBL_NAME 
			+ " SET " + COL_NAME + " = ?, " + COL_PHONE + " = ?, " +COL_EMAIL + " = ? " + " WHERE " +COL_CID + " = ?";
	@Override
	public int update(Contact contact) {
		int result = 0;	// update 결과를 저장하고 리턴할 변수.
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println(SQL_UPDATE);
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());
			stmt.setInt(4, contact.getCid());
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// DELETE FROM contacts WHERE cid = ?
	private static final String SQL_DELETE = "DELETE FROM " +TBL_NAME+ " WHERE "+COL_CID+ " = ?";
	@Override
	public int delete(Integer cid) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println(SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cid);
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) { // try 부분에 null이 될 가능성 있기 때문
				e.printStackTrace();
			}
		}
		return result;
	}

}









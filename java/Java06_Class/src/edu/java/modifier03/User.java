package edu.java.modifier03;

public class User {
	//field
	private int userNo;
	private String userId;
	private String password;
	
	// argument 3개 갖는 생성자
	public User(int userNo, String userId, String password) {
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
	}
	
	// getter 메서드 - 리턴타입 o , 파라미터 x
	// setter 메서드 - 리턴타입 x , 파라미터 o
	public int getUserNo() {
		return this.userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

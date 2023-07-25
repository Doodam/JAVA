package edu.java.list04;

public class User {
	// fields:
	private String id;
	private String password;
	
	// 생성자: (1)기본생성자 (2)argument 2개 갖는 생성자
	public User() {}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	// getters & setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	// toString() override
	public String toString() {
		return String.format("id = %s, password = %s", id, password);

	}
}
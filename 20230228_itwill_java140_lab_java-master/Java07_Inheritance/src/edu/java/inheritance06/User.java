package edu.java.inheritance06;

import java.util.Objects;

public class User {
    // field
    private String userId;
    private String password;
    
    // 생성자: (1) 기본 생성자, (2) argument 2개를 갖는 생성자.
    public User() {}
    
    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    
    // getters & setters
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
    
    // toString() override: "User(userId=..., password=...)"
    @Override
    public String toString() {
        // return String.format("User(userId=%s, password=%s)", this.userId, this.password);
        return "User(userId=" + this.userId
                + ", password=" + this.password
                + ")";
    }
    
    // equals() override: 두 객체의 userId가 같으면 true, 그렇지 않으면 false. 
    // hashCode() override
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof User) {
            User other = (User) obj;
            if (this.userId != null && this.userId.equals(other.userId)) {
                result = true;
            } else if (this.userId == null && other.userId == null) {
                result = true;
            }
        }
        
        return result;
    }
    
    @Override
    // equals()의 리턴 값이 true이면 hashCode()의 리턴 값이 같아야 함.
    public int hashCode() {
//        return Objects.hash(this.userId);
        if (this.userId == null) {
            return 0;
        } else {
            return this.userId.hashCode();
        }
    }

}

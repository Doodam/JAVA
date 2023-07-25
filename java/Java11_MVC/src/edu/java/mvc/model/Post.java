package edu.java.mvc.model;

import java.time.LocalDateTime;

public class Post {
    private int pid;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdTime; // 최초 작성시 시간
    private LocalDateTime modifiedTime; // 수정 할때마다 시간
    
	public Post() {}

	public Post(int pid, String title, String content, String author, LocalDateTime createdTime) {
		super();
		this.pid = pid;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdTime = createdTime;
	}


	public Post(int pid, String title, String content, String author, LocalDateTime createdTime,
			LocalDateTime modifiedTime) {
		super();
		this.pid = pid;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public int getPid() {
		return pid;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

    public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String toString() {
    	if(modifiedTime != null) {
    		return String.format("Post(pid=%d, 제목=%s, 내용=%s, 작성자=%s, 작성한 날짜 = %s, 수정한 날짜=%s)",
    							pid, title, content, author,createdTime, modifiedTime);
    	} else {
    		return String.format("Post((pid=%d, 제목=%s, 내용=%s, 작성자=%s, 작성한 날짜 = %s)",
    							pid, title, content, author,createdTime);
    	}
    }
	
	
	
    
}

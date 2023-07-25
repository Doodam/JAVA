package Test;

import java.time.LocalDateTime;

public class Classtest2  {
	// model
	
	private interface entity{
		String TBL_NAME = "BLOGS";
		String COL_id = "ID";
		String COL_title = "TITLE";
		String COL_content = "CONTENT";
		String COL_author = "AUTHOR";
		String COL_created_time = "CREATED";
		String COL_modified_time = "modified";
	}
	
	private Integer id;
	private String title;
	private String content;
	private String author;
	private LocalDateTime created;
	private LocalDateTime modified;
	
	Classtest2() {}

	public Classtest2(Integer id, String title, String content, String author, LocalDateTime created,
			LocalDateTime modified) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.created = created;
		this.modified = modified;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}
	
	
	@Override
	public String toString() {
		return String.format("Blog(id=%d, title=%s, content=%s, author=%s, created=%s, modified=%s)", 
				id, title, content, author, created, modified);
				
	}
}

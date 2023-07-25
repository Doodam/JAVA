package edu.java.file07;

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name; // implements Serializable 해야 함
	private Score score;
	
	// TODO: 생성자, getters, setters, toString
	public Student() {}
	
	public Student(int id, String name, Score score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public Student(int id, String name, int java, int web, int phyton) {
		this.id = id;
		this.name = name;
		this.score = new Score(java, web, phyton);
	}
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("Student(id=%d, name=%s, score=%s)", id, name, score);
	}
	
	
	
}

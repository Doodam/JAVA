package edu.java.modifier03;

public class Person {
	// field
	private String name;
	private int age;
	
	
	// constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// method
	// getter method (파라미터 선언x)
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	
	// setter method (파라미터 선언o)
	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			System.out.println("음수 나이는 허용 불가");
		}
	}
	
}

package edu.java.inner01;

public class Outer {
	// field
	private int x;
	private int y;
	private String s;
	
	// constructor
	public Outer(int x, int y, String s) {
		this.x = x;
		this.y = y;
		this.s = s;
	}
	
	// method
	@Override
	public String toString() {
		return String.format("Outer(x=%d, y=%d, s=%s)", this.x, this.y, this.s);
	}
	
	
	// static이 아닌 멤버 내부 클래스 (인스턴스 내부 클래스)
	 public class Inner {		// private, public, protected, 수식어없는패키지 사용 가능.
		 // filed
		 private int y;
		 
		 // constructor
		 public Inner(int y) {
			 this.y = y;
		 }
		 
		 
		 // method
		 public void printInfo() {
			 System.out.println("--- Inner Class ---");
			 System.out.println("y = " + y);	// this.y 내부 클래스의 멤버 y를 사용!!!(외부 y 아님!)
			 System.out.println("Outer x = " + x);	//  Outer.this.x 내부 클래스는 외부 클래스의 멤버들을 사용할 수 있다.
			 System.out.println("Outer y = " + Outer.this.y); // 외부 클래스 변수명이 같다면 그냥 y를 쓸순 없음. 구분이 필요!
			 System.out.println("s = " + s);
		 }
		
	}
	
	
}

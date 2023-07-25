package edu.java.swing07;

// MVC 아키텍쳐에서 Model 객체
public class Score {
	private int korea;
	private int english;
	private int math;
	
	
	public Score() {}


	public Score(int korea, int english, int math) {
		this.korea = korea;
		this.english = english;
		this.math = math;
	}


	public int getKorea() {
		return korea;
	}


	public void setKorea(int korea) {
		this.korea = korea;
	}


	public int getEnglish() {
		return english;
	}


	public void setEnglish(int english) {
		this.english = english;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}
	
	// TODO: 세 과목의 총점을 int 타입으로 리턴하는 메서드. getTotal
	public int total() {
		return korea + english + math;
	}
	
	// TODO: 세 과목의 평균을 double 타입으로 리턴하는 메서드. getMean
	public double average() {
		return total() / 3.0;
	}
	
	
	// TODO: toString override
	@Override
	public String toString() {
		return String.format("Score(korea=%d, english=%d, math=%d)", korea, english, math);
				
	}
	
	
}

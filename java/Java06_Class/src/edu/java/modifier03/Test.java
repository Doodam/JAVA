package edu.java.modifier03;

public class Test {
	// field
	private int number;
	private String name;
	private double pressur;
	private boolean married;
	
	// 마우스 오른쪽 클릭 (Alt+Shift+S) -> Source -> Generate constructor using fields...
	public Test(int number, String name, double pressur, boolean married) {
		this.number = number;
		this.name = name;
		this.pressur = pressur;
		this.married = married;
	}

	public Test() {
	}

	public Test(int number, String name, double pressur) {
		this.number = number;
		this.name = name;
		this.pressur = pressur;
	}
	
	// 마우스 오른쪽 클릭 (Alt+Shift+S) -> Source -> Generate Getters and Setters...

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPressur() {
		return pressur;
	}

	public void setPressur(double pressur) {
		this.pressur = pressur;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}
	
}

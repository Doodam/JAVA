package edu.java.class05;


public class ClassMain05 {

	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle();
		System.out.println(rec1.width + ", " + rec1.height);
		//rec1.printProductInfo();
		
		rec1.width = 1.0;   // 생성된 rec1 직사각형 객체의 가로길이(width)를 변경.
		rec1.height = 2.0; // 생성된 rec1 직사각형 객체의 세로길이(height)를 변경.
		System.out.println(rec1.perimeter());
		System.out.println(rec1.area());
		
		// argument를 갖는 생성자를 이용한 Rectangle 객체 생성.
		Rectangle rec2 = new Rectangle(4,3);
		System.out.println(rec2);
		System.out.println(rec2.width + ", " + rec2.height);
		System.out.println("둘레: " +rec2.perimeter());
		System.out.println("넓이: " +rec2.area());
		
		
	}

}

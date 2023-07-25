package edu.java.class06;

public class ClassMain06 {

	public static void main(String[] args) {
		Circle cir = new Circle();	// 기본 생성자 호출
		cir.printInfo(); //  .(점)-> 만들어진 객체를 찾아간다는 뜻.
		System.out.println("둘레: " + cir.perimeter());
		System.out.println("넓이: " + cir.area());
		
		Circle cir2 = new Circle(1.0);	// argument 1개를 갖는 생성자 호출.
		cir2.printInfo();
		System.out.println("둘레: " +cir2.perimeter());
		System.out.println("넓이: " +cir2.area());
		

	}

}

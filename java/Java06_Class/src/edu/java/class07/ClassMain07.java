package edu.java.class07;

public class ClassMain07 {

	public static void main(String[] args) {
		// 기본 생성자를 사용해서 Score 객체 생성.
		Score sc1 = new Score();
		sc1.printScore();

		System.out.println("==============================");

		// argument를 갖는 생성자를 호출해서 Score 객체를 생성.
		// void는 syso출력 할 수 없음!
		Score sc2 = new Score(50, 70, 90);
		sc2.printScore();
		System.out.println("총점: " + sc2.getTotal());
		System.out.println("평균: " + sc2.getAverage());

		System.out.println("==============================");

		// 기본 생성자를 사용해서 Student 객체를 생성.
		Student student1 = new Student();
		System.out.println(student1);
		student1.printStudent();

		Student st2 = new Student(312, "도담", sc2);
		st2.printStudent();
		
		Student st3 = new Student(3, "dd", null); // 문법적으로 null을 넣을 수 있음. =만들어지지 않았다!
		st3.printStudent();
		
		Student st4 = new Student(10, "bb", 100,20,30);
		st4.printStudent();

//		null: 생성된 객체가 없다. Heap메모리에 값이 없다.
//	    데이터 타입의 기본값: boolean - false / 정수 - 0 / 실수 - 0.0 / 참조(클래스)타입 - null
//		String emptyString = "";
//		System.out.println("길이: " +emptyString.length());
//		String nullString = null;
//		System.out.println("길이: " +nullString.length); // ---> 에러발생
		// nullString이 잘못됨. =null이기 때문에.. 객체 만들어져 있지 않은 상태!

	}

}

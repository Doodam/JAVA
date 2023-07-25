package edu.java.array02;

public class ArrayMain02 {

	public static void main(String[] args) {
		// 문자열 3개를 저장할 수 있는 배열(names)을 선언, 초기화.
		String[] names = new String[3];

		// 배열 names에 문자열을 저장.
		names[0] = "이찬희";
		names[1] = "지대한";
		names[2] = "김다훈";
//		names[3] = "유다한"; 문법적으로 오류는 없지만 출력하면 에러 발생. 

		// 배열 names의 내용 한 줄로 출력.
		// (1) for구문
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}

		System.out.println();
		
		// (2) for-each구문 -- 출력 할때만 쓰임. 안에 조건식XX
		for (String i : names) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		String[] subjects = {"Java","SQL","HTML","JavaSctipt"}; // new [] 안적어도 됨.
		for (String s : subjects) {
			System.out.print(s + " ");
		}
		
	}

}
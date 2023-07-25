package edu.java.exception06;

import java.util.Scanner;

public class ExceptionMain06 {
	
	private Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
	    // inputInteger() 메서드 테스트 코드
		ExceptionMain06 app = new ExceptionMain06();
		int x = app.inputInteger();
			System.out.println("x = " + x);
	}
	
	
	public int inputInteger() { // public 메서드는 main에 객체를 생성한 후에 사용 가능.
		// Scanner를 사용해서 입력받은 정수를 리턴.
		// Integer.parseInt(scanner.nextLine()) 과정에서 NumberFormatException이 발생할 수 있음. 무조건 int 리턴. 무한루프안에서 반복
		int result = 0; // 콘솔에서 입력받은 값을 저장할 변수
		while (true) {
			try {
				System.out.println("정수입력>> ");
				result = Integer.parseInt(scanner.nextLine());
				break; // 스위치나 반복문 종료시 break; 사용
			} catch (NumberFormatException t) {
				System.out.println("정수로 입력해주세요.");

			}
		}
		return result;

	}

}

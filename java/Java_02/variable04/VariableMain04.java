package edu.java.variable04;

import java.util.Scanner;

public class VariableMain04 {

	public static void main(String[] args) {
		// 콘솔 창에서 키보드로 정수를 입력받아서 변수에 저장하는 방법.
		// 1. Scanner타입의 변수를 선언하고 초기화. (+import)
		Scanner sc = new Scanner(System.in); // 시스템 입력 장치.
		
		System.out.println("정수 입력>>> ");
		
		// 2. Scanner객체를 사용해서 콘솔 창에서 정수를 입력받고 변수에 저장.
		int x = sc.nextInt(); // 실수 사용시, double x = db.nextdouble();
		System.out.println("x = " + x);
		
		
		System.out.println("두번째 정수 입력>>> ");
		// 변수 y에 입력받은 정수를 저장. Enter를 해야 저장됨.
		int y = sc.nextInt();
		
		// 입력받은 정수 y를 출력.
		System.out.println("y = " + y);
		
		// 사칙연산의 결과를 저장할 변수를 선언하고 덧셈 결과를 저장.
		int result = x + y;
		System.out.println("더하기: "+result); // ("더하기: " + x + y); 사용하면 앞에 문자열로 인해 더하기: 100+7 --> 1007 값으로 나옴
		
		result = x - y;
		System.out.println("빼기: "+result);
		
		result = x * y;
		System.out.println("곱하기: "+result);
		
		
		result = x / y;
		System.out.println("나누기: "+result);
		// 나누기 연산자:
		// 1. (정수) / (정수) = 나눈 몫
		// 2. (실수) / (실수) = 소수점까지 나누기 계산.
		// (실수) / (정수) 또는 (정수) / (실수)도 2번 계산 결과와 같음. (하나라도 실수 있으면 결과값은 실수로 나옴)
		
		
		
		result = x % y; // (정수) % (정수) = 나눈 나머지, 실수에서는 사용 안함!
		System.out.println("나눈 나머지 값: "+result);
		
		
		//계산기로 사용 가능

		
	
	}

}

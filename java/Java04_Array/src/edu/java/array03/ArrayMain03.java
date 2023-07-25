package edu.java.array03;

public class ArrayMain03 {

	public static void main(String[] args) {
		// Ex 1.
		// 정수(int) 10개를 저장할 수 있는 배열 선언.
		// 배열에 순서대로 0, 2, 4, 6, 8, 10, ..., 18을 저장.
		// 배열의 원소들을 한 줄로 출력.

		int[] numbers = new int[10];

		for (int n = 0; n < numbers.length; n++) {
			numbers[n] = n * 2;
		}
		for (int n : numbers) {
			System.out.print(n + " ");
		}

//		int[] numbers = {0,2,4,6,8,10,12,14,16,18};
//		for (int n : numbers) {
//			System.out.print(n + " ");
//		}
//		

		System.out.println();

		// Ex 2.
		// boolean 10개를 저장할 수 있는 배열 선언.
		// 배열에 순서대로 true, false, true, false, ... , false를 저장.
		// 배열의 원소들을 한 줄로 출력.

		boolean[] bools = new boolean[10];
		// boolean 기본 값은 false. else 부분 무시 해도 나옴 --> 초기화 됐기 때문에 false 뜸.
		for (int b = 0; b < bools.length; b++) {
			if (b % 2 == 0) {
				bools[b] = true;
			} else {
				bools[b] = false;
			}
		}
		for (boolean b : bools) {
			System.out.print(b + " ");
		}

//		boolean[] bools = {true,false,true,false,true,false,true,false,true,false};
//		for (boolean b : bools) {
//			System.out.print(b + " ");
//		}

	}

}

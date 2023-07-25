package edu.java.array09;

import java.util.Random;

public class ArrayMain09 {

	public static void main(String[] args) {
		// 1차원 정수(int) 배열 3개를 원소로 갖는 2차원 배열을 선언.
		// 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
		// 저장하는 난수의 범위는 0 이상 100 이하.
		// 2차원 배열의 원소들을 출력.

//		array1[0] = new int[2];
//		array1[1] = new int[3];	----->  규칙이 있기 때문에 for문으로 하면 편함!
//		array1[2] = new int[4];
		int[][] array1 = new int[3][];
		Random random = new Random();
		for (int i = 0; i < array1.length; i++) {
			array1[i] = new int[i + 2]; // ----> 배열 규칙 여기에 넣음. 코드 줄일 수 있음
			for (int j = 0; j < array1[i].length; j++) {
				array1[i][j] = random.nextInt(101);
			}
		}

//		for (int i = 0; i < array1.length; i++) {
//			for (int j = 0; j < array1[i].length; j++) {
//				array1[i][j] = random.nextInt(101);
//
//			}
//
//		}
		for (int[] a : array1) { // array1에서 a로 배열 넣음
			for (int b : a) { // a에서 b로 숫자 하나하나 넣음
				System.out.print(b + " ");
			}
			System.out.println();
		}

		// 2차원 배열의 모든 원소들의 합을 계산하고 출력.
		// 2차원 배열의 모든 원소들의 평균을 계산하고 출력.
		int sum = 0; // 배열의 원소들의 합을 저장히기 위한 변수
		int count = 0; // 배열의 원소들의 개수를 저장하기 위한 변수
		for (int[] x : array1) {
			for (int y : x) {
				sum += y; // 배열에서 읽은 값은 합계에 더함.
				count++; // 배열의 원소의 개수는 1 증가.
			}
		}
		System.out.println("count: " + count);

//		for (int i = 0; i < array1.length; i++) {
//			for (int j = 0; j < array1[i].length; j++) {
//				sum += array1[i][j];
//				count++;
//			}	
//			
//			
//		} 		
		System.out.println("합계 = " + sum);
		double average = (double) sum / count;
		System.out.println("평균 = " + average);

		// 최댓값을 찾고 출력.
		int max = array1[0][0]; // 최댓값을 배열의 인덱스 [0,0] 위치의 원소라고 가정.
		for (int[] x : array1) { // 2차원 배열의 원소인 1차원 배열들에 대해서
			for (int y : x) {	 // 그 1차원 배열의 각 원소(정수)들에 대해서
				if (y > max) {
					max = y;
				}
				// max = (y > max) ? y : max; 삼항연산자로 사용 가능~
			}
		}
		System.out.println("max = " + max);

		// 최솟값을 찾고 출력.
		int min = array1[0][0];
		for (int[] x : array1) {
			for (int y : x) {
				if (y < min) {
					min = y;
				}
				// min = (y < min) ? y : min;
			}
		}
		System.out.println("min = " + min);

	}
}

package edu.java.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {

		// 정수 5개를 저장할 수 있는 배열을 선언.
		int[] numbers = new int[5];
		Random random = new Random();

//		인덱스 부분만 바뀌는걸 알 수 있음!		
//		numbers[0] = 난수;
//		numbers[1] = 난수;
//		numbers[2] = 난수;

		// 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(10); // for문 밖에 random.nextint(10); 변수 지정하면 변수값 하나만 반복실행 함.
//			System.out.print(numbers[i] + " "); <-- 이렇게 해도 가능ㅇ
		}

		// 배열의 내용을 출력.
		for (int x : numbers) {
			System.out.print(x + " ");
		}

		System.out.println();

		// 배열의 모든 원소의 합을 계산하고 출력. sum변수=0;. for-each구문
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i]; // sum += numbers[i];
//			System.out.println("sum = " +sum); 하나씩 더하는 과정 볼 수 있음.
		}
		System.out.println("합계 = " + sum);
//		sum = sum + numbers[0];
//		sum = sum + numbers[1];
//		sum = sum + numbers[2];

		// 방법2. for-each구문
//		for (int b : numbers) {
//			sum += b;
//		}
//		System.out.println("합계 = " + sum);

		// 배열 원소들의 평균을 double 타입으로 계산하고 출력. (length로 나누기)
		double average = (double) sum / numbers.length;
		System.out.println("평균 = " + average);

		// 배열의 원소들 중 최댓값을 찾고 출력.
		int max = numbers[0]; 	// 배열의 첫번째(인덱스) 원소를 최댓값이라고 가정.
		for (int x : numbers) { // 배열 numbers의 모든 원소들을 차례로 순회하면서
			if (x > max) { 		// 배열에서 읽은 값이 max보다 크다면
				max = x; 		// max의 값을 x로 변경.
			}
		}
		System.out.println("max = " + max);
		

		// 배열의 원소들 중 최소값을 찾고 출력.
		int min = numbers[0];	 // 배열의 첫번째(인덱스) 원소를 최소값이라고 가정.
		for (int x : numbers) {  // 배열의 모든 원소를 순서대로 반복하면서,
			if (x < min) {		 // 배열에서 읽은 값이 min 보다 작으면,
				min = x;		 // min의 값을 x로 변경.
			}
		}
		System.out.println("min = " + min);
	}
}
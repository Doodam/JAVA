package edu.java.array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		// 인덱스는 무조건 정수! int 타입~~!!
		// 2차원 배열 : 1차원 배열들을 원소로 갖는 배열.
		// 2차원 배열의 원소를 참조할 때 인덱스가 2개 필요.
		int[][] array = { //배열 {}는 코드블록 의미가 아님!
				{1,2,3,4},
				{5,6,7,8,9},
				{10,11}
		};
		
		// 2차원 배열의 인덱스
		System.out.println(array); // 2차원 배열
		System.out.println(array[0]);	// 2차원 배열의 인덱스 i번째 원소는 1차원 배열이 된다.
		System.out.println(array[0][0]); // 2차원 배열에서 인덱스[i,j]번째 원소는 값 1개.
		System.out.println(array[1][3]); // 원소 8
		
		// 2차원 배열의 length
		System.out.println(array.length); 
		System.out.println(array[0].length);	// array[0] => {1,2,3,4} 4개
		System.out.println(array[1].length); 	// array[1] => {5,6,7,8,9} 5개
		System.out.println(array[2].length);	// array[2] => {10,11} 2개
		
		// for구문을 사용한 2차원 배열 출력
		for (int a = 0; a < array.length; a++) {	// array배열 개수 3개.
			for (int b = 0; b < array[a].length; b++) {	// array의 a번째의 개수.
				System.out.print(array[a][b] + " ");
			}
		}
		
		System.out.println();
		
		// for-each구문을 사용한 2차원 배열 출력
		for (int[] number1 : array) {    // for (타입[배열] : 배열명)
			for (int number2 : number1) {
				System.out.print(number2 + " ");
			}
		}
		
		
	}

}

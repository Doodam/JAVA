package edu.java.method03;

import java.util.Random;

public class MethodMain03_1 {

	public static int[] makeTestArray(int n) {
		int[] array = new int[n];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}
		return array;
	}
	
	//
	
	public static void printTestArray(int[] array) {
		System.out.print("[ ");
		for(int x : array) {
			System.out.print(x + " ");
		}
		System.out.println("]");
		// return; void타입의 메서드에서는 return;문 생략가능.
		
	}
	

	public static void main(String[] args) {
		// 메서드 기능 테스트를 위한 배열 만들기
		int[] array = makeTestArray(10);
		printTestArray(array);

//		Random random = new Random();
//		int[] array = new int[10];
		// 메서드 기능 테스트를 위한 배열 만들기
//		for (int i = 0; i < array.length; i++) {
//			array[i] = random.nextInt(10);
//		}
//		// 테스트 데이터 출력하기
//		for (int x : array) {
//			System.out.print(x + " ");
//		}
//		System.out.println();

		int total = sum(array);
		System.out.println("sum = " + total);
		
		double average = mean(array);
		System.out.println("average = " + average);
		
		int maxValue = max(array);
		System.out.println("max = " + maxValue);

		int maxAt = maxAt(array);
		System.out.println("maxAt = " + maxAt);
		
		int minValue = min(array);
		System.out.println("min = " + minValue);
		
		int minAt = minAt(array);
		System.out.println("minAt = " + minAt);
		
	}

	/**
	 * sum 정수 배열의 모든 원소들의 합을 리턴.
	 * 
	 * @param arr 정수 배열. int[]
	 * @return 배열 arr의 모든 원소들의 합. int
	 */
	public static int sum(int[] arr) {

		int total = 0;
		for (int x : arr) {
			total += x;
		}
		return total;
	}

	/**
	 * mean 정수 배열의 모든 원소들의 평균을 리턴.
	 * 
	 * @param arr 정수 배열. int[]
	 * @return 배열 arr의 모든 원소들의 평균(double). sum 후에 length나누기.
	 */
	public static double mean(int[] arr) {
		// 평균 = 합계 / 개수;
		return (double) sum(arr) / arr.length;
	}
	
	/**
	 * max 정수 배열에서 최댓값을 찾아서 리턴.
	 * 
	 * @param arr 정수 배열. int[]
	 * @return 배열 arr의 원소들 중 최댓값. int
	 */
	public static int max(int[] arr) {
		int max = arr[0];
		for (int x : arr) {
			max = (x > max) ? x : max;
		}
		return max;
	}
	
	/**
	 * maxAt 정수 배열에서 최댓값의 인덱스 리턴.
	 * 
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최댓값의 인덱스. int 최댓값이 여러개 있는 경우, 첫번째 최댓값의 인덱스.
	 */
	public static int maxAt(int[] arr) {
		int max = arr[0]; // 배열의 최댓값을 저장할 변수.
		int index = 0;	  // 배열의 최댓값의 index를 저장할 변수.
		for (int i = 1; i < arr.length; i++) { // 배열의 원소들을 순서대로 반복하면서 i = 1 하는 이유: 위에 int max=arr[0] 0번째로 임시 최댓값 지정했기 때문.
			// if(arr[i] > arr[index]){ --> 사용하면 max=arr[i] 생략 가능+int max=arr[0]; 두줄 생략 가능
			if(arr[i] > max) {  // 배열에서 읽은 값이 max보다 크다면
				max = arr[i];  // max값을 배열에서 읽은 값으로 변경 -- 바꿔줘야 그 다음 비교할때 값이 있어야 하므로
				index = i;	  // 최댓값의 index를 현재 index로 변경.
			}
		}
		return index;
	}
		
	/**
	 * min 정수 배열에서 최솟값을 찾아서 리턴.
	 * 
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최솟값.
	 */
	public static int min(int[] arr) {
		int minVal = arr[0];
		for (int x : arr) {
			// minVal = (x < minVal) ? x : minVal;  --if 대신 삼항연산자 사용 가능
			if (x < minVal) {
				minVal = x;
			  //minVal = arr[x] --> 이건 인덱스를 알려주는 코드
			}
		}
		return minVal;
	}
	
	/**
	 * minAt 정수 배열에서 최솟값의 인덱스 리턴.
	 * 
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최솟값의 인덱스. 최솟값이 여러개 있는 경우, 첫번째 최솟값의 인덱스.
	 */
	public static int minAt(int[] arr) {
		
		int minVal = min(arr); // 최솟값 찾음.
		int index = 0;	// 배열의 인덱스
		for (index = 0; index < arr.length; index++) { // 배열의 원소들을 순서대로 반복하면서, 그 원소가 최솟값인 지 검사.
			if(arr[index] == minVal) {
			break;	// 최솟값을 찾았으면 반복을 종료.
		}
	}
		return index;	// 반복문이 종료됐을 때의 인덱스를 리턴.

		
	}



	

}















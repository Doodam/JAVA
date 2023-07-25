package edu.java.method03;

public class MethodMain03 {

	public static void main(String[] args) {
		int[] arr = { 5, 5, 2, 2, 8, 8, 4, 7, 6 };
		int result = sum(arr);
		System.out.println("합계 = " + result);

		double result1 = mean(arr);
		System.out.println("평균 = " + result1);

		result = max(arr);
		System.out.println("최댓값 = " + result);

		result = maxAt(arr);
		System.out.println("최댓값의 인덱스 = " + result);

		result = min(arr);
		System.out.println("최솟값 = " + result);

		result = minAt(arr);
		System.out.println("최솟값의 인덱스 = " + result);
	}

	/**
	 * sum 정수 배열의 모든 원소들의 합을 리턴.
	 * 
	 * @param arr 정수 배열. int[]
	 * @return 배열 arr의 모든 원소들의 합. int
	 */
	public static int sum(int[] arr) {

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	/**
	 * mean 정수 배열의 모든 원소들의 평균을 리턴.
	 * 
	 * @param arr 정수 배열. int[]
	 * @return 배열 arr의 모든 원소들의 평균(double). sum 후에 length나누기.
	 */
	public static double mean(int[] arr) {
		double sum = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			count++;
		}
		return sum / count;
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
			if (x > max) {
				max = x;
			}
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
		int max = arr[0];
		for (int x : arr) {
			if (x > max) {
				max = x;
			}
		}
		int index = 0;
		for (int y = 0; y < arr.length; y++) {
			if (arr[y] == max) {
				index = y;
				break;
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
		int min = arr[0];
		for (int x : arr) {
			if (x < min) {
				min = x;
			}
		}
		return min;
	}

	/**
	 * minAt 정수 배열에서 최솟값의 인덱스 리턴.
	 * 
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최솟값의 인덱스. 최솟값이 여러개 있는 경우, 첫번째 최솟값의 인덱스.
	 */
	public static int minAt(int[] arr) {
		int min = arr[0];
		for (int x : arr) {
			if (x < min) {
				min = x;
			}
		}
		int index = 0;
		for (int y = 0; y < arr.length; y++) {
			if(arr[y] == min) {
				index = y;
				break;
			}
		}
		return index;
		
	}
}

package HomeWork;

import java.util.Random;

public class HomeWork03 {

	public static void main(String[] args) {
		/*
		 * 문제 1. 아래와 같이 출력하세요.
		 *
		 **
		 ***
		 ****
		 *****
		 */
		for (int x = 1; x < 6; x++) { // x 는 라인 수
			for (int y = 1; y <= x; y++) { // y 는 출력 횟수
				System.out.print("*");
			}
			System.out.println();
		}

		// Ctrl+Shift+F : 코드 포맷팅 (자동 정렬)

		System.out.println("======================");

		int line = 1;
		while (line < 6) {

			int count = 1;
			while (count <= line) {
				System.out.print('*');
				count++;
			}
			System.out.println();
			line++;
		}

		System.out.println("======================");

		/*
		 * 문제 2. 아래와 같이 출력하세요.
		 *
		 **
		 ***
		 ****
		 *****
		 ****
		 ***
		 **
		 *
		 */

		for (int x = 1; x < 6; x++) {
			for (int y = 1; y <= x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		for (int x = 6; x <= 9; x++) {
			for (int y = 4; y >= x - 5; y--) {
				System.out.print("*");
			}
			System.out.println();
		}

// 답2		
//		for (int x = 4; x >= 1; x--) {
//			for (int y = 1; y <= x; y++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
// 답3		
//		for (int x = 1; x <= 4; x++) {
//			for (int y = 4; y >= x; y--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

		System.out.println("======================");
		
		for (int x = 1; x <= 9; x++) {
			if (x <= 5) { // *를 하나씩 늘려감/
				for (int y = 1; y <= x; y++) {
					System.out.print("*");
				}
			} else {	 // *를 하나씩 줄여나감.
				for (int y = 4; y >= x-5; y--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		System.out.println("======================");
		
		/*
		 * 문제 3. 주사위 2개를 던졌을 때 나오는 주사위 눈을 (x, y) 형식으로 출력하세요. 두 눈의 합이 5가 되면 출력을 멈추세요. 힌트
		 * 1: Random 타입의 nextInt(start, end) 메서드를 사용. 
		 * 힌트 2 무한 루프: for ( ; ; ) {...}, * while (true) {...} 
		 * 출력 결과 예시: (2, 4) (6, 1) (3, 3) (4, 1)
		 */
		
		Random random = new Random ();
		
	// while (true) { 무한 반복문 
		for (;;) {	// 무한 반복문
			int dice1 = random.nextInt(1,7); // 1이상 7미만
			int dice2 = random.nextInt(6) + 1;
			System.out.printf("(%d, %d)\n" , dice1, dice2);
			if (dice1 + dice2 == 5) {		// 두 눈의 합이 5가 되면 멈춤.
				break;	
			}
			
		}
		
		
		
//		Random random = new Random();
//		int x = random.nextInt(1, 7);
//		System.out.println("x = " + x);
//		int y = random.nextInt(1, 7);
//		System.out.println("y = " + y);
//		int z = x + y;
//		System.out.println(z);
//
//		for (;;) {
//			System.out.println("(" + x + "," + y + ")");
//			for (; z == 5;) {
//				System.out.println("(" + x + "," + y + ")");
//				break;
//			}
//
//		}



	}
}

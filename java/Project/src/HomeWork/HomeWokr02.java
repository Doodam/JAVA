package HomeWork;

public class HomeWokr02 {

	public static void main(String[] args) {
		// 369 게임 출력
		/* 실행 결과
		1   2   *   4   5   *   7   8   *   10  
        11  12  *   14  15  *   17  18  *   20  
        21  22  *   24  25  *   27  28  *   *   
		 *   *   *   *   *   *   *   *   *   40  
        41  42  *   44  45  *   47  48  *   50  
        51  52  *   54  55  *   57  58  *   *   
		 *   *   *   *   *   *   *   *   *   70  
        71  72  *   74  75  *   77  78  *   80  
         81  82  *   84  85  *   87  88  *   *   
		 *   *   *   *   *   *   *   *   *   100
		 */
		for (int n = 1; n <= 100; n++) {
			int n1 = n % 10 ;		// n을 10으로 나눈 나머지 --> 1의 자릿수
			int n10 = n / 10; 		// n을 10으로 나눈 몫 --> 10의 자릿수

			// 1의 자릿수가 3/6/9인 경우.
			boolean condition1 = (n1 == 3) || (n1 == 6) || (n1 == 9);
			// 10의 자릿수가 3/6/9인 경우
			boolean condition2 = (n10 == 3) || (n10 == 6) || (n10 == 9);
			// boolean타입 변수를 정하면 if (condition1 || condition2)로 할 수 있음.			


			// 숫자를 출력할 것인지, "*"를 출력할 것인지.
			if (condition1 && condition2) {
				System.out.print("**\t");
			}	else if (condition1 || condition2) {
				System.out.print("*\t");
			}	else {
				System.out.print(n + "\t");
			}
			// 줄바꿈을 할 것인지, 아닌지.
			if (n % 10 == 0) {		// 10의 배수이면 (숫자 또는 *를 한 줄에 10개를 출력했으면)
				System.out.println();
			}
		}	



		//			if (n1 == 3 || n1 == 6 || n1 == 9 || n10 == 3 || n10 == 6 || n10 == 9) {    
		//				System.out.print("*\t");
		//			}	else {
		//				System.out.print(n + "\t");
		//			} 
		//			




		System.out.println("=======================================================================================");





		for (int n = 1; n <= 100; n++) {
			if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9 
					|| n / 10 == 3  || n / 10 == 6 || n / 10 == 9) {
				System.out.print("*" + "\t");
			}  	else	 {	
				System.out.print(n +" \t");
			}
			if (n % 10 == 0) {
				System.out.println();
			}
		}

	}
}

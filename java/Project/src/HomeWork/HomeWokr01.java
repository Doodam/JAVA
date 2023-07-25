package HomeWork;

import java.util.Random;
import java.util.Scanner;

public class HomeWokr01 {

	public static void main(String[] args) {
		// 가위바위보 게임
		// 가위-0, 바위-1, 보-2

		// 컴퓨터의 가위/바위/보는 (정수) 난수로 만듦.
		Random random = new Random();
		int computer = random.nextInt(3);
		String computerString;
		if (computer == 0)
			computerString = "가위";
		else if (computer == 1)
			computerString = "바위";
		else
			computerString = "보";




		// 사용자는 콘솔창에서 키보드로 가위/바위/보에 해당하는 정수를 입력.
		System.out.println("가위/바위/보 게임");
		System.out.println("-----------------");
		System.out.println("[0] 가위");
		System.out.println("[1] 바위");
		System.out.println("[2] 보");
		System.out.println("-----------------");
		System.out.print("선택>>> ");

		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();
		String userString;
		if (user == 0)
			userString = "가위";
		else if (user == 1)
			userString = "바위";
		else 
			userString = "보";



		// print(computer : user)

		System.out.println("computer(" + computerString + ") : user(" + userString + ")");

		// TODO: 누가 이겼는 지 결과를 출력하세요.
				if (user == 0) {
			if (computer == 0) {
				System.out.println("무승부");
			}	else if (computer == 1) {
				System.out.println("컴퓨터 승리");
			}	else {
				System.out.println("사용자 승리");
			}
		}	else if (user == 1) {
			if (computer == 0) {
				System.out.println("사용자 승리");
			}	else if (computer == 2) {
				System.out.println("컴퓨터 승리");
			}	else {
				System.out.println("무승부");
			} 	
		}	else if (user == 2) {
			if (computer == 0) {
				System.out.println("컴퓨터 승리");
			} else if (computer == 1) {
				System.out.println("사용자 승리");
			}	else  {
				System.out.println("무승부");
			}
		 }	
		 


		//  방법 2:
		if (user == computer) {    //비기는 경우 먼저 만들면 7가지로 줄일 수 있음.
			System.out.println("무승부");
		}	 else if (user == 0) {
			if (computer == 1) {
				System.out.println("컴퓨터 승리");
			} else {
				System.out.println("사용자 승리");
			}
		}	else if (user == 1) {
			if (computer == 0) {
				System.out.println("사용자 승리");
			}	else {
				System.out.println("컴퓨터 승리");
			}
		}	else if (computer == 0) {
			System.out.println("컴퓨터 승리");
		}	else {
			System.out.println("사용자 승리");

		}
		 
		
		// 방법 3:

		if (user == computer) {								// 비긴 경우
			System.out.println("무승부");

		}	else if ((user == 0 && computer == 2) || 		// 사용자가 이긴 경우
					(user == 1 && computer == 0) ||
					(user == 2 && computer == 1)) {		
			System.out.println("사용자 승리");
		}	else {	
			System.out.println("컴퓨터 승리");	  			// 사용자가 진 경우 (컴퓨터가 이긴 경우)

		}

		// 방법 4:
		int diff = user - computer;
		if (diff == 0) {
			System.out.println("무승부");
		}	else if (diff == -2 || diff == 1) {
			System.out.println("사용자 승리");
		}	else {
			System.out.println("컴퓨터 승리");
		}


	}
	


	/* if (computer == 0 && user == 1) {
		System.out.println("user 승리");
	}	else if (computer == 1 && user == 2) {
		System.out.println("user 승리");
	}	else if (computer == 2 && user == 0) {
		System.out.println("user 승리");
	}	else if (computer == 1 && user == 0) {
		System.out.println("computer 승리");
	}	else if (computer == 2 && user == 1) {
		System.out.println("computer 승리");
	}	else if (computer == 0 && user == 2) {
		System.out.println("computer 승리");
	}	else {
		System.out.println("무승부");
	}
	 */


}	// end main









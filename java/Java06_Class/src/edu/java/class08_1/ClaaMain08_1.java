package edu.java.class08_1;

public class ClaaMain08_1 {

	public static void main(String[] args) {
		Account_1 acc = new Account_1(312312, 10000); // 계좌생성
		acc.printInfo();	// 계좌 정보 출력
				
		double balance = acc.deposit(5000);	// 5,000원 입금
		System.out.println("balance = " + balance);	
		// acc.printInfo();
		
		acc.withdraw(2000);	// 2,000원 입금
		acc.printInfo();
		
		System.out.println("-------------------------------------------");
		Account_1 acc2 = new Account_1(987987, 10000);	// 2번째 계좌생성
		acc2.printInfo();
		
		acc.transfer(acc2, 3000);	// acc 계좌에서 acc2 계좌로 3,000원 이체.
		acc.printInfo();
		acc2.printInfo();
		
		

	}

}

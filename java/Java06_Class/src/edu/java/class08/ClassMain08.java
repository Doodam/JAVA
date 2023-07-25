package edu.java.class08;

public class ClassMain08 {

	public static void main(String[] args) {
		Account acc = new Account(123321, 0);
		System.out.println("계좌: " +acc.accountNo);
		System.out.println("잔액: " +acc.balance);
		System.out.println("======================");
		
		System.out.println("입금 후 잔액: " +acc.deposit(500));
		System.out.println("출금 후 잔액: " +acc.withdraw(100));
		
		System.out.println("======================");
		
		Account to = new Account(987654,0); 
		acc.transfer(to, 100);
		
		
		System.out.println("======================");
		acc.printInfo();
	}


}

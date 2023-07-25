package edu.java.class08;

/**
 * 은행 계좌 클래스. 필드: 계좌번호, 잔액. 메서드: 입금, 출금, 이체, 정보 출력.
 */
public class Account {

	// field
	int accountNo; // 계좌번호
	double balance; // 잔고

	// TODO: argument 2개를 갖는 생성자
	public Account(int accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	/**
	 * 입금(deposit)
	 * 
	 * @param amount 입금액(double). + amount
	 * @return 입금 후 잔액. balance리턴
	 */
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}

	/**
	 * 출금(withdraw). 마통가능
	 * 
	 * @param amount 출금액(double). -amount -> balance에 저장후
	 * @return 입금 후 잔액. balance리턴
	 */
	public double withdraw(double amount) {
		balance -= amount;
		return balance;
	}

	/**
	 * 이체(transfer).
	 * 
	 * @param to     이체할 은행 계좌 객체(Account 타입 객체).
	 * @param amount 이체할 금액(double).
	 */
	public void transfer(Account to, double amount) {

		if (this.balance > amount) {
			this.balance -= (double) amount;
		} else {
			System.out.println("잔액부족");
		}
		if (to.balance > 0) {
			to.balance += (double) amount;
		}
		System.out.println("이체금액: " + amount);
		System.out.println("내 계좌 잔액: " + balance);
		System.out.println("이체할 계좌 잔액: " + to.balance);

	}

	/**
	 * 정보 출력(printInfo). 계좌 번호와 잔고를 출력.
	 */
	public void printInfo() {
		System.out.println("계좌번호: " + accountNo);
		System.out.println("잔고: " + balance);
	}

}

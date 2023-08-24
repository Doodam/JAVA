package edu.java.class08;

/**
 * 은행 계좌 클래스.
 * 필드: 계좌번호, 잔액.
 * 메서드: 입금, 출금, 이체, 정보 출력.
 */
public class Account {
    // field
    int accountNo; // 계좌번호
    double balance; // 잔고
    
    // argument 2개를 갖는 생성자
    public Account(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    // method
    /**
     * 입금(deposit)
     * 
     * @param amount 입금액(double).
     * @return 입금 후 잔액.
     */
    public double deposit(double amount) {
        this.balance += amount;
        
        return this.balance;
    }
    
    /**
     * 출금(withdraw).
     * 
     * @param amount 출금액(double).
     * @return 입금 후 잔액.
     */
    public double withdraw(double amount) {
        this.balance -= amount;
        
        return this.balance;
    }
    
    /**
     * 이체(transfer).
     * 
     * @param to 이체할 은행 계좌 객체(Accout 타입 객체).
     * @param amount 이체할 금액(double).
     * @return true.
     */
    public boolean transfer(Account to, double amount) {
        // 이체: (1) 내 계좌 출금, (2) 다른 계좌 입금.
//        this.balance -= amount; // (1)
//        to.balance += amount; // (2)
        this.withdraw(amount); // (1)
        to.deposit(amount); // (2)
        
        return true;
    }
    
    /**
     * 정보 출력(printInfo).
     * 계좌 번호와 잔고를 출력.
     */
    public void printInfo() {
        System.out.printf("계좌 정보(번호: %d, 잔액: %f)\n", 
                this.accountNo, this.balance);
    }
}

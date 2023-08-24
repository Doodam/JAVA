package edu.java.loop05;

public class LoopMain05 {

    public static void main(String[] args) {
        // 1 ~ 10 정수들을 오름차순으로 한 줄에 출력(1 2 3 4 ... 10)
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // while 반복문
        int n = 1;
        while (n <= 10) {
            System.out.print(n + " ");
            n++;
        }
        System.out.println();

        // 출력 결과: 1 3 5 7 9
        for (int i = 1; i < 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        n = 1;
        while (n < 10) { // n의 값이 10보다 작은 동안 반복
            System.out.print(n + " ");
            n+= 2; // n의 값을 2 증가시킴.
        }
        System.out.println();
        
        n = 1;
        while (n < 10) { // n의 값이 10보다 작은 동안 반복
            if (n % 2 == 1) { // n의 값이 홀수이면
                System.out.print(n + " ");
            }
            n++; // n의 값을 1 증가시킴.
        }
        System.out.println();
        
    }

}

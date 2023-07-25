package edu.java.method05;

public class MethodMain05 {

	public static void main(String[] args) {
		System.out.printf("이름: %s \n", "오쌤");
		System.out.printf("이름: %s, 나이: %d \n", "오쌤", 16);
		System.out.printf("이름: %s, 나이: %d, 키: %fcm \n", "오쌤",16,180.5);
		
		// 가변길이 (variable - length) argument를 갖는 메서드.
		// 파라미터를 선언할 때, 변수 타입 뒤에 "..."을 붙임.
		// 가변길이 argument에는 전달하는 값의 개수는 제한이 없음. argument전달하지 않아도 됨!
		// 가변길이 argument는 메서드 안에서 배열처럼 취급함.
		// (주의) 가변 길이 argument는 가장 마지막 파라미터로 선언해야 함!
		// (주의) 가변 길이 argument를 갖는 parameter는 오직 1개만 선언할 수 있음.
		
		
		double result = calculate("+");		// 가변길이 argument를 0개 전달한 경우.
		System.out.println(result);	
		
		double[] arr = {1.0,1.1};			// 가변길이 argument일 때는 배열을 전달해도 됨.
		System.out.println(calculate("+", arr));
		
		
		result = calculate("+",1,2,3);  // 가변길이 argument를 2개 전달한 경우
		System.out.println(result);
		
		result = calculate("*",1,2,3,4,5);
		System.out.println(result);
		
		System.out.println(calculate("*"));
		
		System.out.println(calculate("/"));
	}
	
	/**
	 * argument op가 "+"인 경우에는, 모든 가변 argument들의 합계를 반환(return)하고.
	 * argument op가 "*"인 경우에는, 모든 가변 argument들의 곱을 반환(return)하는 메서드.
	 * @param op "+" 또는 "*". 그 이외의 문자열들은 모두 무시.
	 * @param args double 타입의 (임의의 개수의) 숫자(들).
	 * @return double타입. 
	 * op가 "+"이면, 모든 숫자들의 합을 리턴.
	 * op가 "*"이면, 모든 숫자들의 곱을 리턴. 
	 * op가 "*"인데, argument로 전달된 숫자가 없으면 1을 리턴.
	 * op가 "+" 또는 "*"가 아니면 0.0을 리턴.
	 */
	public static double calculate(String op, double... args) { //argument에 ... 은 배열로 생각하기
		double result = 0.0;
		
		
		switch (op) {
		case "+" :
			for(double x : args) {
				result += x;
			}
			break;
		case "*" :
			result = 1.0;  // 시작값을 0으로 하면 결과값이 0만 나옴!
			for (double x : args) {
				result *= x; // result = result * x;
			}
			break;
	    default :
		}
		
		return result;
	}
	
}

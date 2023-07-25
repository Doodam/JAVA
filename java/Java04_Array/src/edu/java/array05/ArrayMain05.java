package edu.java.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
		// int 10개를 저장할 수 있는 배열 선언.
		int[] genderCodes = new int[10];
//		String xM = "Male";      ---- 자주 사용하는 단어 들은 변수명 저장 해두면 편함.
//		String xF = "Female";  ----
//		int count = 10;				// 변수 지정 해두면 그때그때 바꿀때 마다 오류 없이 사용 가능.
//		int[] genderCodes = new int[count];

		// 배열의 난수(0 or 1) 10개를 저장. x >2
		Random random = new Random();
		for (int i = 0; i < genderCodes.length; i++) {
			genderCodes[i] = random.nextInt(2);
		}
		// 배열의 내용을 출력.
		for (int g : genderCodes) {
			System.out.print(g + " ");
		}
		System.out.println();

		// 문자열 10개를 저장할 수 있는 배열(genders) 선언.
		String[] genders = new String[10];
//		String[] genders = new String [count];
		// genderCodes의 값이 0이면 "Male", 1이면 "Female"을 문자열 배열에 저장.
		for (int s = 0; s < genders.length; s++) {	// length 대신 count로 사용 가능.
			if (genderCodes[s] == 0) {
				genders[s] = "Male"; // xM
			} else {
				genders[s] = "Female"; // xF
			}
		}
		// 문자열 배열 genders의 내용 출력.
		for (String s : genders) {
			System.out.print(s + " ");
		}
		System.out.println();

		// 문자열 배열에 저장된 "Male"의 개수, "Female"의 개수를 출력.
		int numOfMales = 0; // "Male"의 개수를 저장할 변수
		int numOfFemales = 0; // "Female"의 개수를 저장할 변수
		for (String s : genders) { // 배열 genders의 원소들을 순서대로 반복하면서
			if (s.equals("Male")) { // 배열에서 읽은 값이 "Male"과 같으면 // xM
				numOfMales++; // 남성의 숫자를 1 증가
			} else if (s.equals("Female")) { // 배열에서 읽은 값이 "Female"과 같으면 // xF
				numOfFemales++;				 // 여성의 숫자를 1 증가.
			}

		} 	
		System.out.println("# of male = " + numOfMales);
		System.out.println("# of female = " + numOfFemales);
		// 숫자 x ,y가 같은지 비교 : x==y
		// 두 문자열 x,y가 같은지 비교 하려면 x==y 아닌 x.equals(y)로 사용
	}

}

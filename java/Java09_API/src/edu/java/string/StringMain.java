package edu.java.string;

public class StringMain {

	public static void main(String[] args) {
		// EX 1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력.
		String ssn = "991231-1234567";
		char s = ssn.charAt(7);  // charAt 몇번째를 확인하고 싶은지, 0부터 시작.
		System.out.println(s);
		
		String[] array = ssn.split("-"); // - 기준으로 앞 뒤 구별해줌
		System.out.println(array[0]);	// 991231
		System.out.println(array[1]);	// 1234567
		System.out.println(array[1].charAt(0)); // 1234567에서 0번째 인덱스 출력.
		
//		switch (s) {			// 성별 구별해주는 출력.
//		case '1':
//		case '3':
//			System.out.println("남자");
//			break;
//		case '2':
//		case '4':
//			System.out.println("여자");
//			break;	
//		}
		
		
		// EX 2. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
		// 만약에 "홍길동" 문자열이 배열에 없으면 -1을 출력.
		String[] names = { "오쌤", "John", "Jane", "홍길동", "허균", "홍길동" };
		int index = -1;
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("홍길동")) {
				index = i;
				break;
			} 
		}
		System.out.println("홍길동 인덱스 = " + index);

		
		// Ex 3. 아래의 문자열 배열에서 5글자 이상인 문자열들을 찾아서 출력.
		String[] launguages = {"Java", "SQL", "HTML", "CSS", "JavaScript", "Pyton"};
		for (String s1 : launguages) {
			if(s1.length() >= 5) {
				System.out.println(s1);
			}
		}
		System.out.println();
		
		
		// EX 4. 아래의 문자열 배열에서 대소문자 구별 없이 "est"(대,소문자 구별XX)가 포함된 문자열들을 찾아서 출력.
		String[] tests = {"TEST", "test", "TeSt", "tEST", "테스트"};
		System.out.println("TEST".toLowerCase()); // "TEST"를 소문자로 변경
		System.out.println("TeSt".toUpperCase()); // 앞의 비교 String타입을 대문자로 변경
		System.out.println("test".contains("est")); // test를 포함하고 있나요(est를)
		for (String y : tests) {
			if(y.toLowerCase().contains("est")) {	// 소문자 or 대문자로 변경 후 containse 써서 구별하기. 리턴타입이 기본타입이면 계속 . 못씀! 
				System.out.println(y + " ");
			}
		}
		
		// Ex 5. 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 연/월/일 정보를 int 타입 변수에 저장하고 출력.
		String date = "2023-03-22";
		String[] dateString = date.split("-");
		int year = Integer.parseInt(dateString[0]);
		int month = Integer.parseInt(dateString[1]);
		int day = Integer.parseInt(dateString[2]);
		System.out.println("year: " + year);
		System.out.println("month: " + month);
		System.out.println("day: " + day);
		
		
		
		
		
		
		
		
		
		
		
	}

}

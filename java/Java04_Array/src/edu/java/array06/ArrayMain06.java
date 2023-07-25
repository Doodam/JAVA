package edu.java.array06;

public class ArrayMain06 {

	public static void main(String[] args) {
		// 문자열 1차원 배열
		String[] newJeans = { "민지","하니","다이엘","해린","혜인" };
		String[] sosi = { "태연","윤아","티파니","수영" };
		String[] bts = { "정국","뷔","RM","지민","슈가","제이홉","진" };

		// 문자열 2차원 배열 : 문자열 배열들을 원소로 갖는 배열.
		String[][] idols = { newJeans, sosi, bts };

		// 2차원 배열에서 length의 의미 :
		System.out.println(idols.length); // idols 개수
		System.out.println(idols[0].length); // idols 1 번째는 newJeans. 1번째의 개수 = 5
		System.out.println(idols[1].length); // idols 2 번째는 sosi. 2번째의 개수 = 4
		System.out.println(idols[2].length);

		// 2차원 문자열 배열 idols의 내용 출력.
		for (int i = 0; i < idols.length; i++) {
//			System.out.println(idols[i]);
			for (int j = 0; j < idols[i].length; j++) {
				System.out.print(idols[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------");
		// for-each구문을 사용한 2차원 배열 출력
	//	for (type var : arry) {...}
		for (String[] group : idols) {
			for (String member : group) {
				System.out.print(member + " ");
			}
		}
		
		
	}

}

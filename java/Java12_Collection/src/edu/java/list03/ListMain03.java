package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {

	public static void main(String[] args) {
		// 문자열들을 원소로 갖는 리스트 생성과 동시에 초기화.
		// Arrays.asList(...) - argument로 전달된 값들을 원소로 갖는 리스트 객체를 생성.
		// 다형성: Super Type var = new SubType();
		
//		String[] a = {"a","b","c"};
		List<String> subjects = Arrays.asList("Java","SQL","HTML","CSS", "JavaScript", "Servlet","JSP","Spring","Python");
		System.out.println(subjects);
		
		// 리스트 subjects에서 5글자 이상인 문자열들만 저장하는 리스트를 만들고 출력.
		List<String> longWords = new ArrayList<>(); // 빈 리스트
//		for(String i : subjects) {
//			if(i.length() >= 5) {
//				longWords.add(i);
//			}
//		}
//		System.out.println(longWords);
		
		
//		for(int i = 0; i < subjects.size(); i++) {
//			if(subjects.get(i).length() >= 5) {
//				longWords.add(subjects.get(i));
//			}
//		}
//		System.out.println(longWords);
		
		
		Iterator<String> itr = subjects.iterator();
		while(itr.hasNext()) {
			String s = itr.next(); // hasNext()호출할때마다 한칸 이동후 리턴.
			if(s.length() >= 5){
				longWords.add(s);
			}
		} 
		System.out.println(longWords);
		
		// 리스트 subjects 원소들의 글자수를 저장하는 리스트를 만들고 출력.
		List<Integer> wordLengths = new ArrayList<>();
		for(String e : subjects) {
			wordLengths.add(e.length());	
			}
		System.out.println(wordLengths);
		
		
			
		// 정수(0,1)를 저장하는 리스트를 생성.
		List<Integer> codes = Arrays.asList(0, 1, 0, 0, 1, 1);
		System.out.println(codes);
				
		// 리스트 codes의 원소가 0이면 "Male", 1이면 "Female"을 원소로 갖는 리스트를 만들고 출력.
		List<String> genders = new ArrayList<>();
		for(Integer c : codes) {
			if(c == 0) {
				genders.add("Male");
			} else {
				genders.add("Female");
			}
		}
		System.out.println(genders);
		
//		for(Integer c :codes) {
//			genders.add((c == 0) ? "Male" : "Female");
//		}
//		System.out.println(genders);
		
		
		
	}

}

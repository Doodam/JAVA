package edu.java.set02;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain02 {

	public static void main(String[] args) {
		// Integer를 원소로 갖는 HashSet 변수를 선언, 객체 생성.
		HashSet<Integer> set = new HashSet<>();
		
		set.add(1);
		set.add(100);
		set.add(52);
		set.add(1);
		
		System.out.println(set);
		
		// for-each
		for(Integer i : set) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// Iterator
		Iterator<Integer> itr = set.iterator(); // 내림차순은 사용 불가
		while (itr.hasNext()) {
			System.out.print(itr.next() + " "); 
		}
		System.out.println();
	}

}
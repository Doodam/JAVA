package edu.java.map01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
 * Collection<E>
 * |__ List<E>, Set<E>, ...   //  Element(원소)
 * List<E>, Set<E>의 공통점: 한가지 타입의 객체들을 여러개 저장할 수 있는 데이터 타입.
 * List<E>: 인덱스 있음. 저장하는 순서 중요(add 호출할 때 마다 인덱스 자동 증가). 중복된 값을 저장할 수 있음.
 * Set<E>: 인덱스 없음. 중복된 값을 저장할 수 없음.(중복된 값 넣고 싶으면 equals, hashCode)
 * 
 * Map<K, V>
 * |__ HashMap<K, V>, TreeMap<K, V>
 * Map: 키(key)와 값(value)의 쌍으로 구성된 데이터를 저장하는 데이터 타입.
 * (예) 1-강효남, 2-김다훈, 3-김도현, ..., 20-김다훈, ...
 * (1) key: 중복된 값을 가질 수 없음. 연속된 값을 가질 필요는 없음.
 *          리스트에서 인덱스의 역할(데이터를 저장/검색/수정/삭제할 때 값을 찾기 위한 용도).
 * (2) Value: 중복된 값을 가질 수 있음.
 * (3) HashMap: 검색을 빠르게 할 수 있는 Map.
 * (4) TreeMap: 정렬을 빠르게 할 수 있는 Map.
 * 
 */
public class MapMain01 {

	public static void main(String[] args) {
		// 정수를 Key로 하고, 문자열을 Value로 하는 HashMap변수 선언, 초기화
		HashMap<Integer, String> students = new HashMap<>();
		
		// put(key, value): Map에 key-value 쌍의 데이터를 저장.
		students.put(1,"이재은");
		students.put(2,"전아영");
		students.put(3,"서지수");
		students.put(20,"이재은");
		
		System.out.println("map size = " + students.size());
		System.out.println(students);
		
		// get(key): key에 매핑된 value를 리턴. key에 매핑된 value가 없으면 null을 리턴.
		System.out.println(students.get(20));
		System.out.println(students.get(10));
		
		// getOrDefault(key, defaultValue):
		// key 매핑된 value를 리턴. key에 매핑된 value가 없으면 defaultValue를 리턴.
		System.out.println(students.getOrDefault(3,"무명씨"));
		System.out.println(students.getOrDefault(10,"무명씨"));
		
		// remove(key): key에 매핑된 key-value 원소를 삭제.
		students.remove(20);
		System.out.println(students.size());
		System.out.println(students);
		
		// put(key, value):
		// (1) Map에 key가 존재하지 않으면 key-value 데이터를 저장.
		// (2) Map에 key가 존재하면, key에 매핑된 값을 변경.
		students.put(3,"Lee do dam");
		System.out.println(students);
		
		// Map에서 향상된 for문장을 사용하는 방법:
		Set<Integer> keySet = students.keySet(); // (1) Map의 key들로만 이루어진 Set을 만듦.	
		for(Integer k : keySet) {				 // (2) key들을 처음부터 끝까지 순회하면서
			System.out.println(k+ " : " + students.get(k)); // (3) key에 매핑된 value를 찾음.
		}
		

	}

}




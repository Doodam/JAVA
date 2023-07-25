package edu.java.list04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMain04 {

	public static void main(String[] args) {
		// User 타입을 저장하는 ArrayList 타입 변수 선언 및 객체 생성.
		ArrayList<User> user = new ArrayList<>();
		
		// 3개의 User객체를 ArrayList에 저장.
		User user1 = new User();
		user.add(user1);
		User user2 = new User("guest", "123");
		user.add(user2);
		User user3 = new User("bb", "456");
		user.add(user3);
		
		user.add(new User("guest","789"));

		// ArrayList 내용 출력.
		System.out.println(user);
		
		// 리스트 user에서 인덱스 0번 위치의 원소를 삭제
		user.remove(0);
		System.out.println(user);
		
		// id가 "guest"인 User객체를 리스트에서 삭제
		for(int i = 0; i < user.size(); i++) {
			if(user.get(i).getId().equals("guest")) {
				user.remove(i);
				break;
			}
		}
		System.out.println(user);
	}

}

package edu.java.mvc.controller;

import edu.java.mvc.model.Post;

public interface PostDao {

	/**
	 * 새 Post 저장 기능. Post 객체를 배열에 저장.
	 * @param c 배열에 저장할 Post 객체.
	 * @return 배열에 저장 성공하면 1, 실패하면 0
	 */
	int create(Post c);
	
	
	/**
	 * Post 전체 목록 보기 기능. 저장된 연락처 개수 크기의 연락처 배열을 리턴.
	 * @return Post 배열(Post[])
	 */
	Post[] read();
	
	
	/**
	 * 인덱스 검색. 전달받은 인덱스 위치에 있는 Post 객체를 리턴.
	 * @param index 검색할 인덱스.
	 * @return 해당 인덱스의 Post 객체 또는 null.
	 */
	Post read(int index);

	
	/**
	 * 인덱스 수정 기능.
	 * @param index 수정할 Post 인덱스. 저장된 Post 개수보다 작은 정수.
	 * @param post 수정할 Post 정보를 가진 객체.
	 * @return
	 */
	int update(int index, Post post);
	
	
	/**
	 * Post 삭제 기능.
	 * @param index 삭제할 Post의 인덱스. Post 개수보다 작은 정수.
	 * @return 삭제 성공하면 1, 실패하면 0.
	 */
	int delete(int index);
	
}

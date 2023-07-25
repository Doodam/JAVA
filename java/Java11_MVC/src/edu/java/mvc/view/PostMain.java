package edu.java.mvc.view;

import java.time.LocalDateTime;
import java.util.Scanner;

import edu.java.mvc.controller.PostDaoImpl;
import edu.java.mvc.menu.Menu;
import edu.java.mvc.model.Post;

public class PostMain {
	private Scanner scanner = new Scanner(System.in);
	private PostDaoImpl popo = PostDaoImpl.getInstance();


	public static void main(String[] args) {
		System.out.println("*** Post 작성하기 v0.1 ***");
		
		PostMain app = new PostMain();
		
		boolean run = true;
		while (run) {
			int n = app.showMainMenu();
			Menu menu = Menu.getValue(n);
			switch (menu) {
			case QUIT:
				run = false;
				System.out.println("종료");
				break;
			case CREATE:
				app.insertNewPost();
				break;
			case READ_ALL:
				app.selectAllPosts();
				break;
			case READ_BY_INDEX:
				app.selectPostByIndex();
				break;
			case UPDATE:
				app.updatePost();
				break;
			case DELETE:
				app.deletePost();
				break;
			default:
				System.out.println("메인 메뉴 번호를 확인하세요.");

			}
		}
	}

	
	
	
	private void deletePost() {
		System.out.println("\n-----  삭제 -----");
		System.out.println("삭제할 리포트의 인덱스 입력>> ");
		int index = inputNumber();
		if(!popo.isValidIndex(index)) {
			System.out.println(">>> 해당 인덱스에는 포스트 정보가 없음.");
			return;
		}
		int result = popo.delete(index);
		if(result == 1) {
			System.out.println(">>> 포스트 삭제 성공");
		} else {
			System.out.println(">>> 포스트 삭제 실패");
		}
		
	}




	private void updatePost() {
		System.out.println("\n----- 포스트 업데이트 -----");
		System.out.println("수정할 포스트의 인덱스 입력>> ");
		int index = inputNumber();

		if (!popo.isValidIndex(index)) {
			System.out.println(">>> 해당 인덱스에는 포스트 정보 없음.");
			return;
		}

		Post before = popo.read(index);
		System.out.println(">>> 수정전: " + before);

		System.out.print("제목 입력>> ");
		String title = scanner.nextLine();
		System.out.print("내용 입력>> ");
		String content = scanner.nextLine();
		LocalDateTime modifiedTime = LocalDateTime.now();
		System.out.println("수정된 날짜: " + modifiedTime);
		// 작성자는 그대로. 수정할때마다 시간뜨게
		Post post = new Post(0, title, content, before.getAuthor(), before.getCreatedTime());
		

		int result = popo.update(index, post);
		if (result == 1) {
			System.out.println("포스트 수정 성공");
		} else {
			System.out.println("포스트 수정 실패");
		}

	}




	private void selectPostByIndex() {
		System.out.println("\n----- 인덱스 검색 -----");
		System.out.println("검색할 포스트 인덱스>> ");
		int index = inputNumber();
		
		Post post = popo.read(index);
		
		if(post != null) {
			System.out.println(post);
		} else {
			System.out.println(">>> 해당 인덱스에는 포스트 정보가 없습니다.");
		}
	}




	private void selectAllPosts() {
		System.out.println("\n----- 포스트 전체 목록 -----");
		Post[] posts = popo.read();
		
		for(Post p : posts) {
			System.out.println(p);
		}
	}




	private void insertNewPost() {
		System.out.println("\n----- 새로운 포스트 작성하기 -----");
		if(!popo.isMemoryAvailable()) {
			System.out.println("저장할 공간이 부족합니다.");
			return;
		}
		System.out.print("제목 입력>> ");
		String title = scanner.nextLine();
		System.out.print("내용 입력>> ");
		String content = scanner.nextLine();
		System.out.print("작성자 입력>> ");
		String author = scanner.nextLine();
		
		LocalDateTime createdTime = LocalDateTime.now();
		System.out.println("작성된 날짜: " +createdTime);
		
		
		Post post1 = new Post(0, title, content, author ,createdTime, null);
		int result = popo.create(post1);
		if(result == 1){
			System.out.println(">>> 새 포스트 저장 성공 ");
		} else {
			System.out.println(">>> 새 포스트 저장 실패 ");
		}
				
	 
	}




	private int showMainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[0]종료 [1]새 포스트 [2]전체 보기 [3]검색 [4]수정 [5]삭제");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("선택>> ");
		int n = inputNumber();
		return n;
	}
	
	private int inputNumber() {
		while(true) {
			try {
				int n = Integer.parseInt(scanner.nextLine());
				return n;
			} catch(NumberFormatException e ) {
				System.out.println("정수를 다시 입력하세요.");
			}
		}
		
	}
	
	
}

package edu.java.class04;

// 클래스의 멤버들:
// (1) 필드(멤버 변수)
// (2) 생성자
// (3) 메서드
public class Product {
	int productId; // 상품 아이디(코드)
	String productName; // 상품 이름
	int productPrice; // 상품 가격

	// 생성자:
	// (1) 기본 생성자
	// (2) argument 3개 갖는 생성자
	// (3) productId, productName을 argument로 갖는 생성자

	public Product() {
	}

	public Product(int productId, String productName, int productPrice) {
		this.productId = productId; // this. -> 필드와 파라미터를 구분.
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public Product(int productId, String productName) {
//		this.productId = productId;
//		this.productName = productName;
		this(productId, productName, 0); // this -> 같은 클래스에 있는 다른 생성자 호출.
	}

	// 메서드:
	// (1) printProductInfo: 상품의 모든 정보를 콘솔에 출력
	// (2) setProductPrice: 상품의 가격을 전달받은 값으로 변경하는 메서드. (리턴x)

	public void printProductInfo() {
		System.out.printf("ID:%d, Name:%s, $:%d\n", productId, productName, productPrice);
		// 필드가 지역변수 이름과 혼동되지 않으면 this 생략 가능.
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

}

package models;

public class Cart {
	String userId;
	String itemName;
	
	void cartPrint() {
		System.out.println("["+userId+"] "+"상품 :"+itemName);
	}
}

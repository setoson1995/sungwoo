package models;

public class Cart {
	public String userId;
	public String itemName;
	
	void cartPrint() {
		System.out.println("["+userId+"] "+"상품 :"+itemName);
	}
}

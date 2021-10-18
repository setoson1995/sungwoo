package models;

public class  Cart{
	public int userId;
	public String itemName;
	public int itemCount;
	
	public Cart(int userId, String itemName, int itemCount) {
		this.userId = userId;
		this.itemName = itemName;
		this.itemCount = itemCount;
	}
	
	public int getCartuserId() {
		return this.userId;
	}
	public String getCartitemName() {
		return this.itemName;
	}
	public int getCartItemCount() {
		return this.itemCount;
	}
	
	public void cartPrint() {
		System.out.println("["+userId+"] "+"상품 :"+itemName+" "+itemCount);
	}
	
}

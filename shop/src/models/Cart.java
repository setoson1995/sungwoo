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
	// alt + shift + s 를 하면 get set 메서드를 만들수 있다.
	
	public int getCartuserId() {
		return this.userId;
	}
	public String getCartitemName() {
		return this.itemName;
	}
	public int getCartItemCount() {
		return this.itemCount;
	}

	
	
	public int getItemCount() {
		return itemCount;
	}


	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}


	public void cartPrint() {
		System.out.println("["+userId+"] "+"상품 :"+itemName+" "+itemCount);
	}
	
	
}

package models;

public class Item {

	public String name;
	public int price;
	public String categoryName;

	
	public Item(String name, int price, String categoryName){
		this.name = name;
		this.price = price;
		this.categoryName = categoryName;
	}
	
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public String getCategoryNumber() {
		return this.categoryName;
	}
	public void print() {
		System.out.println(" ["+name+"] "+" ["+price+"]");
	}
}

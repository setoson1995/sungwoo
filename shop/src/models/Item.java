package models;

public class Item {

	public String name;
	public int price;
	public String categoryNumber;

	
	public Item(String name, int price, String categoryNumber){
		this.name = name;
		this.price = price;
		this.categoryNumber = categoryNumber;
	}
	
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public String getCategoryNumber() {
		return this.categoryNumber;
	}
	public void print() {
		System.out.println(" ["+name+"] "+" ["+price+"]");
	}
}

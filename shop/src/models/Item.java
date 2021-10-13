package models;

public class Item {

	public String name;
	public int price;
	public String category;
	
	public Item(String name, int price, String category){
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public String getcategory() {
		return this.category;
	}
	public void print() {
		System.out.println("["+category+"] "+" ["+name+"] "+" ["+price+"]");
	}
}

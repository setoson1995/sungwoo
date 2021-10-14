package models;

public class Item {

	public String name;
	public int price;
	public int categoryNumber;

	
	public Item(String name, int price, int categoryNumber){
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
	public int getCategoryNumber() {
		return this.categoryNumber;
	}

	public void print() {
		System.out.println(" ["+name+"] "+" ["+price+"]");
	}
}

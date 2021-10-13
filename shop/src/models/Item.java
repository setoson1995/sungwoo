package models;

public class Item {

	String name;
	int price;
	public String category;
	
	public Item(String name, int price, String category){
		name = name;
		price = price;
		category = category;
	}
	
	public void print() {
		System.out.println("["+category+"] "+" ["+name+"] "+" ["+price+"]");
	}
}

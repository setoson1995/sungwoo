package models;

public class Item {

	String name;
	int price;
	String category;
	
	Item(String name, int price, String category){
		name = name;
		price = price;
		category = category;
	}
	
	void print() {
		System.out.println("["+category+"] "+" ["+name+"] "+" ["+price+"]");
	}
}

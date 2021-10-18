package models;

public class Category {
	public String category;
	
	
	public Category(String category) {
		this.category = category;
	}
	
	public String getcategory() {
		return this.category;
	}
	
	public void print() {
		System.out.println("["+category+"]");
	}
	
}

package controller;

import java.util.Scanner;
import java.util.Vector;

import models.Cart;
import models.Item;

public class ItemManager {
	Scanner scan = new Scanner(System.in);
	
//	Vector<Category> category = new Vector()<Category>();
	Vector<Item> itemList = new Vector()<Item>();
	Vector<Cart> cartList = new Vector()<Cart>();
	
	
	void addItem() {
		// 이기에 카테고리 미리 나열 후
		System.out.println("추가 상품 카테고리 :");
		int category = scan.nextInt();
		System.out.println("추가 상품 이름 :");
		int name = scan.nextInt();
		System.out.println("추가 상품 가격 :");
		int price = scan.nextInt();
		
		
	}
	void delItem() {
		
	}
	
}

package controller;

import java.util.Scanner;
import java.util.Vector;


public class ItemManager {
	Scanner scan = new Scanner(System.in);
	
	Vector<> category = new Vector()<>();
	Vector<> itemList = new Vector()<>();
	Vector<> cartList = new Vector()<>();
	
	// 아이템 추가
	public void addItem() {
		// 이기에 카테고리 미리 나열 후
		System.out.println("추가 상품 카테고리 :");
		int category = scan.nextInt();
		System.out.println("추가 상품 이름 :");
		int name = scan.nextInt();
		System.out.println("추가 상품 가격 :");
		int price = scan.nextInt();
		
		
	}
	
	// 수정은 그냥 지우고 다시 만들면됨
	// 아이템 삭제
	public void delItem() {
		// 이기에 카테고리 미리 나열 후
		System.out.println("추가 상품 카테고리 :");
		int category = scan.nextInt();
		System.out.println("추가 상품 이름 :");
		int name = scan.nextInt();
	}
	
	// 아이템 프린트
	public void itemPrint() {
		System.out.println();
	}
	
	
	//카테고리 추가
	public void addCategory() {
		
	}
	//카테고리 삭제
	public void delCategory() {
		
	}
	//카테고리 프린트
	public void categoryPrint() {
		
	}	
}

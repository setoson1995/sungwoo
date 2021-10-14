package controller;

import java.util.Scanner;
import java.util.Vector;

import models.Cart;
import models.Category;
import models.Item;


public class ItemManager {
	Scanner scan = new Scanner(System.in);
	
	
	
	public Vector<Category> category = new Vector<>();
	Vector<Item> itemList = new Vector<>();
	Vector<Cart> cartList = new Vector<>();
	
	
	void cartPrint() {
		init();
//		for(Cart i : cartList)
//			System.out.println(i);
	}
	
	// 기본 추가된 상품들
	void init() {
		
		Category category = new Category("과자");
		this.category.add(category);
		category = new Category("생선");
		this.category.add(category);
		category = new Category("육류");
		this.category.add(category);
		category = new Category("음료수");
		this.category.add(category);
//		Item temp = new Item("새우깡", 1000, category.get(0));
//		itemList.add(temp);
//		temp = new Item("고등어", 2000, category.get(1));
//		itemList.add(temp);
//		temp = new Item("칸쵸", 3600, category.get(0));
//		itemList.add(temp);
//		temp = new Item("소고기", 6500, category.get(2));
//		itemList.add(temp);
//		temp = new Item("콜라", 500, category.get(3));
//		itemList.add(temp);
//		temp = new Item("새우", 1800, category.get(1));
//		itemList.add(temp);
	}
	
	// 아이템 추가
	public void addItem() {
		// 카테고리 미리 나열 후
		if(category.size() > 0) {
			for(int i=0; i<category.size(); i++) {
				System.out.println("\n");
				System.out.print("["+i+". ");
				System.out.print(category.get(i).getcategory());
				System.out.print("] ");
			}
			System.out.println("\n0~ 추가 상품 카테고리 :");
			int sel = scan.nextInt();
//			int ck = -1;
//			for(int i=0; i<this.category.size(); i++) {
//				if(this.category.get(sel).getcategory().equals(category.get(i).getcategory()))
//					ck=i;
//			}
//			if(ck!=-1) {
				System.out.println("추가 상품 이름 :");
				String name = scan.next();
				System.out.println("추가 상품 가격 :");
				int price = scan.nextInt();
				
				boolean check  = false;
				for(int i=0; i<itemList.size(); i++) {
					if(name.equals(itemList.get(i).getName()))
						check=true;
				}
				if(!check) {
					Item newItem = new Item(name, price, sel);
					this.itemList.add(newItem);
					System.out.println("==등록완료==");
				}
				else {
					System.out.println("===이미 같은상품 등록===");
				}
//			}
		}	
		else {
			System.out.println("===등록된 카테고리가 없음===");
		}

		
		
	}
	
	// 수정은 그냥 지우고 다시 만들면됨
	// 아이템 삭제
	public void delItem() {
		// 카테고리 미리 나열 후
		if(category.size() > 0) {
			for(int i=0; i<category.size(); i++) {
				System.out.println("\n");
				System.out.print("["+i+". ");
				System.out.print(category.get(i).getcategory());
				System.out.print("] ");
			}
			System.out.println("\n0~ 삭제 상품 카테고리 :");
			int sel = scan.nextInt();
			int ck = -1;
			for(int i=0; i<this.category.size(); i++) {
				if(this.category.get(sel).getcategory().equals(category.get(i).getcategory()))
					ck=i;
			}
			if(ck!=-1) {
				//카테고리의 삭제상품 목록
				for(int i=0; i<category.size(); i++) {
					if(category.get(ck).getcategory().equals(category.get(i).getcategory())) {
						for(int j=0; j<itemList.size(); j++) {
							System.out.println(j+") ["+itemList.get(i).getName()+"] "+"["+itemList.get(i).getPrice()+"]");
						}						
					}

					System.out.println("======");
				}
				
				System.out.println("0~ 삭제 상품 :");
				int name = scan.nextInt();
				
				System.out.println(itemList.get(name).getName());
				System.out.println("위 상품을 삭제? 1)Y / 2)N :");
				int yOn = scan.nextInt();
				
				if(yOn == 1) {
					itemList.remove(name);
					System.out.println("==삭제됨==");
				}
				else if(yOn == 2) {
					System.out.println("==최소됨==");
				}
			}
		}	
		else {
			System.out.println("===등록된 카테고리가 없음===");
		}	
	}
	
	// 관리자 아이템 프린트
	public void itemPrint() {
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+category.get(i).getcategory()+"]======");
			for(int j=0; j<itemList.get(i)get(j); j++) {
				System.out.println("["+itemList.get(i).getName()+"] "+"["+itemList.get(i).getPrice()+"]");
			}
			System.out.println("======");
		}
	}
	
	// 위에서 카테고리 걸렀으니 그 카테 그 상품만 나오게
	public void categoryInItem(int sel) {
		for(int i=0; i<this.category.size(); i++) {
			if(this.category.get(sel).getcategory().equals(category.get(i).getcategory()))
				for(int j=0; j<itemList.size(); j++) {
					System.out.println(j+") ["+itemList.get(i).getName()+"] "+"["+itemList.get(i).getPrice()+"]");
				}
		}
	}
	//로그인된 카트에 상품담기
	public void pickitem(String userID, int cas, int its) {
		int n=0;
		Cart temp = new Cart();
		temp.userId = userID;
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(cas).equals(itemList.get(i).category)) {
				if(its == n) {
					temp.itemName = itemList.get(i).name;
				}
				n++;
			}
		}
		cartList.add(temp);
	}
	
	
	//카테고리 추가
	public void addCategory() {
		System.out.println("New Category Name :");
		String name = scan.next();
		boolean check = false;
		for(Category category : this.category) {
			if(name.equals(category.getcategory()))
				check = true;
		}
		if(!check) {
			Category newcategory = new Category(name);
			this.category.add(newcategory);
			System.out.println("==카테고리 생성==");
		}
		else {
			System.out.println("==이미 생성된 카테고리==");
		}
	}
	//카테고리 삭제
	public void delCategory() {
		categoryPrint();
		System.out.println("1~ Delete :");
		int n = scan.nextInt()-1;
		
		category.remove(n);
	}
	//카테고리 프린트
	public void categoryPrint() {
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+i+"] "+category.get(i).getcategory());
		}
	}	
	
	// 카트넣은 상품보기
	public void lookCart() {
		
			
	}
	//카트상품 수량추가
	public void growItemN() {

		
	}
	//카트상품 빼기
	public void delCartItem() {

		
	}
}

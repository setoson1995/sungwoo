package controller;

import java.util.Scanner;
import java.util.Vector;

import models.Cart;
import models.Category;
import models.Item;
import models.Shop;


public class ItemManager {
	public Scanner scan = new Scanner(System.in);
	
	UserManager um = new UserManager();
	
	
	public Vector<Category> category = new Vector<>();
	public Vector <Item> itemList = new Vector<>();
	public Vector<Cart> cartList = new Vector<>();
	
//		// 기본 추가된 상품들
//	Cart newCartList = new Cart(um.userlog, itemList.get(its).getName(), 1);
//	this.cartList.add(newCartList);
//	    this.category.add(new category("과자"));
//		this.category.add(new category("생선"));
//		this.category.add(new category("육류"));
//		this.category.add(new category("음료수"));
//		this.itemList.add(new itemList("새우깡", 1000, "과자"));
//		this.itemList.add(new itemList("고등어", 2000, "생선"));
//		this.itemList.add(new itemList("칸쵸", 3600, "과자"));
//		this.itemList.add(new itemList("소고기", 6500, "육류"));
//		this.itemList.add(new itemList("콜라", 500, "음료수"));
//		this.itemList.add(new itemList("새우", 1800, "생선"));

	
	// 아이템 추가
	public void addItem() {
		// 카테고리 미리 나열 후
		if(category.size() > 0) {
			for(int i=0; i<category.size(); i++) {
				System.out.println("\n");
				System.out.print("["+(i+1)+". ");
				System.out.print(category.get(i).getcategory());
				System.out.print("] ");
			}
			System.out.println("\n1~ 추가 상품 카테고리 :");
			int sel = scan.nextInt()-1;

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
					Item newItem = new Item(name, price, category.get(sel).getcategory());
					this.itemList.add(newItem);
					System.out.println("==등록완료==");
				}
				else {
					System.out.println("===이미 같은상품 등록===");
				}

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
				System.out.print("["+(i+1)+". ");
				System.out.print(category.get(i).getcategory());
				System.out.print("] ");
			}
			System.out.println("\n1~ 삭제 상품 카테고리 :");
			int sel = scan.nextInt()-1;
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
			else {
				System.out.println("===이상한거 눌러서 오류남===");
			}
		}	
		else {
			System.out.println("===등록된 카테고리가 없음===");
		}	
	}
	
	// 관리자 아이템 프린트
	public void itemPrint() {
		for(int i=0; i<category.size(); i++) {
			System.out.println(category.get(i).getcategory()+"=====");
			for(int j=0; j<itemList.size(); j++) {
				if(category.get(i).getcategory().equals(itemList.get(j).getCategoryNumber())) {
				System.out.println(j+1+") ["+itemList.get(j).getName()+"] "+"["+itemList.get(j).getPrice()+"]");
				}
			}
		}
	}
	
	// (로그인)위에서 카테고리 걸렀으니 그 카테 그 상품만 나오게
	public void categoryInItem(int cas) {
		String name = this.category.get(cas).getcategory();
			
			int check = -1;
			for(int j=0; j<itemList.size(); j++) {
				if(name.equals(itemList.get(j).getCategoryNumber())) {
					check += j;
					System.out.println(j+1+") ["+itemList.get(j).getName()+"] "+"["+itemList.get(j).getPrice()+"]");
			}
			if(check == -1) {System.out.println("===준비된 카테고리 또는 상품 없음===");}
		}
	}
	//로그인된 카트에 상품담기
	public void pickitem(int its) {
		if(its > itemList.size() && its < 0) {System.out.println("===입력정보오류===");}
		else {
			Cart newCartList = new Cart(um.userlog, itemList.get(its).getName(), 1);
			this.cartList.add(newCartList);
		}	
//		String userID, int itemName, int itemCount
	}
	
	
	// (로그인)카트넣은 상품보기
	public void lookCart() {
		int check = -1;
		for(int i=0; i<cartList.size(); i++) { //같은 유저로그찾기
			if(um.userlog == cartList.get(i).getCartuserId()) {
				check += i;
				System.out.println(cartList.get(i).getCartitemName()+" : "+cartList.get(i).getCartItemCount()+"개\n");
			}
		}	
		if(check == -1) {System.out.println("==넣은상품없음==");}
	}
	// (로그인)카트
	public void myCart(int sel) {
		//카트상품 수량추가
		
		if(sel == 1) {
			System.out.println("상품 이름 입력 :");
			String name = scan.next();
			for(int i=0; i<cartList.size(); i++) {
				if(um.userlog == cartList.get(i).getCartuserId()) {
					if(name.equals(cartList.get(i).getCartitemName())) {
						System.out.println(cartList.get(i).getCartItemCount());
							System.out.println("변경 갯수 :");
							int n = scan.nextInt();
							
							if(n > 1) {
								cartList.get(i).setItemCount(n);
								System.out.println(cartList.get(i).getCartItemCount());
							}	
							else {System.out.println("===입력갯수오류===");}
					}
				}
				else {System.out.println("===같은이름상품이 카트에 없음===");}
			}
		}

		//카트상품 빼기
		else if(sel ==2) {	
			System.out.println("상품 이름 입력 :");
			String del = scan.next();
			int check = -1;
			for(int i=0; i<cartList.size(); i++) {
				if(um.userlog == cartList.get(i).getCartuserId()) {
					if(del.equals(cartList.get(i).getCartitemName())) {
							check += i;
							cartList.remove(i);
							System.out.println("==카트에서 삭제됨==");
							break;
					}
				}
			}
			if(check == -1) {System.out.println("===상품없음 또는 입력오류===");}

		}
	
	}
	
	// 결제
	public void mypay() {
		System.out.println("== Pay ==");
		int total = 0;
		int multiply = 0;
		int after = -1;
		for(int i=0; i<cartList.size(); i++) {
			if(um.userlog == cartList.get(i).getCartuserId()) {
				multiply = cartList.get(i).getCartItemCount();
				after = i;
				for(int j=0; j<itemList.size(); j++) {
					if(cartList.get(i).getCartitemName().equals(itemList.get(j).getName())) {
						total += itemList.get(j).getPrice() * multiply;
					}
				}	
			}
		}
		if(total == 0) {System.out.println("==결제상품없음==");}
		else {
			System.out.println("total :"+total);
			System.out.println("결제금액 입력 :");
			int me = scan.nextInt();
			if(me >= total) {
				for(int i=0; i<cartList.size(); i++) {
					if(um.userlog == cartList.get(i).getCartuserId()) {
						cartList.remove(i);
					}
				}
				System.out.println("잔돈 :"+me);
				cartList.remove(after);
				System.out.println("==구매감사==");
			}
			else {
				System.out.println("===금액부족===");
			}
		}	
	}
	
	//관리자 모든카트프린트
	public void allCartPrint() {
		System.out.println("==ALL CART LIST===");
		for(int i=0; i<um.userList.size(); i++) {
			for(int j=0; j<cartList.size(); j++) {
				if(i == cartList.get(j).getCartuserId()) {
				System.out.println("ID ("+cartList.get(j).getCartuserId()+") "+"("+cartList.get(j).getCartitemName()+") "+"("+cartList.get(j).getCartItemCount()+" 개)");
				}
			}
		}
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
		
		if(n >= 0 && n <= category.size()) {
		category.remove(n);
		}
		else {
			System.out.println("===생성된 카테고리 밖 숫자 입력됨===");
		}
	}
	//카테고리 프린트
	public void categoryPrint() {
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+(i+1)+"] "+category.get(i).getcategory());
		}
	}	

}

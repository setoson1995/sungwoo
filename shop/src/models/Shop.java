package models;

import java.util.Scanner;

import controller.ItemManager;
import controller.UserManager;

public class Shop {
	Scanner scan = new Scanner(System.in);
	UserManager um = new UserManager();
	ItemManager im = new ItemManager();
	
	
	public void mainMenu() {
		boolean run = true;
		while(run) {
			System.out.println("log: "+um.userlog);
			for(int i=0; i<um.userList.size(); i++) {
				System.out.print("["+i+"] "+um.userList.get(i).getId());
				System.out.print(" / "+um.userList.get(i).getPw());
				System.out.println();
			}
			System.out.println("===SHOP===");
			System.out.println("1)가입\n2)로그인" + "\n11)관리자\n0)종료");
			int sel = scan.nextInt();
			if(sel ==1) {um.join();}
			else if(sel == 2) {
				um.logIn();
				if(um.userlog != -1) {
					System.out.println("==로그인 성공==");
					loginMenu();
				}	
			}
			else if(sel == 11) {managerMenu();}
			else if(sel == 0) {run = false;}
		}
	}
	
	// 로그인 후 메뉴
	public void loginMenu() {
			boolean run = true;
			while(run) {
				System.out.println("1)쇼핑\n2)장바구니목록\n3)탈퇴\n4)로그아웃");
				int sel = scan.nextInt();
				if(sel == 1) {shopMenu();}
				else if(sel == 2) {cartMenu();}
				else if(sel == 3) {um.closeAccount();}
				else if(sel == 4) {
					um.logOut();
					mainMenu();
				}
			}
	}
	//쇼핑
	void shopMenu() {
		boolean run = true;
		while(run) {
			im.categoryPrint();
			System.out.println("11)뒤로가기");
			int cas = scan.nextInt();
			if(cas == 11) {break;}
			
			System.out.println("[상품]");
			im.categoryInItem(cas);
			int its = scan.nextInt()-1;
//			im.pickitem(um.userList.get(um.userlog).id, cas, its);
			
		}
	}
	//장바구니
	void cartMenu() {
		boolean run = true;
		while(run) {
			System.out.println("==List==");
			im.lookCart();
			System.out.println("1)추가된상품 수량추가\n2)상품빼기\n3)결제\n4)뒤로가기");
			int sel = scan.nextInt();
			if(sel == 1) {im.growItemN();}
			else if(sel == 2) {im.delCartItem();}
			else if(sel == 3) {pay();}
			else if(sel == 4) {loginMenu();}
		}
	}
	
	//결제
	void pay() {
		
	}
	
	
	//관리자 모드
	void managerMenu() {
		boolean run = true;
		while(run) {
			System.out.println("1)유저관리\n2)아이템관리\n3)카테고리관리\n4)뒤로가기");
			int sel = scan.nextInt();
		
			if(sel == 1) {userSetting();}
			else if(sel == 2) {itemSetting();}
			else if(sel == 3) {categorySetting();}
			else if(sel == 4) {mainMenu();}
		}
	}
	void userSetting() {
		boolean run = true;
		while(run) {
			System.out.println("1)전체유저보기\n2)추가\n3)삭제\n4)뒤로가기");
			int sel = scan.nextInt();
			
			if(sel == 1) {System.out.println(um.userList);}
			else if(sel == 2) {um.join();}
			else if(sel == 3) {um.delAccount();}
			else if(sel == 4) {managerMenu();}
		}	
	}
	void itemSetting() {
		boolean run = true;
		while(run) {
			System.out.println("1)전체아이템보기\n2)추가\n3)삭제\n4)뒤로가기");
			int sel = scan.nextInt();
			
			if(sel == 1) {im.itemPrint();}
			else if(sel == 2) {im.addItem();}
			else if(sel == 3) {im.delItem();}
			else if(sel == 4) {managerMenu();}
		}	
	}
	void categorySetting() {
		boolean run = true;
		while(run) {
			System.out.println("1)전체카테고리보기\n2)추가\n3)삭제\n4)뒤로가기");
			int sel = scan.nextInt();
			
			if(sel == 1) {im.categoryPrint();}
			else if(sel == 2) {im.addCategory();}
			else if(sel == 3) {im.delCategory();}
			else if(sel == 4) {managerMenu();}
		}	
	}
	
}
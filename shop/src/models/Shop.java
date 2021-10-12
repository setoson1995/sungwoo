package models;

import java.util.Scanner;

import controller.UserManager;

public class Shop {
	Scanner scan = new Scanner(System.in);
	UserManager um = new UserManager();
	
	
	public void mainMenu() {
		boolean run = true;
		while(run) {
			System.out.println("===SHOP===");
			System.out.println("1)가입\n2)로그인" + "\n99)관리자\n0)종료");
			int sel = scan.nextInt();
			if(sel ==1) {um.join();}
			else if(sel == 2) {
				if(um.logIn()) {
					System.out.println("==로그인성공==");
					loginMenu();
				}
			}
			else if(sel == 99) {managerMenu();}
		}
	}
	
	void loginMenu() {
		boolean run = true;
		while(run) {
			System.out.println("1)쇼핑\n2)장바구니목록\n3)뒤로가기");
			int sel = scan.nextInt();
			if(sel == 1) {shopMenu();}
			else if(sel == 2) {cartMenu();}
			else if(sel == 3) {}
		}
	}
	
	void shopMenu() {
		boolean run = true;
		while(run) {
			System.out.println("1)카테고리\n2)뭘까\n3)뒤로가기");
			int sel = scan.nextInt();
			if(sel == 1) {}
			else if(sel == 2) {}
			else if(sel == 3) {loginMenu();}
			
		}
	}
	
	void cartMenu() {
		boolean run = true;
		while(run) {
			System.out.println(")결제");
			int sel = scan.nextInt();
			if(sel == 1) {}
			else if(sel == 2) {}
		}
	}
	
	void managerMenu() {
		boolean run = true;
		while(run) {
			System.out.println("1)유저관리\n2)아이템관리\n3)카테고리관리/n4)뒤로가기");
			int sel = scan.nextInt();
			if(sel == 1) {userSetting();}
			else if(sel == 2) {itemSetting();}
			else if(sel == 3) {categorySetting();}
			else if(sel == 4) {mainMenu();}
		}
	}
	
	void userSetting() {
		
	}
	void itemSetting() {
		
	}
	void categorySetting() {
		
	}
	
}
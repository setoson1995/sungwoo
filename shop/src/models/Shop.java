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
			System.out.println("1)가입\n2)탈퇴\n3)로그인\n4)로그아웃" + "\n100)관리자\n0)종료");
			int sel = scan.nextInt();
			if(sel ==1) {um.join();}
			else if(sel == 3) {
				if(um.logIn()) {
					System.out.println("==로그인성공==");
				}
			}
			else if(sel == 2) {}
		}
	}
}

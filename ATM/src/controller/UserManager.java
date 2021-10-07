package controller;

import java.util.ArrayList;

import models.User;
import models.Bank;

public class UserManager {
	
	public static UserManager instance = new UserManager();
	private UserManager() {}
	
	// users : 중앙 (총) 데이터
	private ArrayList<User> users = new ArrayList<>();
	
	// 가입
	public void joinUser() {
		System.out.print("ID :");
		String id = Bank.scan.next();
		System.out.print("PW :");
		String pw = Bank.scan.next();
		System.out.print("NAME :");
		String name = Bank.scan.next();
		
		User newUser = new User(randomCode(), id, pw, name);
		this.users.add(newUser);
	}
	// 가입과 동시에 랜덤 계좌 생성
	private int randomCode() {
		while(true) {
			int r = Bank.ran.nextInt(899)+100;
			
			boolean ck = false;
			for(int i=0; i<users.size(); i++) {
				if(r == users.get(i)) {
					ck =true;
				}
			}
			if(!ck) {
				return r;
			}
		}
	}
	
	public int login() {
		System.out.print("ID :");
		String id = Bank.scan.next();
		System.out.print("Pw :");
		String pw = Bank.scan.next();
		
		for(int i=0; i<this.users.size(); i++) {
			if(users.get(i).getId().equals(id) && users.get(i).getpw().equals(pw)) {
				return i;
			}
		}
		return -1;
	}
}

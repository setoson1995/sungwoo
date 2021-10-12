package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;

public class UserManager {
	Scanner scan = new Scanner(System.in);
	
	private ArrayList<User> userList = new ArrayList<>();
	int userlog = -1;
	
	
	public void join() {
		System.out.println("New ID :");
		String id = scan.next();
		System.out.println("New PW :");
		String pw = scan.next();
		
		boolean check = false;
		for(User user : this.userList) {
			if(id.equals(user.getId()))
				check = true;
		}
		
		if(!check) {
			User newUser = new User(id, pw);
			this.userList.add(newUser);
			System.out.println("==가입==");
		}
		else {
			System.out.println("===중복아이디===");
		}
		
	}
	
	
	public boolean logIn() {
		System.out.println("ID :");
		String id = scan.next();
		System.out.println("PW :");
		String pw = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i)) && pw.equals(userList.get(i))) {
				userlog = i;
				break;
			}
		}
		return false;		
	}
	
	
}

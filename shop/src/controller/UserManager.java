package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;

public class UserManager {
	Scanner scan = new Scanner(System.in);
	
	private ArrayList<User> userList = new ArrayList<>();
	int userlog = -1;
	
	// 가입
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
	
	// 회원탈퇴
	public void closeAccount() {
		System.out.println("진짜 탈퇴할꺼? <1)네, 2)아니오>");
		int sel = scan.nextInt();
		if(sel == 1) {}
		else if (sel == 2) {}
	}
	
	//관리자 삭제
	public void delAccount() {
		
	}
	
	// 로그인
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
	
	// 로그아웃
	public void logOut() {
		userlog = -1;
		System.out.println("==로그아웃==");
	}
	
	//전체 유저프린트
	public void userPrint() {
		System.out.println();
	}
}

package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.Shop;
import models.User;


public class UserManager {
	Scanner scan = new Scanner(System.in);
	
	public ArrayList<User> userList = new ArrayList<>();
	public static int userlog = -1;
	
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
		if(sel == 1) {
			userList.remove(userlog);
			userlog=-1;
			System.out.println("==탈퇴됨==");

			
		}
		else if (sel == 2) {System.out.println("==취소==");}
		else {
			System.out.println("===이상한거 눌러서 오류남===");
		}
	}
	
	//관리자 삭제
	public void delAccount() {
		System.out.println("del ID :");
		String delid = scan.next();
		int check = -1;
		for(int i=0; i<userList.size(); i++) {
			if(delid.equals(userList.get(i).getId())) {
				check = i;
				break;
			}
		}
		
		if(check == -1) {
			System.out.println("===삭제대상 다시확인===");
		}
		else {
			userList.remove(check);
			System.out.println("==삭제됨==");
		}
	}
	
	// 로그인
	public boolean logIn() {
		System.out.println("ID :");
		String id = scan.next();
		System.out.println("PW :");
		String pw = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).getId()) && pw.equals(userList.get(i).getPw())) {
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
		for(User i : userList)
			System.out.println(i);
	}
}

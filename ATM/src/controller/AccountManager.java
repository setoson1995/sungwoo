package controller;

import java.util.ArrayList;

import models.Account;
import models.Bank;

public class AccountManager {
	
	private UserManager um = UserManager.instance;
	public static AccountManager instance = new AccountManager();
	
	private ArrayList<Account>accs = new ArrayList<>();
	
	public void createAcc() {
		/* 현재 로그인 중인 회원이
		 * 보유한 계좌의 수가 확인이 되고
		 * 계좌의 수가 Account.MAX 값을 기준으로
		 * 처리가 두 가지로 나뉨
		 */
		
		int userCode = um.users.get(Bank.log).getUserCode();
			
	
		int cnt = um.users.get(Bank.log).getAccCnt();
		if(cnt < 3) {
			this.accs.add(new Account(randomCode(), userCode));
			System.out.print("계좌생성 완료");
		}
		else {
			System.out.println("최대개설 초과");
		}
	}

	private int randomCode() {
		while(true) {
			int r = Bank.ran.nextInt(899)+100;
			
			boolean ck = false;
			for(int i=0; i<this.users.size(); i++) {
				if(r == this.users.get(i).getCode()) {
					ck =true;
				}
			}
			if(!ck) {
				return r;
			}
		}
	}
	
	private void printAccs() {
		int userCode = um.users.get(Bank.log).getUserCode();
		
		for(Account acc : this.accs) {
			if(userCode == acc.getUserCode())
				System.out.println(acc);
		}
	}
	
	////
	public void deleteAcc() {
		printAccs();
		System.out.println("삭제할 계좌 :");
		
		String input = Bank.scan.next();
		int delIdx = findIndex(input);
		
		int cnt = um.users.get(Bank.log).getAccCnt();
		
		if(delIdx != -1) {
			this.accs.remove(delIdx);
			um.users.get(Bank.log).setAccCnt(--cnt);
			System.out.println("계좌철회 완료");
		}
	}
	
	private int findIndex(String input) { // 로그인 한 사용자에 대해서
		int index = -1;
		try {
			int userCode = um.users.get(Bank.log).getUserCode();
			int cnt = um.users.get(Bank.log).getAccCnt();
			
			int num = Integer.parseInt(input);
			
			
		}
	}
}

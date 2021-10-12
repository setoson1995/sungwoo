package controller;

import models.Bank;

public class BankManager {
	
	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;
	
	public static BankManager instance = new BankManager();
	private BankManager() {}
	
	public void run() {
		// 실행 시작
		boolean isRun = true;
		while(isRun) {
			System.out.println(Bank.getName() + "ATM");
			printMenu();
			isRun = selectMenu();
		}
	}
	
	private void printMenu() {
		if(Bank.log == -1) {
			System.out.println("1.로그인\n2.회원가입\n3.종료");
		}
		else {System.out.println("1.입금\n2.출금\n3.이체\n4.조회\n5.계좌개설\n6.계좌철회");
		}
	}
		
	private boolean selectMenu() {
		String input = Bank.scan.next();
		
		try {
			int sel = Integer.parseInt(input);
			//로그인하면 메뉴가 바뀌니까 로그체크 
			if(Bank.log == -1) {
				//로그인
				if(sel == 1) {
					Bank.log = um.login();
				}
				//회원가입
				else if(sel == 2) {
					// 회원가입 메서드를 호출
					um.joinUser();
//					UserManager.instance.joinUser();
				}
				//종료
				else if(sel == 3) {
					return false;
				}
			}
			else { // 로그인을 했을때에만 선택ㄷ하는 메뉴에 대하여
				if(sel == 1) {}
				else if(sel == 2) {}
				else if(sel == 3) {}
				else if(sel == 4) {}
				else if(sel == 5) {
					am.createAcc();
				}
				else if(sel == 6) {}
			}
		} catch (Exception e) {
			System.out.println("입력값을 확인하세요"); // 문자로 입력되면 발생
		}
		
		return true;
	}
	
	
}

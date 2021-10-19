package system_work;

import gameManager.Main;

public class Store {

	public void storeMain() {
		while(true) {
			System.out.println("=== Store Menu ===");
			System.out.println("[1) 무기]  [2) 갑옷]  [3) 반지]  [4) 뒤로가기]");
			int storeSel = Main.scan.nextInt();
			
			if(storeSel == 1) {}
			else if(storeSel ==2) {}
			else if(storeSel ==3) {}
			else if(storeSel ==4) {break;}
		}
	}
}

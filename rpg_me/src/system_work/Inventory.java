package system_work;

import gameManager.Main;

public class Inventory {
	
	public void inventoryMain() {
		while(true) {
			System.out.println("=== Inventory Menu ===");
			System.out.println("[1) 착용]  [2) 판매]  [3) 뒤로가기]");
			int invenSel = Main.scan.nextInt();
			
			if(invenSel == 1) {}
			else if(invenSel == 2) {}
			else if(invenSel == 2) {break;}
		}
	}
}

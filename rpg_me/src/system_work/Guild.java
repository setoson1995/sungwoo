package system_work;

import gameManager.Main;

public class Guild {

	public void guildMain() {
		while(true) {
			System.out.println("=== Guild Menu ===");
			System.out.println("[1) 길드목록]  [2) 길드원추가]  [3) 길드원삭제]\n"
					+ "[4) 파티원교체]  [5) 정렬]  [6) 뒤로가기]");
			int storeSel = Main.scan.nextInt();
			
			if(storeSel == 1) {}
			else if(storeSel ==2) {}
			else if(storeSel ==3) {}
			else if(storeSel ==4) {}
			else if(storeSel ==5) {}
			else if(storeSel ==6) {break;}
		}
	}
}

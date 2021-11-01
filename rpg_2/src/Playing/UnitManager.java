package Playing;

import java.util.Vector;

import Model.Player;
import Model.Unit;

public class UnitManager {
	Vector<Player> playerList = new Vector<>();
	Vector<Unit> monList = new Vector<>();
	String path = ""; // 패키지명 +
	String mons [] = {"UnitWolf", "UnitBat", "UnitOrc"};
	
	UnitManager(){
		playerList.add(new Player("전사", 1000, 45));
		playerList.add(new Player("마법사", 800, 60));
		playerList.add(new Player("힐러", 500, 70));
	}
	void monster_rand_set(int size) { // 여기 사이즈는 Battle클레스에 4라고 선언됨
		for(int i=0; i<size; i++) {
			int num = GameTool.ran.nextInt(mons.length); // 이건 3이라는건가?
			try {
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.newInstance();
				Unit temp = (Unit)obj;
				int hp = GameTool.ran.nextInt(100)+100;
				int pow = GameTool.ran.nextInt(10)+10;
				temp.init(hp, pow);
				monList.add(temp);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace(); // 이거 뭐지??
			}
		}
	}
}

package Playing;

import java.util.Vector;

import Model.Player;
import Model.Unit;

public class Battle extends Stage{
	UnitManager um = new UnitManager();
	Vector<Player> playerList = null; // 여기 벡터는 뭐하는데 쓰는거? 왜 널이야?
	Vector<Unit> monList = null;
	
	int monDead = 0;
	int playerDead = 0;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		um.monList.clear();
		um.monster_rand_set(4); 
		playerList = null;
		playerList = um.playerList; // 이걸로 전,마,힐 추가했네
		monList = null;
		monList = um.monList; // 여기서 몬스터 추가
		monDead = monList.size(); // 위에 널인데 무슨 사이즈?
		playerDead = playerList.size(); // 위에 널인데 무슨 사이즈?
	}
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
}

package Playing;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameTool{
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();
	public static String nextStage = "";
	String curStage = ""; // 이게 게임 종료??
	
	
	
	Map<String, Stage> mapList = new HashMap<String, Stage>();
	
	GameTool(){
		mapList.put("TITLE", new Title());
		mapList.put("BATTLE", new Battle());
		mapList.put("LOBBY", new Lobby());
		nextStage = "TITLE";
	}
	
	boolean changeStage() {
		
		if(curStage.equals(nextStage)) return true;
		
		curStage = nextStage;
		Stage stage = mapList.get(curStage);
		stage.init();
		
		boolean run = true;
		while(true) {
			run = stage.update();
			if(run == false) break;
		}
		
		if(nextStage.equals("")) return false;
		else return true;
		
	}


}

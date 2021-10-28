package Playing;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameTool {
	public static Scanner scan = new Scanner(System.in);
	public static String nextStage = "";
	String curStage = "";
	
	Map<String, Stage> mapList = new HashMap<>();
	
	GameTool(){
		mapList.put("TITLE", null);
		mapList.put("TITLE", null);
		mapList.put("TITLE", null);
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

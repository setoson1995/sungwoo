package Playing;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class sample extends Stage{
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		System.out.println("lobby"
				+ "1) 배틀  2) 종료");
		int sel = GameTool.scan.nextInt();
		
		if(sel == 1) {GameTool.nextStage = "";}
		else if(sel == 2) {GameTool.nextStage = "게임 종료";}
		else GameTool.nextStage = "";
		return false;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
//	public static Scanner scan = new Scanner(System.in);
//	public static Random ran = new Random();
//	public static String nextStage = "";
//	String curStage = ""; 
//	
//	Map<String, Stage> mapList = new HashMap<String, Stage>();
//	
//	sample(){
//		mapList.put("TITLE", new Title());
//		mapList.put("TITLE", new Battle());
//		mapList.put("TITLE", new Lobby());
//		
//	}
//	
//	boolean changeStage() {
//		if(curStage.equals(nextStage)) return true;
//		
//		curStage = nextStage;
//		Stage stage = mapList.get(curStage);
//		stage.init();
//		
//		boolean run = true;
//		while(true) {
//			run.stage.update();
//			if(run == false) break;
//		}
//		
//		if(nextStage.equals("")) return false;
//		else return true;
//	}
//	public static void main(String[] args) {
//		GameTool gametool = new GameTool();
//		boolean run = true;
//		while(true) {
//			run = gametool.changeStage();
//			if(run == false) {
//				break;
//			}
//		}
//		System.out.println("게임 오버");
//		
//	}
}

package Playing;

public class Lobby extends Stage {
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		System.out.println("=== LOBBY ===\n"
				+ "1) 전투   2)종료");
		int sel = GameTool.scan.nextInt();
		
		if(sel == 1) {
			GameTool.nextStage = "BATTLE";
		}
		else if(sel == 2) {}
		else {}
		return false;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}

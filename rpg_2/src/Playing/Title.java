package Playing;

public class Title extends Stage {
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		System.out.println("=== RPG ===");
		System.out.println("[시작] 을 입력하세요");
		String start = GameTool.scan.next();
		if(start.equals("시작"));
		GameTool.nextStage = "LOBBY";
		return false;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}

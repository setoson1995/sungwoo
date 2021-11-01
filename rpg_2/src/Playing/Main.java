package Playing;

public class Main {

	public static void main(String[] args) {
		
		GameTool gametool = new GameTool();
		
		
		// TODO Auto-generated method stub
		boolean run = true;
		while(run) {
			run = gametool.changeStage();
			if(run == false) {
				break;
			}
		}
		System.out.println("게임오버");
		
//		Unit temp = null;
//			
//		try {
//			class<?>clazz = class.forName("lv10.Unit");
//			Object obj = clazz.getDeclaredConstructor().newInstance(); //clazz.newInstance();
//			temp = (Unit) obj;
//			temp.hp = 100;
//			temp.pow = 16;
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		System.out.println(temp.hp);
//		System.out.println(temp.pow);
		
	}

}

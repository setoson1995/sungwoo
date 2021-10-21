package character;

import system_work.Guild;
import system_work.Inventory;

public class Player {
	public static int money;
	static Guild guild = new Guild();
	static Inventory inventory = new Inventory();
	
	
	public Player(){
		money = 100000;
//		guild
	}
	
	public void inventoryMenu() {
		inventory.inventoryMain();
	}
	
	public void guildMenu() {
		guild.guildMain();
	}
	
}

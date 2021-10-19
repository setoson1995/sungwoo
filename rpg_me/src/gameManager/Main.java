package gameManager;

import java.util.Random;
import java.util.Scanner;

import character.Player;
import system_work.Guild;
import system_work.Inventory;
import system_work.Store;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();

	public void Main() {
		Player player = new Player();
		Inventory inventory = new Inventory();
		Store store = new Store();
		Guild guild = new Guild();

		while (true) {
			System.out.println("===[ Main Menu ]===");
			System.out.println("[1) Inventory]  [2) Store]  [3) Guild]\n"
					+ "[4) Save]  [5) Load]  [6) Close]");
			int mainSel = scan.nextInt();

			if (mainSel == 1) {inventory.invenMain();}
			else if (mainSel == 2) {store.storeMain();} 
			else if (mainSel == 3) {guild.guildMain();}
			else if (mainSel == 4) { }
			else if (mainSel == 5) { }
			else if (mainSel == 6) {break;}
		}
	}
}

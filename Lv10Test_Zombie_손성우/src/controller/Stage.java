package controller;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.Attackable;
import models.Player;
import models.Zombie;

public class Stage implements Attackable{
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	Vector<Player> player = new Vector<>();
	Vector<Zombie> zombie = new Vector<>();
	Vector<Battle> battle = new Vector<>();
	
	boolean dead = true;
	int escape = 0;
	int upgrade = 1;
	int flower = 40;
	
	void gamestart() {
		System.out.println("== 좀비게임 ==");

		System.out.println("Player Name :");
		String name = scan.next();
		player.add(new Player(name));
		
		//sample Zombie add
		zombie.add(new Zombie("응애 좀비", 70, 70, 7, 4, 1));
		zombie.add(new Zombie("좀큰 좀비", 90, 90, 9, 6, 2));
		zombie.add(new Zombie("다큰 좀비", 110, 110, 10, 8, 3));
		zombie.add(new Zombie("장로 좀비", 130, 130, 13, 11, 4));
		
		play();
	}
	
	void play() {
		boolean run = true;
		while(run) {
			if(dead == false) {break;}
			if(flower == 1) {
				System.out.println("== 1층에 내려왔다. 탈출이다 ==");
				System.out.println("=== GAME CLEAR ===");
				dead = false;
				if(dead == false) {break;}
			}
			System.out.println("== SKY HOTEL ==");
			System.out.println("현재 층 :"+flower);
			System.out.println("\n[ "+player.get(0).getName()+" ] [체력 :"+player.get(0).getHP()+"]\n"
					+ "[공격력 :"+player.get(0).getPower()+"]  [방어력 :"+player.get(0).getDefence()+"]");
			System.out.println();
			System.out.println("1) 내려가기  2)강화 회복가능 수 :"+upgrade);
			int sel = scan.nextInt();
			
			if(sel == 1) {
				// 40층
				flower--;
				if(flower == 29) {player.get(0).setPos(1);}
				else if(flower == 19) {player.get(0).setPos(2);}
				else if(flower == 9) {player.get(0).setPos(3);}
				else if(flower == 5) {player.get(0).setPos(4);}
				upgrade = 1;
				down();
				}
			else if(sel == 2) {upgrade();}
		}	
	}
	
	void down() {
		int r1 = ran.nextInt(flower)+1;
		if(r1 % 2 == 0) {System.out.println("== 내려온 복도는 싸늘히 조용하다 ==");}
		else if(r1 % 2 == 1) {
			if(player.get(0).getPos() == 1) {
				battle.add(new Battle("응애 좀비", 70, 70, 7, 4, 1));
				battleGround();
			}
			else if(player.get(0).getPos() == 2) {
				battle.add(new Battle("좀큰 좀비", 90, 90, 9, 6, 2));
				battleGround();
			}
			else if(player.get(0).getPos() == 3) {
				battle.add(new Battle("다큰 좀비", 110, 110, 10, 8, 3));
				battleGround();
			}
			else if(player.get(0).getPos() == 4) {
				battle.add(new Battle("장로 좀비", 130, 130, 13, 11, 4));
				battleGround();
			}
		}
		
	}
	void upgrade() {
		if(upgrade == 1) {
			System.out.println("1) 장비 업그레이드  2) 회복");
			int sel = scan.nextInt();
			if(sel == 1) {
				int rw = ran.nextInt(10)+1;
				int ug = player.get(0).getPower();
				player.get(0).setPower(ug+rw);
				System.out.println("무기 공격력이 "+player.get(0).getPower()+"가 되었다.");
				upgrade = 0;
			}
			else if(sel == 2) {
				int rh = ran.nextInt(100)+1;
				if(player.get(0).getHP()+rh >= 100) {
					player.get(0).setHP(100);					
				}
				else {
					player.get(0).setHP(player.get(0).getHP()+rh);					
				}
				System.out.println("체력이 "+rh+" 만큼 회복되었다.");
				upgrade = 0;
			}
			else {System.out.println("== 입력정보오류 다시시도 ==");}
		}
		else if(upgrade == 0) {
			
		}
	}
	void battleGround() {
		while(true) {
			if(dead == false) {break;}
			System.out.println("== "+battle.get(0).getName()+"가 나타났다 ==");
			System.out.println("[ "+player.get(0).getName()+" ] [체력 :"+player.get(0).getHP()+"]\n"
					+ "[공격력 :"+player.get(0).getPower()+"]  [방어력 :"+player.get(0).getDefence()+"]");
			System.out.println();
			System.out.println("[ "+battle.get(0).getName()+" ] [체력 :"+battle.get(0).getHP()+"]\n"
					+ "[공격력 :"+battle.get(0).getPower()+"]  [방어력 :"+battle.get(0).getDefence()+"]");
			System.out.println("-----------------------------------------\n");
			System.out.println("1)공격  2)회복");
			int sel = scan.nextInt();
			if(sel == 1) {
				System.out.println(player.get(0).getName()+" 의 공격");
				System.out.println("슈슉");
				atZ(player.get(0).getPower());
				if(battle.get(0).getHP() >= 0) {
					System.out.println(battle.get(0).getName()+"가 달려들었다");
					System.out.println("꾸어어");
					atP(battle.get(0).getPower());
				}
			}
			else if(sel == 2) {
				int rh = ran.nextInt(100)+1;
				if(player.get(0).getHP()+rh >= 100) {
					player.get(0).setHP(100);					
				}
				else {
					player.get(0).setHP(+rh);					
				}
				System.out.println("체력이 "+rh+" 만큼 회복되었다.");
			}
		}	
	}
	@Override
	public void atP(int att) {
		// TODO Auto-generated method stub
		player.get(0).setHP(player.get(0).getHP()-att);
		if(player.get(0).getHP() <= 0) {
			System.out.println("== 좀비를 이기지 못하고 죽었다 ==");
			System.out.println("=== GAME OVER ===");
			/////////// 여기 게임 오버
			dead = false;
		}
		else {
			System.out.println("== "+att+"만큼의 데미지를 받았다 ==");
		}
	}
	@Override
	public void atZ(int att) {
		// TODO Auto-generated method stub
		battle.get(0).setHP(battle.get(0).getHP()-att);
		if(battle.get(0).getHP() <= 0) {
			System.out.println("== 좀비를 썰어버렸다 ==");
			battle.remove(0);
			play();
		}
		else {
			System.out.println("== "+att+"만큼의 데미지를 줬다 ==");
		}
	}
}

package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Character.Player;
import Character.Zombie;

public class Main {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		private Main() {}
		ArrayList<Zombie> enemy = new ArrayList<>();
		ArrayList<Player> player = new ArrayList<>();
		ArrayList<Battle> battle = new ArrayList<>();

		void sample() {
			
			// name, hp, attack, defence, pos
			player.add(new Player("VIP였던 인생", 100, 4, 5, 1));
			enemy.add(new Zombie("노멀좀비", 20, 3, 2, 1));
			enemy.add(new Zombie("쌘좀비", 30, 4, 2, 2));
			enemy.add(new Zombie("더 쌘좀비", 40, 5, 2, 3));
			enemy.add(new Zombie("라스보스 좀비", 50, 6, 2, 4));
		}
		int f = 40;
		int upgPoint = 1;
		void play() {
			boolean run  = true;
			while(run) {
				System.out.println("== Sky Hotal ==");
				System.out.println("1. 내려가기  2. 강화");
				String sel = scan.next();
				
				if(sel.equals(1)) {down();}
				else if(sel.equals(2)) {
					if(upgPoint == 1) {
						upgrade();
					}
					else if(upgPoint == 0) {System.out.println("== 업그레이드 포인트를 이미 소모했다 ==");}
				}
			}
		}
		void down() {
			int r = ran.nextInt();
			if(r % 2 == 1) {
				if(player.get(0).getPos()==1) {
					battle.add(new Battle(enemy.get(0).getName(), enemy.get(0).getHP(), 
							enemy.get(0).getAttack(), enemy.get(0).getDefence(), enemy.get(0).getPos()));
					nomal();
				}
				else if(player.get(0).getPos()==2) {					
					battle.add(new Battle(enemy.get(0).getName(), enemy.get(0).getHP(), 
							enemy.get(0).getAttack(), enemy.get(0).getDefence(), enemy.get(0).getPos()));
					strang();
				}
				else if(player.get(0).getPos()==3) {					
					battle.add(new Battle(enemy.get(0).getName(), enemy.get(0).getHP(), 
							enemy.get(0).getAttack(), enemy.get(0).getDefence(), enemy.get(0).getPos()));
					moreStrang();
				}
				else if(player.get(0).getPos()==4) {					
					battle.add(new Battle(enemy.get(0).getName(), enemy.get(0).getHP(), 
							enemy.get(0).getAttack(), enemy.get(0).getDefence(), enemy.get(0).getPos()));
					boss();
				}
			}
			else if(r % 2 == 0) {
				System.out.println("== "+player.get(0).getPlayer()+": 이번층은 안전하군.. ==");
				
			}
		}
		
		void upgrade() {
			boolean run = true;
			while(run) {
				System.out.println("1. 무기강화  2. hp치료  3. 뒤로가기");
				String sel = scan.next();
				
				if(sel.equals(1)) {}
				else if(sel.equals(2)) {}
				else if(sel.equals(3)) {}
				else {System.out.println("== 선택지오류 다시선택 ==");}
			}	
		}
		
		// 좀비 결투
		void nomal() {
			boolean run = true;
			while(run) {
				System.out.println("== "+battle.get(0).getName()+"가 다가왔다 ==");
				System.out.println(battle.get(0).getName()+"[HP : "+battle.get(0).getHP()+"]\n"
						+ "[공격력 : "+battle.get(0).getAttack()+"] [방어력 : "+battle.get(0).getDefence()+"");
				
				System.out.println("========== V S ==========");
				
				System.out.println(player.get(0).getPlayer()+"[HP : "+player.get(0).getHP()+"]\n"
						+ "[공격력 : "+player.get(0).getAttack()+"] [방어력 : "+player.get(0).getDefence()+"]");
				
				System.out.println(".........................");
				System.out.println("1. 공격  2. 회복약 사용(100%회복)");
				String sel = scan.next();
				if(sel.equals(1)) {attackZombie();}
				else if(sel.equals(2)) {heal();}
			}	
		}
		void strang() {
			
		}
		void moreStrang() {
			
		}
		void boss() {
			
		}
		
		
		// 결투
		// 공격
		void attackZombie(){
			System.out.println("== "+player.get(0).getPlayer()+"의 공격 ==");
			System.out.println("피슉 !");
			int zomHp = battle.get(0).getHP();
			zomHp -= player.get(0).getAttack();
			battle.get(0).setAttack(zomHp);
			System.out.println("== "+player.get(0).getAttack()+"의 데미지를 입혔다 ==");
			
		}
		// 회복약
		void heal(){
			player.get(0).setHP(100);
			System.out.println("== 회복약 사용 ==");
		}
}

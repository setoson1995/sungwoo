package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Damageable;
import model.Player;
import model.Zombie;


public class Main implements Damageable{
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	private Main() {}
	ArrayList<Zombie> enemy = new ArrayList<>();
	ArrayList<Player> player = new ArrayList<>();
	ArrayList<Battle> battle = new ArrayList<>();

	void sample() {		
//		name, hp, attack, defence, pos
//		player.add(new Player("VIP였던 인생", 100, 4, 5, 1));
		enemy.add(new Zombie("노멀좀비", 20, 3, 2, 1));
		enemy.add(new Zombie("쌘좀비", 30, 4, 2, 2));
		enemy.add(new Zombie("더 쌘좀비", 40, 5, 2, 3));
		enemy.add(new Zombie("라스보스 좀비", 50, 6, 2, 4));
		
		for(int i=0; i<enemy.size(); i++) {
			
		}
	}

	void play() {
		int f = 40;
		int upgPoint = 1;
		sample();
		for(int i=0; i<enemy.size(); i++) {
			System.out.println(enemy.get(i).getName());
		}
		System.out.println("=====");
		System.out.println("서바이버, 당신의 이름은? :");
		String name = scan.next();
		Player newPlayer = new Player(name);
		boolean run  = true;
		while(run) {
			System.out.println("== Sky Hotal ==");
			for(int i=0; i<player.size(); i++) {
				System.out.println(player.get(0).getName()+"[HP : "+player.get(0).getHp()+"]\n"
						+ "[공격력 : "+player.get(0).getAttack()+"] [방어력 : "+player.get(0).getDefence()+"]");	
			}
			
			System.out.println("현재 층: "+f);
			System.out.println("1. 내려가기  2. 강화");
			int sel = scan.nextInt();
			
			if(sel==1) {
				f--;
				if(f == 30) {player.get(0).setPos(2);}
				else if(f == 20) {player.get(0).setPos(3);}
				else if(f == 10) {player.get(0).setPos(4);}
				down();
			}
			else if(sel==2) {
				if(upgPoint == 1) {
					upgrade();
				}
				else if(upgPoint == 0) {System.out.println("== 업그레이드 포인트를 이미 소모했다 ==");}
			}
		}
	}
	
	// 내려가기
	void down() {
		int r = ran.nextInt(10)+1;
		// 여기에서 홀짝랜덤 좀비소환
		if(r % 2 == 1) {
			// 여기서 플레이어 포스레벨과 동일한 좀비 메치
			if(player.get(0).getPos()==1) {
				Battle newbattle = new Battle(enemy.get(0).getName(), enemy.get(0).getHP(), enemy.get(0).getHP(), 
						enemy.get(0).getAttack(), enemy.get(0).getDefence(), enemy.get(0).getPos());
				nomal();
			}
			else if(player.get(0).getPos()==2) {					
				battle.add(new Battle(enemy.get(1).getName(), enemy.get(1).getHP(), enemy.get(1).getHP(), 
						enemy.get(1).getAttack(), enemy.get(1).getDefence(), enemy.get(1).getPos()));
				strang();
			}
			else if(player.get(0).getPos()==3) {					
				battle.add(new Battle(enemy.get(2).getName(), enemy.get(2).getHP(), enemy.get(1).getHP(),
						enemy.get(2).getAttack(), enemy.get(2).getDefence(), enemy.get(2).getPos()));
				moreStrang();
			}
			else if(player.get(0).getPos()==4) {					
				battle.add(new Battle(enemy.get(3).getName(), enemy.get(3).getHP(), enemy.get(1).getHP(),
						enemy.get(3).getAttack(), enemy.get(3).getDefence(), enemy.get(3).getPos()));
				boss();
			}
		}
		else if(r % 2 == 0) {
			System.out.println("== "+player.get(0).getName()+": 이번층은 안전하군.. ==");
			
		}
	}
	
	// 강화 메뉴
	void upgrade() {
		boolean run = true;
		while(run) {
			System.out.println("1. 무기강화  2. hp치료  3. 뒤로가기");
			int sel = scan.nextInt();
			
			if(sel == 1) {weapon();}
			else if(sel == 2) {
				
			}
			else if(sel == 3) {break;}
			else {System.out.println("== 선택지오류 다시선택 ==");}
		}	
	}
	void weapon() {
		int r = ran.nextInt(25)+1;
		r += player.get(0).getAttack();
		player.get(0).setAttack(r);
		System.out.println("== 무기를 업그레이드했다 ==");
	}
	void upheal() {
		int r = ran.nextInt(50)+1;
		r += player.get(0).getHp();
		if(r >= 100) {
			player.get(0).setHp(100);
		}
		else {
		player.get(0).setHp(r);
		}
		System.out.println("== 회복되었습니다 ==");
	}
	
	// 좀비 결투
	void nomal() {
		boolean run = true;
		while(run) {
			System.out.println("== "+battle.get(0).getName()+"가 다가왔다 ==");
			System.out.println(battle.get(0).getName()+"[HP : "+battle.get(0).getHp()+"]\n"
					+ "[공격력 : "+battle.get(0).getAttack()+"] [방어력 : "+battle.get(0).getDefence()+"");
			
			System.out.println("========== V S ==========");
			
			System.out.println(player.get(0).getName()+"[HP : "+player.get(0).getHp()+"]\n"
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
		System.out.println("== "+player.get(0).getName()+"의 공격 ==");
		System.out.println("피슉 !");
		((Damageable) battle).damage(player.get(0).getAttack());
		System.out.println("== "+player.get(0).getAttack()+"의 데미지를 입혔다 ==");
		
		System.out.println("=== 좀비가 달려든다 ===");
		
		System.out.println("== "+battle.get(0).getName()+"의 공격 ==");
		System.out.println("끄어억어 !");
		((Damageable) player).damage(battle.get(0).getAttack());		
	}
	// 회복약
	void heal(){
		player.get(0).setHp(100);
		System.out.println("== 회복약 사용 ==");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.play();
	}

	@Override
	public void damage(int att) {
		// TODO Auto-generated method stub
		
	}

}

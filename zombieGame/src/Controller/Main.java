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

	static int f;
	static int upgPoint;
	static int dead = 0;
	static int escape = 0;
	
	void sample() {		
//		name, hp, attack, defence, pos
//		player.add(new Player("VIP였던 인생", 100, 4, 5, 1));
		enemy.add(new Zombie("노멀좀비", 100, 3, 2, 1));
		enemy.add(new Zombie("쌘좀비", 120, 4, 2, 2));
		enemy.add(new Zombie("더 쌘좀비", 140, 5, 2, 3));
		enemy.add(new Zombie("라스보스 좀비", 160, 6, 2, 4));
	}
	
	void setting() {
		f = 40;
		upgPoint = 1;

		for(int i=0; i<enemy.size(); i++) {
			System.out.println(enemy.get(i).getName());
		}
		System.out.println("=====");
		System.out.println("서바이버, 당신의 이름은? :");
		String name = scan.next();
		Player newPlayer = new Player(name, 100, 100, 7, 5, 1);
		this.player.add(newPlayer);
	}
	void play() {
		if(dead == 1) {
			System.out.println("=== The End ===");
		}
		else if(dead == 0) {
			boolean run  = true;
			while(run) {
				System.out.println("== Sky Hotal ==");
				System.out.println();
				for(int i=0; i<player.size(); i++) {
					System.out.println("{ 이름 :"+player.get(i).getName()+" } [HP : "+player.get(i).getHp()+"]\n"
							+ "[공격력 : "+player.get(i).getAttack()+"] [방어력 : "+player.get(i).getDefence()+"]");	
				}
				System.out.println("=====");
				System.out.println("현재 층: "+f+" / 강화포인트: "+upgPoint);
				System.out.println("== 강화포인트는 층마다 한개뿐 ==");
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
					else if(upgPoint == 0) {
						System.out.println("== 업그레이드 포인트를 이미 소모했다 ==");
						System.out.println();
						System.out.println();
						}
				}
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
				this.battle.add(newbattle);
				System.out.println("== "+battle.get(0).getName()+"가 다가왔다 ==");
				battleRound();
			}
			else if(player.get(0).getPos()==2) {					
				Battle newbattle = new Battle(enemy.get(1).getName(), enemy.get(1).getHP(), enemy.get(1).getHP(), 
						enemy.get(1).getAttack(), enemy.get(1).getDefence(), enemy.get(1).getPos());
				this.battle.add(newbattle);
				System.out.println("== "+battle.get(1).getName()+"가 다가왔다 ==");
				battleRound();
			}
			else if(player.get(0).getPos()==3) {
				Battle newbattle = new Battle(enemy.get(2).getName(), enemy.get(2).getHP(), enemy.get(2).getHP(), 
					enemy.get(2).getAttack(), enemy.get(2).getDefence(), enemy.get(2).getPos());
			this.battle.add(newbattle);
			System.out.println("== "+battle.get(2).getName()+"가 다가왔다 ==");
			battleRound();
			}
			else if(player.get(0).getPos()==4) {					
				Battle newbattle = new Battle(enemy.get(3).getName(), enemy.get(3).getHP(), enemy.get(3).getHP(), 
						enemy.get(3).getAttack(), enemy.get(3).getDefence(), enemy.get(3).getPos());
				this.battle.add(newbattle);
				System.out.println("== "+battle.get(3).getName()+"가 다가왔다 ==");
				battleRound();
			}
		}
		else if(r % 2 == 0) {
			System.out.println("== "+player.get(0).getName()+": 이번층은 안전하군.. ==");
			
		}
		upgPoint = 1;
	}
	
	// 강화 메뉴
	void upgrade() {
		boolean run = true;
		while(run) {
			System.out.println("1. 무기강화  2. hp치료  3. 뒤로가기");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				weapon();
				break;
				}
			else if(sel == 2) {
				heal();
				break;
			}
			else if(sel == 3) {break;}
			else {System.out.println("== 선택지오류 다시선택 ==");}
		}	
	}
	void weapon() {
		int r = ran.nextInt(10)+1;
		System.out.println("== 무기의 성능 +"+r+" ==");
		System.out.println();
		System.out.println();
		r += player.get(0).getAttack();
		player.get(0).setAttack(r);
		f = 0;
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
		f = 0;
		System.out.println("== 회복되었습니다 ==");
		System.out.println();
		System.out.println();
		play();
	}
	
	// 좀비 결투
	void battleRound() {
		boolean run = true;
		while(run) {
			System.out.println("=========================");
			System.out.println("=========================");
			System.out.println(battle.get(0).getName()+"[HP : "+battle.get(0).getHp()+"]\n"
					+ "[공격력 : "+battle.get(0).getAttack()+"] [방어력 : "+battle.get(0).getDefence()+"");
			
			System.out.println("========== V S ==========");
			
			System.out.println(player.get(0).getName()+"[HP : "+player.get(0).getHp()+"]\n"
					+ "[공격력 : "+player.get(0).getAttack()+"] [방어력 : "+player.get(0).getDefence()+"]");
			
			System.out.println(".........................");
			System.out.println("1. 공격  2. 회복약 사용(100%회복)");
			int sel = scan.nextInt();
			if(sel == 1) {attack();}
			else if(sel == 2) {heal();}
		}	
	}
	
	
	// 결투
	// 공격
	void attack(){
		System.out.println("== "+player.get(0).getName()+"의 공격 ==");
		System.out.println("피슉 !");
//		((Damageable) battle).damage(player.get(0).getAttack()); 이건 뭘 의미하는걸까
		damageZ(player.get(0).getAttack());
		
		
		System.out.println("=== 좀비가 달려든다 ===");
		
		
		System.out.println("== "+battle.get(0).getName()+"의 공격 ==");
		System.out.println("끄어억어 !");
		damageP(battle.get(0).getAttack());
	}
	
	// 회복약
	void heal(){
		player.get(0).setHp(100);
		System.out.println("== 회복약 사용 ==");
	}
	

	@Override
	public void damageP(int att) {
		// TODO Auto-generated method stub
		 player.get(0).setHp(player.get(0).getHp() - att);
			if(player.get(0).getHp() <= 0) {
				System.out.println("== "+player.get(0).getName()+"을 내장이 쏫아졌다 ==");
				youAreDead();
			}
		else {
			System.out.println("== "+att+"의 데미지를 받았다 ==");
		}
	}
	@Override
	public void damageZ(int att) {
		// TODO Auto-generated method stub
		 battle.get(0).setHp(battle.get(0).getHp() - att);
		if(battle.get(0).getHp() <= 0) {
			System.out.println("== "+battle.get(0).getName()+"을 으깨버렸다 ==");
			battle.remove(0);
			play();
		}
			else {
				System.out.println("== "+att+"의 데미지를 줬다 ==");
			}
	}
	
	void youAreDead() {
		System.out.println("== 좀비에게 내장을 파먹혀 죽었다 ==");
		dead = 1;
		play();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.sample();
		m.setting();
		m.play();
	}

}

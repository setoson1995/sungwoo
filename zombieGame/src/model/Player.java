package model;

public class Player implements Damageable{
	boolean isdead;
	String Name;
	final int MAX_HP = 100;
	int HP = MAX_HP;
	int Attack = 5;
	int Defence = 5;
	int Pos = 1;
	
	
	public Player(String name){
		this.Name = name;
		
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getMAX_HP() {
		return MAX_HP;
	}
//	public void setMAX_HP(int hP) {
//		MAX_HP = hP;
//	}
	public int getHp() {
		return HP;
	}
	public void setHp(int hp) {
		HP = hp;
	}
	public int getAttack() {
		return Attack;
	}
	public void setAttack(int attack) {
		Attack = attack;
	}
	public int getDefence() {
		return Defence;
	}
	public void setDefence(int defence) {
		Defence = defence;
	}
	public int getPos() {
		return Pos;
	}
	public void setPos(int pos) {
		Pos = pos;
	}
	void print() {
		System.out.println(this.Name+"[HP : "+this.HP+"]\n"
				+ "[공격력 : "+this.Attack+"] [방어력 : "+this.Defence+"]");
	}
	@Override
	public void damage(int att) {
		// TODO Auto-generated method stub
		this.HP -= att;
		if(this.HP <= 0) {
			isdead = true;
			System.out.println("== "+this.Name+"은 결국 탈출에 실패하고 좀비밥 (좁밥)이 되었다 ==");
		}
		else {
			System.out.println("== ("+att+"의 데미지) 너무 아프다 ==");
		}
	}
}

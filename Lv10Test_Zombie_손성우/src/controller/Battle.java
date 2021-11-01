package controller;

public class Battle {
	String name;
	int MAX_HP;
	int HP;
	int Power;
	int defence;
	int pos;
	public Battle(String name, int max_hp, int hp, int power, int defence, int pos){
		this.name = name;
		this.MAX_HP = max_hp;
		this.HP = hp;
		this.Power = power;
		this.defence = defence;
		this.pos = pos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMAX_HP() {
		return MAX_HP;
	}
	public void setMAX_HP(int mAX_HP) {
		MAX_HP = mAX_HP;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getPower() {
		return Power;
	}
	public void setPower(int power) {
		Power = power;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}	
}

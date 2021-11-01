package models;

public class Player {
	String name;
	final int MAX_HP = 100;
	int HP = 100;
	int Power = 10;
	int defence = 10;
	int pos = 1;
	public Player(String name){
		this.name = name;
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
	// set MAX_HP 지운자리
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

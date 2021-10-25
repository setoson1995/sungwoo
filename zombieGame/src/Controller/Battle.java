package Controller;

public class Battle {
	String Name;
	int HP;
	int Attack;
	int Defence;
	int Pos;
	
	
	public Battle(String name, int hp, int attack, int defence, int pos){
		this.Name = name;
		this.HP = hp;
		this.Attack = attack;
		this.Defence = defence;
		this.Pos = pos;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
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
}

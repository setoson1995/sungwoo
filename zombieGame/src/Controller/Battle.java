package Controller;

public class Battle implements Damageable{
	boolean isdead;
	String Name;
	final int MAX_HP;
	int HP;
	int Attack;
	int Defence;
	int Pos;
	
	
	public Battle(String name, int maxhp, int hp, int attack, int defence, int pos){
		this.Name = name;
		this.MAX_HP = maxhp;
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
	@Override
	public void damage(int att) {
		// TODO Auto-generated method stub
		this.HP -= att;
		if(this.HP <= 0) {
			isdead = true;
			System.out.println("== "+this.Name+"을 으깨버렸다 ==");
		}
		else {
			System.out.println("== "+att+"의 데미지를 줬다 ==");
		}
	}
}

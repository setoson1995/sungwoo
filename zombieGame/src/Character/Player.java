package Character;

public class Player {
	String Player;
	int HP;
	int Attack;
	int Defence;
	int Pos;
	
	public Player(String name, int hp, int attack, int defence, int pos){
		this.Player = name;
		this.HP = hp;
		this.Attack = attack;
		this.Defence = defence; 
	}
	
	public String getPlayer() {
		return Player;
	}
	public void setPlayer(String player) {
		Player = player;
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

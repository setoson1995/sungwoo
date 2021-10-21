package character;

public class Unit {
	public String name;
	public int level;
	int hp; // 공격받은
	int maxHp; // 풀피
	int attack;
	int defence;
	int experience;
	public boolean party;
	Item weapon;
	Item armor;
	Item ring;
	
	// 
	public Unit(String name, int level, int physicalStrength, 
			int attack, int defence, int experience) {
		this.name = name;	this.level = level;
		this.maxHp = physicalStrength;   this.attack = attack;
		this.defence = defence;   this.experience = experience;
		
		this.party = false;   this.weapon = null;
		this.armor = null;   this.ring = null;
	}
	
}

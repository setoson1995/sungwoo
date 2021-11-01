package Model;

public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "노말";
	Unit(){}; // 이건 뭐지?
	Unit(String name, int max, int pw){
		this.name = name;
		this.maxhp = max;
		this.curhp = max;
		this.power = pw;
	}; // 여기 마지막엔 ;을 왜한거지?
	public void init(int max, int pw) {
		this.maxhp = max;
		this.curhp = max;
		this.power = pw;
	};
	void init(String name, int max, int pw) {
		this.name = name;
		this.maxhp = max;
		this.curhp = max;
		this.power = pw;
	};
	void attack(Unit target) {
		target.curhp -= this.power;
		System.out.println("["+this.name+"]이  ["+ target.name +"] 에게 "
				+ this.power+"의 데미지를 입힙니다");
		if(target.curhp <= 0) {
			System.out.println("["+target.name+"] 을 처치했습니다");
			target.curhp = 0;
		}
	}
	void printdata() {
		System.out.println("[" + this.name + "] [" + this.curhp + " / " + this.maxhp + "] [" + this.power + "]");
	}
}

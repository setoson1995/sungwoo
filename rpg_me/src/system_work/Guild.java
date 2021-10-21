package system_work;

import java.util.ArrayList;

import character.Player;
import character.Unit;
import gameManager.Main;

public class Guild {
	final int PARTY_SIZE = 4;
	ArrayList<Unit> guildList= new ArrayList<>();
	Unit [] partyList;
	
	// 길드 메인메뉴
	public void guildMain() {
		while(true) {
			System.out.println("=== Guild Menu ===");
			System.out.println("[1) 현재보유용병목록]  [2) 랜덤용병고용(G 500)]  [3) 보유용병삭제]\n"
					+ "[4) 파티용병교체]  [5) 정렬]  [6) 뒤로가기]");
			int storeSel = Main.scan.nextInt();
			
			if(storeSel == 1) {printUnitList();}
			else if(storeSel ==2) {buyRandomUnit();}
			else if(storeSel ==3) {removeUnit();}
			else if(storeSel ==4) {changeUnit();}
			else if(storeSel ==5) {sorting();}
			else if(storeSel ==6) {break;}
		}		
	}
	
	
	// 1) 현재보유용병목록
	void printUnitList() {
		System.out.println("======[ 현재보유용병 ]====");
		for(int i=0; i<guildList.size(); i++) {
			System.out.println("["+(i+1)+"]"+" [이름 : "+guildList.get(i)+"]\n"
					+ " [레벨 : "+guildList.get(i)+"] [체력 : "+guildList.get(i)+"]\n"
							+ " [공격 : "+guildList.get(i)+"] [방어 : "+guildList.get(i)+"]\n"
									+ "파티상태 : "+guildList.get(i));
			System.out.println("--------------------");
		}
		System.out.println("====================");
	}
	
	
	// 2) 랜덤용병고용(G 500)
	void buyRandomUnit() {
		if(Player.money < 500) {
			// 랜덤이름생성
			String[] n1 = {"가"+"나"+"다"+"라"+"마"+"바"+"사"};
			String[] n2 = {"아"+"야"+"어"+"여"+"우"+"유"+"으"+"이"};
			String[] n3 = {"가"+"나"+"다"+"라"+"마"+"바"+"사"};
			String name = n1[Main.ran.nextInt(n1.length)];
			name += n2[Main.ran.nextInt(n2.length)];
			name += n3[Main.ran.nextInt(n3.length)];
			
			int r1 = Main.ran.nextInt(10)+1;
			int r2 = Main.ran.nextInt(10)+1;
			int hp = r1 * r2;
			int attack = r1 + r2; 
			int defence = r1+r2/2;
			// 이름 레벨 체력 방어 경험치
			Unit buyUnit = new Unit(name, 1, hp, attack, defence, 0);
			
			System.out.println("== New Unit ==");
			System.out.println("[이름 : "+name+"] [레벨 : "+1+"]\n"
					+ "[체력 : "+hp+"]\n"
							+ "[공격력 : "+attack+"] [방어력 : "+defence+"]");
			System.out.println("==============");
			
			// try부분 이해못했음
		}
	}
	
	
	// 3) 보유용병삭제
	void  removeUnit() {
		// 먼저 보유 용병리스트 프린트
		printUnitList();
		System.out.println("1~ 처분할 용병 N :");
		int delUnit = Main.scan.nextInt(); // 여기도 -1해서 0을 안적어도 되게 가능
		
		if(guildList.get(delUnit - 1).party) { // 여기서 -1은 위에 스캔에서의 설명 참조
			System.out.println("=== 현재 파티중입니다 ===");
		}
		else {
			guildList.remove(delUnit -1);
			System.out.println("=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("[ "+guildList.get(delUnit - 1).name+""+guildList.get(delUnit - 1).level+" ]");
			System.out.println("== 처분했다 ==");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=");
			
		}
		// try부분 이해못했음
	}
	
	
	// 4) 파티용병교체
	void changeUnit() {
		// 현재파티중인 애들 프린트하고
		
	}
	// 프린트 (파티중인 애들만)
	void printOnlyParty() {
		for(int i=0; i<guildList.size(); i++) {
			
		}
	}
	// 프린트 (파티중 제외하고 나머지)
	void printWithOutParty() {
		for(int i=0; i<guildList.size(); i++) {
			
		}
	}
	
	
	// 5) 정렬 (1. 레벨 높은 순 낮은 순 2. 공격력 높은 순 낮은 순
	void sorting() {
		System.out.println("1)레벨높은순\n2)레벨낮은순\n3)공격력높은순\n4)공격력낮은순");
		int sortSel = Main.scan.nextInt();
		
		if(sortSel == 1) {}
		else if(sortSel == 2) {}
		else if(sortSel == 3) {}
		else if(sortSel == 4) {}
		else {System.out.println("=== 입력값 오류 ===");}
	}
	

	
}

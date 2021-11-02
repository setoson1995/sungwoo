package controller;
//시작 18 : 07
//종료 23 : 00
//소요 04 : 07
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
		boolean run = true;
		while(run) {
			run = stage.dead;
			if(run == true) {stage.gamestart();}		
		}
		
		// 내생각엔 추상클레스 abstract는 그룹,분류,
		// ㄴ공통사용하는 변수명을 등록?하는것
		
		// 인터페이스 interface는 스킬같이 
		// ㄴ특징적으로 움직이는 부분의 코드를 따로 분류하기 위해? 사용
	}

}

package controller;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
		boolean run = true;
		while(run) {
			run = stage.dead;
			if(run == true) {stage.gamestart();}		
		}
	}

}

package basic;

// Thread

class PlayGame extends Thread implements {
	
	public boolean play;
	
	public PlayGame() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(play) {
			System.out.println("신나게 게임하는 중 >>");
			try {
				sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}	
	}
}

class playMusic implements Runnable{

	public boolean play;

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		play = true;
		while(play) {
			System.out.println("음악이 흐르고...");
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}

public class ex02_00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		PlayGame play = new PlayGame();
////		play.run();
//		play.start();
//		
//		int n=0;
//		for(int i=0; i<10; i++) {
//			System.out.println("n : "+ n);
//			
//			if(n == 8) {
//				System.out.println("앗, 엄마가 두두등장");
////				play.stop();
//				play.paly = false; // play.stop();
//			}
//			
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
		
//		playMusic que = new playMusic();
//		que.run();
		
		Runnable music = new playMusic();
		Thread thread = new Thread(music);
 		thread.start();
 		
 		for(int n=0; n<10; n++) {
 			System.out.println("n : "+ n);
 			
 			if(n == 7) {
 				System.out.println("선생님 등장");
 				
 				// ? stop() 쓰지않고 -> 스레드 종료
 				// music 이 playMusic으로 형변환이 가능하면 true
 				if(music instanceof playMusic) { 
 					playMusic stop = (playMusic)music;
 					stop.play = false;
 				}	
 			}
 			
 			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
 		}
	}

}

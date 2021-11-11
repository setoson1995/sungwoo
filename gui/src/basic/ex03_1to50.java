package basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class AlertResult extends JFrame {

	private JLabel text = new JLabel();

	// 결과값창
	public AlertResult(int ms) {
		// TODO Auto-generated constructor stub
		super("Game Clear");
		setLayout(null);
		setBounds(100, 100, 300, 200);

		this.text.setText(String.format("성적 : %5d.%3d 소요", ms / 1000, ms % 1000));
		this.text.setBounds(0, 0, 300, 200);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
		
		setVisible(true);
	}
}

class GamePanel extends JPanel implements ActionListener, Runnable {

	private JLabel title = new JLabel("1 to 50");
	private JLabel timer = new JLabel("Ready");
	private int ms;
	private boolean isrun;

	private final int SIZE = 5;
	private JButton[][] map = new JButton[SIZE][SIZE];
	private int[][] front = new int[SIZE][SIZE];
	private int[][] back = new int[SIZE][SIZE];

	private JButton reset = new JButton();

	private int gameNum = 1;

	private Color background = new Color(246, 234, 190);
	private Color frontC = new Color(200, 227, 212);
	private Color backC = new Color(135, 170, 170);

	public GamePanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0, 0, 700, 800);

		setTitle();
		setTimer();

		setData();
		setMap();

		setResetButton();

	}

	private void setResetButton() {
		// TODO Auto-generated method stub
		this.reset.setText("Reset");
		this.reset.setBounds(700 / 2 - 100 / 2, 800 - 150, 100, 50);
		this.reset.addActionListener(this);
		add(this.reset);
	}

	private void setTimer() {
		// TODO Auto-generated method stub
		this.timer.setBounds(20, 0, 200, 50);
		this.timer.setBackground(Color.green); //
		this.timer.setHorizontalAlignment(JLabel.LEFT);

		add(this.timer);
	}

	private void setTitle() {
		// TODO Auto-generated method stub
		this.title.setBounds(0, 0, 700, 100);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setFont(new Font("THEJung170", Font.BOLD, 30));
		add(this.title);
	}

	private void setData() {
		// TODO Auto-generated method stub
		int n = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.front[i][j] = n;
				this.back[i][j] = n + SIZE * SIZE;
				n++;
			}
		} ///// 수
		shuffle();
	}

	private void shuffle() { ////// 검
//		// TODO Auto-generated method stub
//		Random ran = new Random();
//
//		for (int i = 0; i < 1000; i++) {
//			// front
//			int r1 = ran.nextInt(SIZE);
//			int r2 = ran.nextInt(SIZE);
//
//			int temp = this.front[0][0];
//			this.front[0][0] = this.front[r1][r2];
//			this.front[r1][r2] = temp;
//
//			// back
//			r1 = ran.nextInt(SIZE);
//			r2 = ran.nextInt(SIZE);
//
//			temp = this.front[0][0];
//			this.front[0][0] = this.front[r1][r2];
//			this.front[r1][r2] = temp;
//		}
	}

	private void setMap() {
		// TODO Auto-generated method stub
		int x = 700 / 2 - 100 * SIZE / 2; // 처음 위치조정
		int y = 700 / 2 - 100 * SIZE / 2 + 50;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.map[i][j] = new JButton();
				// 버튼의 속성 설정
				this.map[i][j].setBounds(x, y, 100, 100);
				this.map[i][j].setText(this.front[i][j] + "");
				this.map[i][j].setFont(new Font("THEJung170", Font.PLAIN, 20));
				this.map[i][j].setForeground(Color.white);
				this.map[i][j].setBackground(this.frontC);
				this.map[i][j].addActionListener(this);
				
//				// on mac
//				this.map[i][j].setOpaque(true);
//				this.map[i][j].setBorderPainted(false);
				


				add(this.map[i][j]);

				x += 100 + 3; // 이 숫자들의 계 만큼 옆으로
			}
			x = 700 / 2 - 100 * SIZE / 2; // 다시 원래자리로
			y += 100 + 3; // 이 숫자들의 계 만큼 밑으로
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JButton) { // 여기 부분에서 하나만 타겟설정
			JButton target = (JButton) e.getSource();

			if (target == this.reset) {
				System.out.println("reset");
				resetGame();
			} 
			else {
				for (int i = 0; i < SIZE; i++) {
					for (int j = 0; j < SIZE; j++) {
						if (target == this.map[i][j] && this.front[i][j] == this.gameNum) {
							// start Timer
							if (!isrun) {
								isrun = true;
							}
							
							// back -> front
							// gameNum

							this.front[i][j] = this.back[i][j];
							this.back[i][j] = 0;

							if (this.front[i][j] == 0) {
								this.map[i][j].setBackground(this.background);
								this.map[i][j].setText("");
							} else {
								this.map[i][j].setBackground(this.backC);
								this.map[i][j].setText(this.front[i][j] + "");
							}

							this.gameNum++;

							isrun = winCheck();
							if (!isrun) {
								new AlertResult(this.ms); // 성적(me)출력
							}
						}
					}
				}
			}

		}
	}

	private void resetGame() {
		// TODO Auto-generated method stub
		this.gameNum = 1; //!!!!!!!!!!!!!!!!!!!!!!!!
		
		isrun = false;
		this.ms = 0;
		this.timer.setText("Ready");

		setData();

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.map[i][j].setText(this.front[i][j] + "");
				this.map[i][j].setBackground(this.frontC);
			}
		}

	}

	private boolean winCheck() {
		// TODO Auto-generated method stub
		boolean check = false;
//		for(int i=0; i<SIZE; i++) {
//			for(int j=0; j<SIZE; j++) {
//				if(this.front[i][j] != 0) {
//					check = true;
//				}
//			}
//		}
//		return check;
		if (this.gameNum > SIZE * SIZE * 2) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void run() {
		while (true) {
			if (isrun) {
				this.ms++;
				this.timer.setText(String.format("%5d.%3d", this.ms / 1000, this.ms % 1000));
			}

			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

class Game extends JFrame {

	private GamePanel panel = new GamePanel(); // <- runnable 생성

	public Game() {
		super("One to Fifty");
		setLayout(null);
		setBounds(50, 50, 700, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(panel);

		setVisible(true);
		revalidate();

		panel.run(); // 생성된 runnable의 run()메서드를 호출, 프레인 띄운 후 -> 스레드가동
	}
}

public class ex03_1to50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g = new Game();
	}

}

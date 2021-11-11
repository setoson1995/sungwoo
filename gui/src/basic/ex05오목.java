package basic;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 오목게임 (JButton)
// 10*10
// p1, p2

class ButtonPanel extends JPanel{
	public JButton reset = new JButton();
	
	public ButtonPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0,0,Frame.SIZE,Frame.SIZE);
		
		setResetButton();
	}

	private void setResetButton() {
		// TODO Auto-generated method stub
		this.reset.setText("RESET");
		this.reset.setFont(new Font("", Font.PLAIN, 50));
		this.reset.setBounds(Frame.SIZE/2-150,Frame.SIZE/2-150,300,300);
		add(this.reset);
	}
}

class Frame extends JFrame{
	
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int W = dm.width;
	public static final int H = dm.height;
	
	public static final int SIZE = 700;
	
	private OmakPanel panel = new OmakPanel();	
	
	public Frame() {
		// TODO Auto-generated constructor stub

		super("OMOK"); // setTitle(String str)
		
		setLayout(null);
		setBounds(W/2-SIZE/2, H/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		
		setVisible(true);
		revalidate();
	}
}

class OmakPanel extends JPanel implements ActionListener{
	
	private JLabel text = new JLabel("Omok Game");
	
	private final int SIZE = 10;
	private JButton[][] map = new JButton[SIZE][SIZE];
	private int[][] mark = new int[SIZE][SIZE];
	
	private int turn = 1;
	private int win;
	
	private ButtonPanel reset = new ButtonPanel();
	
	public OmakPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0,0,Frame.SIZE,Frame.SIZE);
//		setBackground(Color.orange);
		
		// add(추가할컴포넌트, 0)
		// 0 ... 우선순위 설정
		
		// add하는 순서대로 컴포넌트의 우선순위가 top부터 정해짐.
		this.reset.reset.addActionListener(this);
		add(this.reset);
		this.reset.setVisible(false);
		
		setTitle();
		setMap();
	}

	private void setTitle() {
		// TODO Auto-generated method stub
		this.text.setBounds(0,0,Frame.SIZE,100);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		this.text.setFont(new Font("",Font.BOLD,30));
		add(this.text);
	}
	
	private void setMap() {
		// TODO Auto-generated method stub
		int x = Frame.SIZE/2-50*10/2;
		int y = Frame.SIZE/2-50*10/2;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				// 버튼 생성
				JButton bt = new JButton();
				
				// 버튼 크기설정 ///검수
				bt.setBounds(x,y,50,50); // 좌표 x, 좌표 y, 버튼의 가로크기, 세로크기
				// 색
				bt.setBackground(Color.lightGray);
				bt.setOpaque(true);
				bt.setBorderPainted(false);
				
				// 이벤트 리스너 달기
				// JButton : ActionLister <- 인터페이스로 제공
				bt.addActionListener(this); // this : bt <- 이벤트발생 시
				
				this.map[i][j] = bt;
				
				// 현재 페널(this)에 버튼 달기
				add(this.map[i][j]); // add(bt)
				
				// 다음 버튼을 위한 좌표 설정
				x += 10+1;
		
			}
			x = Frame.SIZE/2-50*10/2;
			y += 50 +1;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.reset.reset) {
				resetGame();
				System.out.println("reset");
			}
			else {
				// 맵 안에 있는 버튼이 맞는지
				// 어떤 버튼인지
				// turn에 따라서 -> marking
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
						if(target == this.map[i][j] && this.mark[i][j] == 0) { // 아직 마킹안된지 확인
							if(this.turn == 1) {
								target.setBackground(Color.red);
							}
							else {
								target.setBackground(Color.blue);
							}

							this.mark[i][j] = this.turn; //마킹하고
							checkWin();					 //감사
							
							this.turn = this.turn == 1 ? 2 : 1;
							
						}
					}
				}				
			}
	
		}
	}
	private void resetGame() {
		this.mark = new int [SIZE][SIZE];
		this.turn = 1;
		this.win = 0;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j].setBackground(Color.LIGHT_GRAY);
			}
		}
		
		this.remove(this.reset);
		this.revalidate();
		this.repaint();
	}
	private void checkWin() {
		// TODO Auto-generated method stub
		this.win = this.win == 0 ? checkHori() :this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checkDia() : this.win;
		this.win = this.win == 0 ? checkReverse() : this.win;
		
		if(this.win != 0) {
			add(this.reset); // 게임이 클리어 되면 -> 리셋버튼 등장
			new Result(String.format("p%d win !", this.win));
		}
	}
	private int checkReverse() {
		// TODO Auto-generated method stub
		for(int i=4; i<SIZE; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k =0; k<5; k++) {
						if(this.mark[i-k][j+k] == this.turn) {
							cnt++;
						}
						if(cnt == 5) {
							return this.turn;
						}
					}
				}
			}
		}	
		return 0;
	}
	private int checkDia() {
		// TODO Auto-generated method stub
		for(int i=0; i<SIZE-4; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j+k] == this.turn) {
							cnt++;
						}
						if(cnt == 5) {
							return this.turn;
						}
					}
				}
			}
		}	
		return 0;
	}
	private int checkVerti() {
		// TODO Auto-generated method stub
		for(int i=0; i<SIZE-4; i++) {
			for(int j=0; j<SIZE; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j] == this.turn) {
							cnt++;
						}
						if(cnt == 5) {
							return this.turn;
						}
					}
				}
			}
		}	
		return 0;
	}
	private int checkHori() {
		// TODO Auto-generated method stub
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE-4; j++) {
				int cnt = 0;
				if(this.mark[i][j] == this.turn) {
					for(int k=0; k<5; k++) {
						if(this.mark[i][j+k] == this.turn) {
							cnt++;
						}
						if(cnt == 5) {
							return this.turn;
						}
					}
				}
			}
		}
		return 0;
	}
	
}

class Result extends JFrame{
	
	private JLabel text = new JLabel();
	
	public Result(String str) {
		// TODO Auto-generated constructor stub
		super("Game Over");
		setBounds(Frame.W/2-150,Frame.H/2-100,300,200);
		
		text.setText(str);
		text.setBounds(0,0,300,200);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		
		setVisible(true);
		revalidate();
	}
}


public class ex05오목 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame game = new Frame();
		
		
//		bounds 사이즈 이해불가
//		JPanel
//		JLabel
	}

}

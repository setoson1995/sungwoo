package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//gui 예제
//TIC TAC TOE 만들기
//ㄴ 버튼 9개를 가진 배열 활용
//ㄴ 마킹용 int[] 배열 활용
//ㄴ 턴에 따라 버튼의 색이 다르게 지정됨
class ResultFrame extends JFrame{
	
	private JLabel text = new JLabel();
	
	// 300 * 200
	public ResultFrame(String winText) {
		super("Game Clear");
		setLayout(null);
		setBounds(TicFrame.width/2-300/2, TicFrame.height/2-200/2,300,200);
		
		text.setBounds(0,0,300,200);
		text.setText(winText);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		
		setVisible(true);
		revalidate();
	}
}

// 게임
class TicGame extends JPanel implements ActionListener{
	
	private JButton[] map = new JButton[9];
	private int[] mark = new int[9]; // 이건 뭐지?
	
	private int turn = 1;
	private int win;
	
	private JLabel title = new JLabel("프로그램 안에 표시되는 글"); //이건셋타이틀 메서드에 있으면안되는건가? 따로있어서든생각
	private JButton reset = new JButton("ReStart");
	
	public TicGame() { // 여기코드 뭐임?
		setLayout(null);
		setBounds(0,0,TicFrame.SIZE,TicFrame.SIZE);
		
		setTitle();
		setMap();
		setResetButton();
	}
	
	private void setTitle() {
		// TODO Auto-generated method stub
		this.title.setBounds(0,0,TicFrame.SIZE,150);
		this.title.setFont(new Font("여기폰트이름복붙", Font.BOLD, 40));
		this.title.setHorizontalAlignment(JLabel.CENTER); // =수평정렬
		this.title.setVerticalAlignment(JLabel.BOTTOM); // =수직정렬
		
		add(this.title);
	}

	private void setResetButton() {
		// TODO Auto-generated method stub
		this.reset.setBounds(TicFrame.SIZE/2-50, TicFrame.SIZE-150, 100, 50);
		this.reset.addActionListener(this); // 왜 this인거야??
		add(this.reset);
	}

	private void setMap() {
		// TODO Auto-generated method stub
		int x = TicFrame.SIZE/2-100*3/2;
		int y = TicFrame.SIZE/2-100*3/2;
		
		for(int i=0; i<this.map.length; i++) {
			this.map[i] = new JButton(); // 뭐지?
			this.map[i].setBounds(x,y,100,100); //map배열수 만큼 만들기?
			
			// 버튼색
			this.map[i].setBackground(new Color(136, 224, 239));
			
			this.map[i].addActionListener(this); // 이건뭐지?
			add(this.map[i]); // 이건뭐지?
			
			x += 100 + 3; // 뭐지??
			if(i % 3 ==2) { // 뭐지??
				x = TicFrame.SIZE/2-100*3/2;
				y += 100 +3;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 뭐를 위한 코드?
		// TODO Auto-generated method stub
		JButton target = (JButton) e.getSource(); // 겟소스는 뭐지?
		
		if(target == this.reset) {
			resetGame();
		}
		else {
			for(int i=0; i<this.map.length; i++) {
				if(target == this.map[i] && this.mark[i] == 0) {
					if(this.reset.getText().equals("start")) {
						this.reset.setText("Reset");
					}
					if(this.turn == 1) {
						target.setBackground(new Color(255, 81, 81));
					}
					else {
						target.setBackground(new Color(255, 155, 106));
					}
					
					this.mark[i] = this.turn;
					
					checkWin();
					
					this.turn = this.turn == 1 ? 2 : 1;
				}
			}
		}
	}

	
	private void checkWin() {
		// TODO Auto-generated method stub
		this.win = this.win == 0 ? horizontally() : this.win; // 가로
		this.win = this.win == 0 ? vertically() : this.win; // 세로
		this.win = this.win == 0 ? diagonallyR() : this.win; // 대각오른쪽
		this.win = this.win == 0 ? diagonallyL() : this.win; // 대각왼쪽
		
		if(this.win != 0) {
			System.out.println(this.win + "의 승리");
			new ResultFrame(String.format(this.win + "의 승리"));
		}
	}

	/*
	 * 0 1 2
	 * 3 4 5
	 * 6 7 8
	 */
	// 가로
	private int horizontally() { 
		// TODO Auto-generated method stub
		for(int i=0; i<this.mark.length; i+=3) {
			int cnt = 0; // 카운트를 왜 만들어서 어디사용??
			for(int j=0; j<3; j++) {
				if(this.mark[i+j] == this.turn) {
					cnt++;
				}
			}
			if(cnt == 3) {
				return this.turn; // 턴을 리턴한다??
			}
		}
		return 0;
	}

	// 세로
	private int vertically() { 
		// TODO Auto-generated method stub
		for(int i=0; i<3; i++) {
			int cnt = 0;
			for(int j=0; j<3; j++) {
				if(this.mark[i+j*3] == this.turn) {
					cnt++;
				}
			}
			if(cnt == 3) {
				return this.turn;
			}
		}
		return 0;
	}

	// 대각오른쪽R to L
	private int diagonallyR() { 
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i=1; i<=3; i++) {
			if(this.mark[i*2] == this.turn) {
				cnt++;
			}
		}
		if(cnt == 3) {
			return this.turn;
		}
		return 0;
	}

	// 대각L to R
	private int diagonallyL() { 
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i=0; i<3; i++) {
			if(this.mark[i*4] == this.turn) {
				cnt++;
			}
		}
		if(cnt == 3) {
			return this.turn;
		}
		return 0;
	}

	private void resetGame() {
		// TODO Auto-generated method stub
		
		this.turn = 1;
		this.win = 0;
		this.mark = new int[9];
		
		for(int i=0; i<this.map.length; i++) {
			this.map[i].setBackground(getBackground());
		}
	}
	
	
	
}

// 프레임
class TicFrame extends JFrame{
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;
	
	// 이거 어디사이즈말하는거? 왜 하필 700?
	public static final int SIZE = 700; 
	
	public TicFrame() {
		super("Tic Tac Toe");
		
		setLayout(null);
		setBounds(width/2-SIZE/2, height/2-SIZE/2, SIZE, SIZE); //E=경계 한도
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setBackground(new Color(22, 30, 84));
		
		
		add(new TicGame());
		
		setVisible(true); // E=눈에보이는
		revalidate(); // E=재평가하다,갱신하다
	}
}


public class ex01틱택토 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicFrame game = new TicFrame();
	}

}

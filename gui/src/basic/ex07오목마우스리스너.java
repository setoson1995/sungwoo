package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Omok2 extends JFrame{
	private Omok2Panel panel = new Omok2Panel();
	
	public Omok2() {
		// TODO Auto-generated constructor stub
		super("Omok Game");
		setLayout(null);
		setBounds(50,50,700,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		
		setVisible(true);
		revalidate();
	}
}

class Rect{
	private int x, y, w, h, owner;
	private Color c;
	
	public Rect(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	
}

class OmokResult extends JFrame{
	
	private JLabel text = new JLabel();
	
	public OmokResult(String str) {
		super("GAme Clear");
		setLayout(null);
		setBounds(100,100,300,200);
		
		text.setBounds(0,0,300,200);
		text.setText(str);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		
		setVisible(true);
		revalidate();
	}
}

class Omok2Panel extends JPanel implements MouseListener{
	
	private final int SIZE = 10;
	private Rect[][] map = new Rect[SIZE][SIZE];
	
	private int turn = 1;
	private int win;
	
	private Color p1 = Color.black;
	private Color p2 = Color.white;
	
	public Omok2Panel() {
		setLayout(null);
		setBounds(0,0,700,700);
		
		setmap();
		
		addMouseListener(this); // this : panel
	}
	
	private void setmap() {
		int x = 700/2-5*10/2;
		int y = 700/2-5*10/2;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new Rect(x,y,50,50, Color.green);
				x += 50;
			}
			x = 700/2-5*10/2;
			y+=	50;	
		}	
		
	}

	@Override
	private void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// map 그리기 
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				Rect r = this.map[i][j];
				g.drawRect(r.getX()-25, r.getY()-25, r.getW(), r.getH());
				
				if(i == SIZE-1) {
					g.drawRect(r.getX()-25, r.getY()-25+50, r.getW(), r.getH());
				}
				if(j == SIZE-1) {
					g.drawRect(r.getX()-25+50, r.getY()-25, r.getW(), r.getH());
				}
				if(i == SIZE-1 && j == SIZE-1) {
					g.drawRect(r.getX()-25+50, r.getY()-25+50, r.getW(), r.getH());
				}
			}
			
		}
		// stone그리기
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				Rect r = this.map[i][j];
				if(r.getOwner() != 0) {
					g.setColor(Color.black);
					g.drawRoundRect(r.getX()+5, r.getY()+5, r.getW()-10, r.getH()-10, r.getW(), r.getH());
					g.setColor(r.getC());
					g.fillRoundRect(r.getX()+5, r.getY()+5, r.getW()-10, r.getH()-10, r.getW(), r.getH());
				}

			}
		}
		
		repaint(); // 다시 그리기
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("press");
		
		int x = e.getX();
		int y = e.getY();
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				Rect r = this.map[i][j];
				if(x >= r.getX() && x < r.getX() + r.getW() && y >= r.getY() && y < r.getY() + r.getH()) {
					if(r.setOwner() == 0) {
						r.setOwner(this.turn);
						r.setC(this.turn == 1 ? this.p1 : this.p2);
						
						checkWin();
						
						this.turn = this.turn == 1 ? 2 : 1;
					}
				}
			}
		}
	}

	private void checkWin() {
		// TODO Auto-generated method stub
		this.win = this.win == 0 ? checkHori() : this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checkDia() : this.win;
		this.win = this.win == 0 ? checkReverse() : this.win;
		
		if(this.win != 0) {
			// alert result
			System.out.printf("p%d win \n", this.win);
			new OmokResult(String.format("p%d win \n", this.win));
		}
	}

	private int checkReverse() {
		// TODO Auto-generated method stub
		for(int i=4; i<SIZE; i++) {
			for(int j=0; j<SIZE-4; j++) {
				Rect r = this.map[i][j];
				if(r.getOwner() == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.map[i-k][j+k].getOwner() == this.turn) {
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
				Rect r = this.map[i][j];
				if(r.getOwner() == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.map[i+k][j+k].getOwner() == this.turn) {
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
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				Rect r = this.map[i][j];
				if(r.getOwner() == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.map[i+k][j].getOwner() == this.turn) {
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
			for(int j=0; j<SIZE; j++) {
				Rect r = this.map[i][j];
				if(r.getOwner() == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.map[i][j+k].getOwner() == this.turn) {
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

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


public class ex07오목마우스리스너 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Omok2 game = new Omok2();
		
		
//		bounds 사이즈 이해불가
//		JPanel
//		JLabel
	}

}

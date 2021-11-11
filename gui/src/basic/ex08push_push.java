package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class NemoNemo{
	private int x, y, w, h;
	private Color c;
	
	public NemoNemo(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = Color.black;
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
	public int getH() {
		return h;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
}

class PushPanel extends JPanel implements ActionListener, MouseListener{
	private final int LEFT = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	private final int SIZE = 700;
	
	private JButton[] btn = new JButton[4];
	
	private NemoNemo nemo1 = null;
	private NemoNemo nemo2 = null;
	
	private int dir; // 1left 2down 3right 4up
	private boolean isMoving;
	
	private boolean check;
	
	public PushPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0,0,SIZE,SIZE);
		
		this.dir = 5;
		setBtn();
		setNemo();
	}

	private void setNemo() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		
		int rX = ran.nextInt(SIZE -100);
		int rY = ran.nextInt(SIZE -100);
		
		this.nemo1 = new NemoNemo(rX, rY, 100, 100);
		
		// nemo2 는 nemo1과 겹쳐지지않도록
		while(true) {
			rX = ran.nextInt(SIZE -100 -100);
			rY = ran.nextInt(SIZE -100 -100);
			
			// 검증
			boolean check = false;

			if((rX + this.nemo1.getW() < this.nemo1.getX() || rX > this.nemo1.getX() + this.nemo1.getW() || rY + this.nemo1.getY() < this.nemo1.getY()
				&& rY < this.nemo1.getY() || rY > this.nemo1.getY()+this.nemo1.getH()) {
				
				break;
			}
			
			this.nemo2 = new NemoNemo(rX, rY, 100, 100);
		}
	}

	private void setBtn() {
		// TODO Auto-generated method stub
		String[] text = {"←","↓","→","↑"};
		
		int x = 500;
		int y = 550;
		for(int i=0; i<4; i++) {
			JButton bt = new JButton();
			bt.setBounds(x,y,50,50);
			bt.setText(text[i]);
//			bt.addActionListener(this); // this : bt
			bt.addMouseListener(this);
			add(bt);
			
			this.btn[i] = bt;
			
			x += 50;
			
			if(i == this.btn.length -1 -1) { // 방향키 위치
				y -= 50;
				x -= 100;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
//		g.setColor(Color.black);
//		g.drawRect(this.nemo1.getX(), this.nemo1.getY(), this.nemo1.getW(), this.nemo1.getH());
		
		// draw Rect
		if(this.nemo1 != null && this.nemo2 != null) {
			g.setColor(Color.black);
			g.drawRect(this.nemo1.getX(), this.nemo1.getY(), this.nemo1.getW(), this.nemo1.getH());
			
			if(this.check) {
				g.setColor(Color.red);
			}
			else {
				
			}
			g.setColor(Color.blue);
			g.drawRect(this.nemo2.getX(), this.nemo2.getY(), this.nemo2.getW(), this.nemo2.getH());
		}
		
		if(isMoving) {	
			update();
		}	
		
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("press");
		this.isMoving = true;
		
		// check Button
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
				
			if(target == this.btn[LEFT]) {
//				this.nemo1.setX(this.nemo1.getX()-5);
				this.dir = LEFT;
			}
			else if(target == this.btn[DOWN]) {
//				this.nemo1.setY(this.nemo1.getY()+5);
				this.dir = DOWN;
			}
			else if(target == this.btn[RIGHT]) {
//				this.nemo1.setX(this.nemo1.getX()+5);
				this.dir = RIGHT;
			}
			else if(target == this.btn[UP]) {
//				this.nemo1.setY(this.nemo1.getY()-5);
				this.dir = UP;
				

			}
		}
	}
	
	private void update() {
		// TODO Auto-generated method stub
		if(this.dir == LEFT) {
			if((! check && this.nemo1.getX() > 0) || (check && this.nemo2.getX() > 0 && this.nemo1.getX() > this.nemo2.getW())) {
				this.nemo1.setX(this.nemo1.getX() -1);
			}

//			if(this.nemo1.getX() == this.nemo2.getX()+100) {
//				this.nemo2.setX(this.nemo2.getX() -1);
//			}
			
		}
		else if(this.dir == DOWN) {
			if((! check && this.nemo1.getY() < SIZE-this.nemo1.getH()) || (check && this.nemo2.getY() < SIZE - this.nemo2.getH() )) {
				this.nemo1.setY(this.nemo1.getY() +1);
			}	
//			if(this.nemo1.getY()+100 == this.nemo2.getY()) {
//				this.nemo2.setY(this.nemo2.getY() +1);
//			}
		}
		else if(this.dir == RIGHT) {
			if((! check && this.nemo1.getX() < SIZE-this.nemo1.getW()) || (check && this.nemo2.getX() < SIZE - this.nemo2.getW() )) {
				this.nemo1.setX(this.nemo1.getX() +1);
			}	
//			if(this.nemo1.getX()+100 == this.nemo2.getX()) {
//				this.nemo2.setX(this.nemo2.getX() +1);
//			}	
		}
		else if(this.dir == UP) {
			if((!check && this.nemo1.getY() > 0) ||(check && this.nemo2.getY() > 0)) {
				this.nemo1.setY(this.nemo1.getY() -1);
			}		
//			if(this.nemo1.getY() == this.nemo2.getY()+100) {
//				this.nemo2.setY(this.nemo2.getY() -1);
//			}
		checkSecond();	
		}
	}

	private void checkSecond() {
		// TODO Auto-generated method stub
		if(this.dir == LEFT) {
			if(this.nemo2.getX() + this.nemo2.getW() >= this.nemo1.getX() 
					&& this.nemo2.getY() > this.nemo1.getY() - this.nemo1.getH() 
					&& this.nemo2.getY() < this.nemo1.getY() + this.nemo1.getH()) {
//					&& this.nemo2.getX() > 0) {
				if(this.nemo2.getX() > 0) 
					this.nemo2.setX(this.nemo2.getX() -1);
				this.check = true;
				
			}
		}
		else if(this.dir == DOWN) {
			if(this.nemo2.getY() <= this.nemo1.getY() + this.nemo1.getH() 
					&& this.nemo2.getX() > this.nemo1.getX() - this.nemo1.getW() 
					&& this.nemo2.getX() < this.nemo1.getX() + this.nemo1.getW()) {
//					&& this.nemo2.getY() < SIZE - this.nemo2.getH()) {
				if(this.nemo2.getY() < SIZE - this.nemo2.getH())
					this.nemo2.setY(this.nemo2.getY() + 1);
				this.check = true;
			}
		}
		else if(this.dir == RIGHT) {
			if(this.nemo2.getX() <= this.nemo1.getX() + this.nemo1.getW() 
					&& this.nemo2.getY() > this.nemo1.getY() - this.nemo1.getH() 
					&& this.nemo2.getY() < this.nemo1.getY() + this.nemo1.getH()) {
//					&& this.nemo2.getX() < SIZE - this.nemo2.getW()) {
				if(this.nemo2.getX() < SIZE - this.nemo2.getW())
					this.nemo2.setX(this.nemo2.getX() +1);
				this.check = true;
			}
		}
		else if(this.dir == UP) {
			if(this.nemo2.getY() + this.nemo2.getH() >= this.nemo1.getY()
					&& this.nemo2.getX() > this.nemo1.getX() - this.nemo1.getW() 
					&& this.nemo2.getX() < this.nemo1.getX() + this.nemo1.getW()) {
//					&& this.nemo2.getY() > 0) {
				if(this.nemo2.getY() > 0)
					this.nemo2.setY(this.nemo2.getY() - 1);
				this.check = true;
			}
		}
		else {
			check = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.isMoving = false;
		this.check = false;
		this.dir = 5;
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

class PushPush extends JFrame{
	
	public PushPush() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(50,50,700,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new PushPanel());
		setVisible(true);
		revalidate();
	}
}

public class ex08push_push {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PushPush game = new PushPush();
		
		
//		bounds 사이즈 이해불가
//		JPanel
//		JLabel
	}

}

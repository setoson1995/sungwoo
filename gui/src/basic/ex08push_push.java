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
	
	public PushPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0,0,SIZE,SIZE);
		
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
			rX = ran.nextInt(SIZE -100);
			rY = ran.nextInt(SIZE -100);
			
			// 검증
			boolean check = false;
			/////////////
			if(!check) {
				this.nemo2 = new NemoNemo(rX, rY, 100, 100);
				break;
			}
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
		
		// draw Rect
		if(this.nemo1 != null && this.nemo2 != null) {
			g.setColor(Color.black);
			g.drawRect(this.nemo1.getX(), this.nemo1.getY(), this.nemo1.getW(), this.nemo1.getH());
			g.setColor(Color.blue);
			g.drawRect(this.nemo2.getX(), this.nemo2.getY(), this.nemo2.getW(), this.nemo2.getH());
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
		
		// check Button
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
				
			if(target == this.btn[LEFT]) {
				
			}
			else if(target == this.btn[DOWN]) {
				
			}
			else if(target == this.btn[RIGHT]) {
				
			}
			else if(target == this.btn[UP]) {
				
			}
		}
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

class PushPush extends JFrame{
	
	public PushPush() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(50,50,700,700);
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
	}

}

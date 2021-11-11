//package basic;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//class SnakeRect{
//	private int x, y, w, h;
//	private Color c;
//	
//	public SnakeRect(int x, int y, int w, int h, Color c) {
//		
//	}
//}
//
//class Game extends JPanel implements KeyListener{
//	
//	private final int SIZE = 10;
//	private SnakeRect[][] map = new SnakeRect[SIZE][SIZE];
//	
//	private SnakeRect[] snake = new SnakeRect[4]; // <- ArrayList<SnakeRect>
//	private int[][] yx = new int[4][2];			  // map 인덱스 좌표 정보를 기억
//												  // {{y,x}, {y,x}, {y,x}, {y,x}}
//	
//	public Game() {
//		// TODO Auto-generated constructor stub
//		setLayout(null);
//		setBounds(0,0,700,500);
//		
//		setFocusable(true);
//		addKeyListener(this);
//	}
//
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println(e.getKeyCode());
//		
//		if(e.getKeyCode() == e.VK_ENTER) {
//			System.out.println("enter");
//		}
//		if(e.getKeyCode() == e.VK_LEFT) {
//			System.out.println("left");
//		}
//		else if(e.getKeyCode() == e.VK_DOWN) {
//			System.out.println("down");
//		}
//		else if(e.getKeyCode() == e.VK_RIGHT) {
//			System.out.println("right");
//		}
//		else if(e.getKeyCode() == e.VK_UP) {
//			System.out.println("up");
//		}
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		
//		requestFocusInWindow(); // <- 키 리스너를 위한 포커스를 재요청
//	}
//}
//
//class Snake extends JFrame{
//	public Snake() {
//		// TODO Auto-generated constructor stub
//		super("Snake");
//		setLayout(null);
//		setBounds(100,100,700,500);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//		add(new Game());
//		
//		setVisible(true);
//		revalidate();
//	}
//}
//public class ex0001 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Snake game = new Snake();
//	}
//
//}

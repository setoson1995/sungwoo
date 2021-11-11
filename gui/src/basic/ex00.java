package basic;



import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


// GUI란
// ㄴ awt & swing

// UI 엘리먼트를 담는 컨테이너

// 최상위 컨테이너 : JFrame
// 일반컨테이너 : JPanel
// 컴포넌트 : JButton, JLabel, JTextHild, ..

class ManualPanel extends JPanel{
	public ManualPanel(int x, int y, int w, int h) {
		
	}
}

class MyPanel extends JPanel{ // 배경색 하나
	public MyPanel() {
		// TODO Auto-generated constructor stub
		setBounds(0,0,250,400);
		setBackground(Color.red.darker());
				
	}	
}
class MyPanel2 extends JPanel{ // 배경색 두개
	public MyPanel2() {
		setBounds(250,0,250,400);
		setBackground(Color.orange);
	}
}


//버튼 만들기
class Contents extends JPanel implements ActionListener{
		
	// JBuuton 클레스를 import -> 객체생성
	private JButton bt = new JButton();
	private boolean click;
	
	public Contents() {
		setLayout(null);
		setBounds(0,0,500,400);
		
		System.out.println(this.bt);
		bt.setBounds(100,100,100,100);
		bt.setText("PUSH");

		bt.setBackground(Color.gray.darker());
		bt.addActionListener(this); //버튼에 리스너를 달아줌
		add(bt);
		
		// if on mac
		// bt.setOpaque(true);
		// bt.setBorderPainted(false);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource());
		System.out.println("eyyyy_");
		if(e.getSource() == this.bt) {
			this.click = this.click ? false :true;
			if(this.click) {
				this.bt.setBackground(Color.black);			
			}
			else if(this.click) {
				this.bt.setBackground(Color.red.darker());			
			}
		}

	}
}

// JFrame 만들기
class MyFrame extends JFrame{
	
	public MyFrame() { // 클레스랑 이름 같게해야함.
		// TODO Auto-generated constructor stub

		// JFrame 설정
		
		// 0.
		//기본 레이아웃 구성의 설정 -> 순서대로 나열식
		setLayout(null);
		
		// 1.
		// 타이틀
		// super("title")
		//setTile("title")
		setTitle("MyFrame");
		
		// 2.
		// 크기
		// setBounds(x, y, width, height) x,y는 좌표. width,width는 크기
		setBounds(50,50,500,400); 
		/* 만약 그냥 setsize를 사용하면 setlocation을 같이 
		 * 사용해서 두줄이 되니까 setBounds로 축약한것
		 * 
		 */
		
		
		// 3.
		//종료 조건
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// add() 메서드를 통해 컨테이너 및 컴포넌트를 추가할 수 있다
		add(new MyPanel());
		
//		add(new ManualPanel(250, 0, 250, 400,Color.yellow));
		add(new Contents());
		
		
		// 4.
		// 보이기
		//setVisible(true)
		setVisible(true);
		
		// 5.
		// 갱신
		revalidate();
		
		
	}
	
}


public class ex00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame frame = new MyFrame();
		
//		class 모니터화면크기알아내기 {
//			public static void main(String[] args) {
//				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//				System.out.println("스크린 사이즈 :"+ d.width +" X "+d.height);
//			}
//		}
	}

}

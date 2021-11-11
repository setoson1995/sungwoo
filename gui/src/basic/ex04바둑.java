package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ba extends JFrame{
	
	Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	int width = dm.width;
	int height = dm.height;
	baGamePanel panel = new baGamePanel();
	
	public ba() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setTitle("바둑게임");
		setBounds(0,0,1000,700);
		setLocationRelativeTo(null);
		
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}

class baGamePanel extends JPanel implements ActionListener{
	
	private final int SIZE = 10;
	private JButton[][] map = new JButton[SIZE][SIZE];
	
	private Color background = new Color(216, 182, 164);
	private Color p1 = new Color(0, 0, 0);
	private Color p2 = new Color(238, 235, 221);
	
	int turn = 1;
	
	public baGamePanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0,0,1000,700);
		
//		setTitle();
		setMap();
//		setResetButton();
	}

	private void setMap() {
		// TODO Auto-generated method stub
		int x = 200; 
		int y = 50;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new JButton();				
				this.map[i][j].setBounds(x,y,50,50);
				this.map[i][j].setBackground(this.background);
				
				this.map[i][j].addActionListener(this);
				
				add(this.map[i][j]);
				
				x += 55;
			}
			x = 200;
			y += 55;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(target == this.map[i][j]) {
						if(turn == 1) {
							if(this.map[i][j].getBackground().equals(this.background)) {
								this.map[i][j].setBackground(this.p1);
								turn = 2;								
							}
							else {j--;}
						}
						else if(turn == 2){
							if(this.map[i][j].getBackground().equals(this.background)) {
								this.map[i][j].setBackground(this.p2);
								turn = 1;							}
							else {j--;}

						}
					}
				}
			}
		}

	}
}

public class ex04바둑 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ba b = new ba();
	}

}

package basic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

class JoinFrame extends JFrame {
	
	JLabel idLabel = new JLabel("ID: ");
	JLabel pwLabel = new JLabel("PW: ");
	JLabel nameLabel = new JLabel("NAME: ");
	
	JTextField idField = new JTextField();
	JTextField pwField = new JTextField();
	JTextField nameField = new JTextField();
	
	public JoinFrame() {
		setLayout(null);
		setBounds(200,200,300,400);
		
		setTextFied();
		
		setVisible(true);
		revalidate();
	}

	private void setTextFied() {
		
		idLabel.setBounds(30,50,60,50);
		add(idLabel);
		
		idField.setBounds(90,50,150,50);
		add(idField);
		
		pwLabel.setBounds(30,110,60,50);
		add(pwLabel);
		
		pwField.setBounds(90,110,150,50);
		add(pwField);
		
		nameLabel.setBounds(30,170,60,50);
		add(nameLabel);
		
		nameField.setBounds(90,170,150,50);
		add(nameField);
		
	}
}

class ExPanel extends JPanel implements KeyListener, ActionListener{
	
	// 줄바꿈 불가

	JTextField jf = new JTextField();	
	
	// 줄바꿈 가능 -> JTextArea 활용
	JTextArea ja = new JTextArea();
	
	// 로그인 & 회원가입
	// ㄴ 메인 프레임에 버튼 두개
	// ㄴ 로그인과 회원가입
	// ㄴ 버튼을 누르면 -> 팝업(세로운 프레임) -> 텍스트 입력
	// ㄴ 회원가입 정보는 Vector에 저장
	
	public Vector<Vector<String>> users = new Vector<>();
	Vector<String> colName = null;
	
	// User : Vector<String>
	// ㄴ add(id) : 중복예외처리
	// ㄴ add(pw)
	// ㄴ add(name)
	
	// 옵션 : 파일처리
	
	JButton login = new JButton();
	JButton join = new JButton();
	
	JoinFrame joinFrame = null;
	
	JTable table = null; // import
	
	public ExPanel() {
		setLayout(null);
		setBounds(0,0,400,500);
		
		 
		
//		setTextField();
//		setTextArea();
		
		setTable();
		setButtons();
		
//		init(); // 랜덤 계정생성 메서드
	}

	private void init() {
		Random ran = new Random();
		
		String[] front = {"김","이","박","정","오"};
		String[] back1 = {"성","지","우","아","희"};
		String[] back2 = {"연","무","안","용","이"};
		
		for(int i=0; i<100; i++) {
			Vector<String> user = new Vector<>();
			String name = front[ran.nextInt(front.length)] + back1[ran.nextInt(back1.length)] + back2[ran.nextInt(back2.length)];
			user.add(name);
			user.add(i + "");
			user.add(i + "");
			this.users.add(user);
		}
		
	}

	private void setTable() {
		this.colName = new Vector();
		this.colName.add("ID");
		this.colName.add("PW");
		this.colName.add("NAME");
		
		table = new JTable(users, colName);
		table.setBounds(50, 50, 300, 300);
		
		table.setBorder(new LineBorder(Color.red)); 
		table.setGridColor(Color.black);
		
//		add(table);
		
		JScrollPane js = new JScrollPane(table); // 스크롤하고싶은 거의 모든걸 추가할 수 있다
		js.setBounds(50, 50, 300, 300);
		js.setAutoscrolls(true); // 트루가 디폴트이다.
		add(js);
	}

	private void setButtons() {
		this.login.setBounds(100,380,100,50);
		this.login.setText("login");
		this.login.addActionListener(this);
		add(this.login);
		
		this.join.setBounds(210,380,100,50);
		this.join.setText("Join");
		this.join.addActionListener(this);
		add(this.join);
	}
 
	private void setTextArea() {
		ja.setBounds(50,250,500,150);
		add(ja);
		
	}

	private void setTextField() {
		jf.setBounds(100,50,100,30);
		jf.setFocusable(true);
		jf.addKeyListener(this);
		add(jf); // 이걸 써야 보임
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("PRESS");
		
		Object target = e.getSource();
		
		if(target == this.joinFrame.idField || target == this.joinFrame.pwField || target == this.joinFrame.nameField) {
			String id = this.joinFrame.idField.getText();
			String pw = this.joinFrame.pwField.getText();
			String name = this.joinFrame.nameField.getText();
			
			if(!id.equals("") && !pw.equals("") && !name.equals("")) {
				// join
				joinUser(id, pw, name);
			}
		}
	}

	private void joinUser(String id, String pw, String name) {
		boolean check = checkUserId(id);
		
		if(!check) {
			// User
			Vector<String> user = new Vector<>();
			user.add(id);
			user.add(pw);
			user.add(name);
			
			this.users.add(user);
			
			System.out.println("회원가입 완료");
			System.out.println("user.size() : " + this.users.size());			
			
			table.revalidate();// 업데이트 내용을 자동으로 보여줌
			table.repaint(); // 위에꺼랑 같이 사용
			
			this.joinFrame.dispose(); // 프레임에 대한 창닫기
		}
		else {
			// 단순 팝업창을 띄울때에만 사용 (권장 X) 단순경고창
			JOptionPane.showMessageDialog(null, "중복된 아이디"); // 새로바움
		}
	}

	private boolean checkUserId(String id) {
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).get(0).equals(id)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.join) {
			this.joinFrame = new JoinFrame(); // 널로 준비하고있다가 창이뜬다?
//			this.joinFrame.setFocusable(true);
//			this.joinFrame.addKeyListener(this);
			
			this.joinFrame.idField .setFocusable(true);
			this.joinFrame.idField.addKeyListener(this);
			
			this.joinFrame.pwField .setFocusable(true);
			this.joinFrame.pwField.addKeyListener(this);
			
			this.joinFrame.nameField .setFocusable(true);
			this.joinFrame.nameField.addKeyListener(this);
		}
	
	}
}


public class ex회원가입로그인 extends JFrame{

	public ex회원가입로그인() {
		setLayout(null);
		setBounds(100,100,600,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new ExPanel());
		
		setVisible(true);
		revalidate();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ex회원가입로그인();
	}

}

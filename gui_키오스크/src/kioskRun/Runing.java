package kioskRun;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


class Kiosk extends MyUtill {
	
	Vector<String> menu = new Vector<>();
	
	JButton btn = new JButton();
	JTextArea ja = new JTextArea();
	
	public Kiosk() {
		setLayout(null);
		setBounds(0,0,700,800);
		
		setImage();
		setTable(); // 선택현황
		setButton(); 
	}

	private void setImage() {
		// TODO Auto-generated method stub
		set
	}

	private void setTable() {
		// TODO Auto-generated method stub
		
	}

	private void setButton() {
		// TODO Auto-generated method stub
		btn.setBounds(550,100,100,70);
		btn.setText("결제");
		add(btn);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		super.actionPerformed(e);
	}
}

public class Runing extends JFrame{

	public Runing() {
		super("상점");
		setLayout(null);
		setBounds(0,0,700, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Kiosk());
		
		setVisible(true);
		revalidate();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Runing();
		
//		GUI 미니 프로젝트 : 키오스크 만들기
//		. 주문 및 결제 처리를 하는 키오스크를 완성
//		. 테이블 처리 필수 → 오더 내역이 테이블에 반영
//		. 결제 단계 (팝업 창에서 현금 or 카드)
//		. 결제완료 → 관리자 모드의 매출에 반영
//		. 관리자모드 로그인 단계 거쳐서 → 매출관리 및 재고수정
	}

}

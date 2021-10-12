package models;

public class User {
	
	private int userCode;
	private String id;
	private String pw;
	private String name;
	private int accCnt;
	
	// 보유계좌의 객체주소 배열
	
	public User(int userCode, String id, String pw, String name) {
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPw() {
		return this.pw;
	}
	
	public int getUserCode() {
		return this.userCode;
	}
	public String getName() {
		return this.name;
	}
	
	
}

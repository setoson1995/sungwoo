package models;

import java.util.Random;
import java.util.Scanner;

public class Bank {
	public static Scanner scan = new Scanner(System.in);
	
	public static Random ran = new Random();
	
	public static int log = -1; // 로그정보
	
	private static String name;
	
	private Bank() {} // new를 통한 Bank 생성이 안되게 막음
	
	public static String getName() {
		return Bank.name;
	}
	
	public static void setName(String name) {
		Bank.name = name;
	}
}

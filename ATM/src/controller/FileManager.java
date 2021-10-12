package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

		private File file;
		private FileWriter fw;
		private FileReader fr;
		private BufferedReader br;
		
		private String fileUserName = "users.txt";
		private String fileAccsName = "accs.txt";
		
		private UserManager um = UserManager.instance;
		private AccountManager am = AccountManager.instance;
		
		public static FileManager instance = new FileManager();
		
		// save
		public void save() {
			//um.users
			//code/id/pw/name/account
			String data = makeUsersData();
			try {
				file = new File(fileUsersName);
				fw = new FileWriter(file);
				fw.write(data);
				fw.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//am.accs
			//accNum/code/money
			data = makeAccsData();
			try {
				file = new File(fileAccsName);
				fw = new FileWriter(file);
				fw.write(data);
				fw.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		private String makeUsersData() {
			String data = "";
			
			for(int i=0; i<um.getUsersSize(); i++) {
				data += um.getUser(i).getUserCode() + "/";
			}
		}
		
		public void load() {
			// um.users
			//code/id/pw/name/account
			try {
				
			}
		}
		
		//////
		int code = Integer.parseInt(info[0]);
		String id = info[1];
		String pw = info[2];
		String name = info[3];
		int cnt = Integer.parseInt(info[4]);
		User user = new User(code, id, pw, name, cnt);
		
		um.addUser(user);
	}	
	
	fr.close();
	br.close();
} catch (Exception e)
	
	
	
}

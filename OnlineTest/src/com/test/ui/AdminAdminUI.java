package com.test.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.test.bean.Admin;
import com.test.bl.AdminLogic;

public class AdminAdminUI {
	private AdminLogic adminbl = new AdminLogic();
	private static final String MENU_OPTIONS_ADMIN = "1. Insert New Admin" +
			"\n 2. Update Admin Password" + "\n 3. Delete Admin"+ " \n 4. Exit";
	private String username;
	public void displayMenu(){
		System.out.println(MENU_OPTIONS_ADMIN);
	}
	
	public AdminAdminUI(String username) {
		super();
		this.username = username;
		System.out.println(username);
	}
	
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException{
		Scanner scanner=new Scanner(System.in);		
		Admin admin=null;
		String pass;
		
			switch(choice)
			{
			case 1:
					System.out.println("Enter UserName:");
					username=scanner.next();
					System.out.println("Enter password:");
					pass=scanner.next();
					admin=new Admin(username,pass);
					adminbl.insert(admin);
				break;
			case 2:
				System.out.println(username);
					admin=adminbl.search(username);
					System.out.println(admin);
					username=admin.getUsername();
					System.out.println("Update Password");
					pass=scanner.next();
					adminbl.update(username, pass);
				break;
			case 3:
				admin=adminbl.search(username);
					username=admin.getUsername();
					System.out.println("Enter Username You Want To Delete:");
					pass=scanner.next();
					adminbl.delete(username, pass);
				break;
			case 4:
					return false;
			default:
						System.out.println("Invalid Choice");
			}
			return true;
	}
}

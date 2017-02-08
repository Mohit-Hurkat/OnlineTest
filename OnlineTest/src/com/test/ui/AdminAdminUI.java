package com.test.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.test.bean.Admin;
import com.test.bl.AdminLogic;

public class AdminAdminUI {
	private AdminLogic adminbl = new AdminLogic();
	private static final String MENU_OPTIONS_ADMIN = "\n1.Update Admin Password" + " \n2.Exit";
	private String username;
	public void displayMenu(){
		System.out.println(MENU_OPTIONS_ADMIN);
	}
	
	public AdminAdminUI(String username) {
		super();
		this.username = username;
	}
	
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException{
		Scanner scanner=new Scanner(System.in);		
		Admin admin=null;
		String pass;
		
			switch(choice)
			{
			case 1:
					admin=adminbl.search(username);
					System.out.println(admin);
					username=admin.getUsername();
					System.out.println("Update Password");
					pass=scanner.next();
					adminbl.update(username, pass);
				break;
			case 2:
					return false;
			default:
						System.out.println("Invalid Choice");
			}
			return true;
	}
}

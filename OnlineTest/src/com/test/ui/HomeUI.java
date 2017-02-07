package com.test.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import com.test.bean.Admin;
import com.test.bean.Student;
import com.test.bl.AdminLogic;
import com.test.bl.StudentLogic;
import com.test.helper.AdminAuthenticator;
import com.test.helper.StudentAuthenticator;
import com.test.helper.StudentData;

public class HomeUI {
	private static final String MENU_OPTIONS = "1. Sign Up" +
			"\n" + "2. Sign In" + "\n" + "3. Exit";
	private static final String EXIT_MSG = "Exit";
	private static final String INVALID_CHOICE_MSG = "Invalid Choice";
	private static final String USERNAME_PROMPT = "Enter Username";
	private static final String PASSWORD_PROMPT = "Enter Password";
	private static final String ACC_CREATION_SUCCESSFUL_MSG ="Account Created Successfully";
	private static final String ACC_CREATION_FAILED_MSG1 ="Sign Up with a Different Username";
	private static final String ACC_CREATION_FAILED_MSG = "Account Creation failed";
	private static final String AUTH_FAILED_MSG = "Authentication failed";
	private static final String CHOICE_MSG = "Enter your choice";
	private AdminLogic adminbl = new AdminLogic();
	private StudentLogic studentLogic=new StudentLogic();
	
	public void displayMenu(){
		System.out.println(MENU_OPTIONS);
	}
	
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException{
		Scanner scanner=new Scanner(System.in);
		StudentData sd=new StudentData();
		switch(choice){
		case 1:
			sd.input();
			try {
				boolean status=studentLogic.insert(sd.getStudent());
				if(status){
					System.out.println(ACC_CREATION_SUCCESSFUL_MSG);
				}
				else{
					System.out.println(ACC_CREATION_FAILED_MSG1);
				}
			} catch (ClassNotFoundException | IOException | SQLException e) {
				System.out.println(ACC_CREATION_FAILED_MSG + ": " + e);
			}
			break;
		case 2:
			StudentAuthenticator ca = new StudentAuthenticator();
			AdminAuthenticator aa =new AdminAuthenticator();
			System.out.println(USERNAME_PROMPT + ": ");
			String username = scanner.next();
			System.out.println(PASSWORD_PROMPT + ": ");
			String password = scanner.next();
			boolean truthVal1 = false;
			Admin admin=adminbl.retrieveAdminRecord();
			if(username.equals(admin.getUsername())){
				Map.Entry<Admin, Boolean> result =aa.authenticate(username, password);
						if(result.getValue() != false){
							AdminUI adminUI = new AdminUI();
							do{
								adminUI.displayMenu();
								System.out.print(CHOICE_MSG + ": ");
								truthVal1 = adminUI.choice(scanner.nextInt());
							} while (truthVal1);
						}
						else{
							System.out.println(AUTH_FAILED_MSG);
						}
		
			}
	else{
		Map.Entry<Student, Boolean> result =ca.authenticate(username, password);
			if(result.getValue() != false){
			StudentUI StudentUI = new StudentUI();
			do {
				StudentUI.displayMenu(username);
				System.out.print(CHOICE_MSG + ": ");
				truthVal1 = StudentUI.choice(scanner.nextInt());
			} while(truthVal1);
		}
		else{
			System.out.println(AUTH_FAILED_MSG);
		}
	}
			break;
		case 3:
			System.out.println(EXIT_MSG);
			return false;
		default:
			System.out.println(INVALID_CHOICE_MSG);
		}
		
		return true;
	}

}

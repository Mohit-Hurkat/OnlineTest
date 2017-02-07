package com.test.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.test.bl.StudentLogic;
import com.test.helper.StudentData;

public class HomeUI {
	private static final String MENU_OPTIONS = "1. Sign Up" +
			"\n" + "2. Sign In" + "\n" + "3. Exit";
	private static final String EXIT_MSG = "Exit";
	private static final String INVALID_CHOICE_MSG = "Invalid Choice";
	public void displayMenu(){
		System.out.println(MENU_OPTIONS);
	}
	
	public boolean choice(int choice){
		Scanner sc=new Scanner(System.in);
		switch(choice){
		case 1:
			StudentData sd=new StudentData();
			sd.input();
			StudentLogic studentLogic=new StudentLogic();
			try {
				studentLogic.insert(sd.getStudent());
			} catch (ClassNotFoundException | IOException | SQLException e) {
				
				e.printStackTrace();
			}
			break;
		case 2:
			
			break;
		case 3:
			System.out.println(EXIT_MSG);
			return false;
		default:
			System.out.println(INVALID_CHOICE_MSG);
		}
		
		return false;
	}
}

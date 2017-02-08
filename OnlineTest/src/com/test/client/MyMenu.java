package com.test.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import com.test.ui.HomeUI;


public class MyMenu {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
		HomeUI homeUI=new HomeUI();
		Scanner sc=new Scanner(System.in);
		boolean truthVal;
		do{
			homeUI.displayMenu();
			System.out.println("Enter Your choice : ");
			int ch=sc.nextInt();
			truthVal = homeUI.choice(ch);
		} while(truthVal);
	}
	
}
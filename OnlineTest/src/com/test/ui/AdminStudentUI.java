package com.test.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.test.bean.Question;
import com.test.bean.Student;
import com.test.bl.StudentLogic;

public class AdminStudentUI
{
	private StudentLogic studentbl = new StudentLogic();
	private static final String MENU_OPTIONS_STUDENT = "1.Search Student" +
			"\n 2. Delete Student" + "\n 3.List All Students"+ " \n 4. Exit";
	public void displayMenu(){
		System.out.println(MENU_OPTIONS_STUDENT);
	}
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException{
		Scanner scanner=new Scanner(System.in);		
		String username;
		switch(choice)
		{
		case 1:
			System.out.println("Enter Student's UserName You Want To Search:");
			username=scanner.next();
			studentbl.search(username);
			break;
		case 2:
			System.out.println("Enter Student's UserName You Want To Delete:");
			username=scanner.next();
			studentbl.delete(username);
			break;
		case 3:
			System.out.println("List Of All Students:");
			List<Student> stuList=studentbl.displayAll();
			for(Student s:stuList)
				System.out.println(s);
			break;
		case 4:
			return false;
		default:
				System.out.println("Invalid Choice");
			 
		}
		return true;
	}
}

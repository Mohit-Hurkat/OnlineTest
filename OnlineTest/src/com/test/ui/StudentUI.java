package com.test.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.test.bean.Student;
import com.test.bl.TestLogic;
import com.test.dao.StudentDaoImpl;

 

public class StudentUI 
{
	private StudentDaoImpl studentDao=new StudentDaoImpl();
	private TestLogic tbl=new TestLogic();
	private Student student=null;
	private static final String STUDENT_MENU_OPTIONS ="1. Update Student Record"+	
			"\n" + "2. Give Online Test"+	
			"\n" + "3. Exit"; 
	private static final String CHOICE_MSG = "Enter your choice";
	public void displayMenu()
	{
		System.out.println(STUDENT_MENU_OPTIONS);
	}
	
	public boolean choice(int choice) throws IOException, ClassNotFoundException, SQLException 
	{	
		String username,studentName,pass,phone,email;
		Scanner sc= new Scanner(System.in);
		switch(choice)
		{
		
		case 1:
			System.out.println("Enter The Student's User Name You Want To Update: ");
			username=sc.next();
			 System.out.println("Enter New Details :\n");
			 System.out.println("Enter New Student Name:");
			 studentName=sc.next();
			 System.out.println("Enter New Password:");
			 pass=sc.next();
			 System.out.println("Enter New Phone Number:");
			 phone=sc.next();
			 System.out.println("Enter New E-Mail Id:");
			 email=sc.next();
			 
			 student=new Student(username,pass,studentName, phone, email);
			 studentDao.update(username, student);
			 
			break;
		
		case 2:
			System.out.println("Enter Username");
			username=sc.next();
			 System.out.println("Enter Subject-Id");
			 int subjectId=sc.nextInt();
			 tbl.giveTest(username, subjectId);
			break;
		

		case 3:
			return false;
		
		
		default:
			System.out.println("Invalid choice");
			displayMenu();
		}
		
		return true;
	}

}

package com.test.ui;
import java.io.IOException;
import java.sql.SQLException;
 
import java.util.Scanner;

 


public class AdminUI 
{
 	 
	private AdminAdminUI adminUi=new AdminAdminUI();
	private AdminStudentUI studentUi=new AdminStudentUI();
	private AdminQuestionUI questionUi=new AdminQuestionUI();
	private AdminSubjectUI subjectUi=new AdminSubjectUI();
	private static final String MENU_OPTIONS = "1.Admin Related Tasks" +
			"\n" + "2. Student Realted Tasks" + "\n" + "3. Question Related Tasks" +
			"\n" + "4. Subject Related Tasks" + "\n" + "5. Exit"; 
	 
	public void displayMenu()
	{
		System.out.println(MENU_OPTIONS);
	}
	
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException
	{
		switch(choice)
		{
		case 1:
			adminUi.choice(1);
			break;
		case 2:
			studentUi.choice(2);
			 break;
		case 3:
			questionUi.choice(3);
			break;
		case 4:
			subjectUi.choice(4);
			break;
			
		case 5:
			return false;
		default:	
			System.out.println("INVALID CHOICE.");
			displayMenu();
		}
		return true;
	}
}

package com.test.ui;
import java.io.IOException;
import java.sql.SQLException;
 
import java.util.Scanner;

 


public class AdminUI 
{
 	 
	
	private AdminStudentUI studentUi=new AdminStudentUI();
	private AdminQuestionUI questionUi=new AdminQuestionUI();
	private AdminSubjectUI subjectUi=new AdminSubjectUI();
	private static final String MENU_OPTIONS = "1.Admin Related Tasks" +
			"\n" + "2. Student Realted Tasks" + "\n" + "3. Question Related Tasks" +
			"\n" + "4. Subject Related Tasks" + "\n" + "5. Exit"; 
	private static final String CHOICE_MSG = "Enter your choice";
	private String username;
	private AdminAdminUI adminUi=new AdminAdminUI(username);
	public AdminUI(String username) {
		super();
		this.username = username;
		System.out.println(username);
	}
	
	
	public void displayMenu()
	{
		System.out.println(MENU_OPTIONS);
	}
	
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException
	{
		boolean truthVal = false;
		Scanner scanner=new Scanner(System.in);
		
		switch(choice)
		{
		case 1:
			do{
				adminUi=new AdminAdminUI(username);
			adminUi.displayMenu();;
			System.out.print(CHOICE_MSG + ": ");
			truthVal=adminUi.choice(scanner.nextInt());
		} while (truthVal);
		break;
		case 2:
			do{
				studentUi.displayMenu();;
				System.out.print(CHOICE_MSG + ": ");
				truthVal=studentUi.choice(scanner.nextInt());
			} while (truthVal);
			break;
		case 3:
			do{
				questionUi.displayMenu();;
				System.out.print(CHOICE_MSG + ": ");
				truthVal=questionUi.choice(scanner.nextInt());
			} while (truthVal);
			break;
		case 4:
			do{
				subjectUi.displayMenu();;
				System.out.print(CHOICE_MSG + ": ");
				truthVal=subjectUi.choice(scanner.nextInt());
			} while (truthVal);
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

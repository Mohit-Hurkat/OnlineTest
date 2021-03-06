package com.test.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.test.bean.Subject;
import com.test.bl.SubjectLogic;

public class AdminSubjectUI {
	private SubjectLogic subjectbl=new SubjectLogic();
	private static final String MENU_OPTIONS_SUBJECT = "\n1.Insert a Subject" +
			"\n2.Update a Subject" + "\n3.Delete a Subject"+ " \n4.Search a Subject"+
			"\n5.Display all Subjects"+ "\n6.Exit";
	public void displayMenu(){
		System.out.println(MENU_OPTIONS_SUBJECT);
	}
	
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException{
		Scanner scanner=new Scanner(System.in);		
		int subId;
		String sub,startd,endd;
		Subject subject=null;
		  
		switch(choice)
		{
		case 1:
			System.out.println("Enter Subject Name:");
			sub=scanner.next();
			System.out.println("Enter Start Date (dd/mon/yyyy) ");
			startd=scanner.next();
			System.out.println("Enter End Date (dd/mon/yyyy)");
			endd=scanner.nextLine();
			if(subjectbl.insert(sub,startd,endd))
			{
				System.out.println("One Subject Successfully Inserted.");
			}
			else
			{
				System.out.println("Not Inserted.");
			}
			break;
		case 2:
			System.out.println("Enter The Subject Id You Want To Update:");
			subId=scanner.nextInt();
			System.out.println("Enter New Subject Name:");
			sub=scanner.next();
			System.out.println("Enter New Subject Start Date:");
			startd=scanner.next();
			System.out.println("Enter New Subject End Date:");
			endd=scanner.next();
			subject=new Subject(subId,sub,startd,endd);
			if(subjectbl.update(subId, subject))
			{
			System.out.println("One Subject Successfully Updated.");
			}
			else
			{
				System.out.println("Not Updated.");
			}
			break;
		case 3:
			System.out.println("Enter The Subject Id You Want To Delete:");
			subId=scanner.nextInt();
			if(subjectbl.delete(subId))
			{
			System.out.println("One Subject Successfully Deleted.");
			}
			else
			{
				System.out.println("Not Deleted.Please Try Again.");
			}
			break;
		case 4:
			System.out.println("Enter The Subject Id You Want To Search:");
			subId=scanner.nextInt();
			subject=subjectbl.search(subId);
			if(subject==null){
				System.out.println("Subject Id doesn't Exist");
				return true;
			}
			 System.out.println(subject);
			break;
		case 5:
			List<Subject> subList=subjectbl.displayAll( );
			for(Subject s:subList)
				System.out.println(s);
			break;
		case 6:
			return false;
		 
		default:
				System.out.println("Invalid Choice");
		}
		return true;
}
}

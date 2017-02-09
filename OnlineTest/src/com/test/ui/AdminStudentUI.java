package com.test.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.test.bean.Question;
import com.test.bean.Student;
import com.test.bl.StudentLogic;
import com.test.bl.SubjectLogic;
import com.test.bl.TestLogic;

public class AdminStudentUI
{
	private StudentLogic studentbl = new StudentLogic();
	private TestLogic testbl = new TestLogic();
	private SubjectLogic subjectbl = new SubjectLogic();
	private static final String MENU_OPTIONS_STUDENT = "\n"+"1.Search Student" +
			"\n2.Delete Student" + "\n3.List All Students"+ " \n4.Check Student Result"+" \n5.Exit"+"\n";
	public void displayMenu(){
		System.out.println(MENU_OPTIONS_STUDENT);
	}
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException{
		Scanner scanner=new Scanner(System.in);	
		Student student=null;
		String username,subject;
		int subjectId=0;
		switch(choice)
		{
		case 1:
			System.out.println("Enter Student's UserName You Want To Search:");
			username=scanner.next();
			student=studentbl.search(username);
			//System.out.println(student);
			break;
		case 2:
			System.out.println("Enter Student's UserName You Want To Delete:");
			username=scanner.next();
			if(studentbl.delete(username))
			{
				System.out.println("Succefully Deleted.");
			}
			else
			{
				System.out.println("Data Is Not Found.Please Try Again.");
			}
			break;
		case 3:
			System.out.println("List Of All Students:");
			List<Student> stuList=studentbl.displayAll();
			for(Student s:stuList)
				System.out.println(s);
			break;
		case 4:
			System.out.println("Enter Student's UserName:");
			username=scanner.next();
			System.out.println("Enter SubjectID");
			subjectId=scanner.nextInt();
			subject=subjectbl.subname(subjectId);
			int result=testbl.result(username, subjectId);
			System.out.println("Username:" + username+" has scored "+(result*10)+"% in "+subject);
			break;
		case 5:
			return false;
		default:
				System.out.println("Invalid Choice");
			 
		}
		return true;
	}
}

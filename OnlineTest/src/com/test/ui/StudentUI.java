package com.test.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.test.bean.Student;
import com.test.bean.Subject;
import com.test.bl.SubjectLogic;
import com.test.bl.TestLogic;
import com.test.dao.StudentDaoImpl;
import com.test.helper.StudentData;

 

public class StudentUI 
{
	private StudentDaoImpl studentDao=new StudentDaoImpl();
	private TestLogic tbl=new TestLogic();
	private SubjectLogic sbl=new SubjectLogic();
	private Student student=null;
	private static final String STUDENT_MENU_OPTIONS ="1.Update Student Record"+	
			"\n" + "2.Give Online Test"+	
			"\n" + "3.Exit"; 
	private static final String CHOICE_MSG = "Enter your choice";
	private static final String FAIL = "Update Failed";
	private String username;
	private boolean status=false;
	public void displayMenu()
	{
		System.out.println(STUDENT_MENU_OPTIONS);
	}
	
	
	public StudentUI(String username) {
		super();
		this.username = username;
	}



	public boolean choice(int choice) throws IOException, ClassNotFoundException, SQLException {	

		switch(choice)
		{
		
		case 1:
			StudentData studentD=new StudentData();
			student=studentD.update();
			if(student!=null)
			 studentDao.update(username, student);
			else{
				System.out.println(FAIL);
			}
			 
			break;
		
		case 2:
			Scanner sc= new Scanner(System.in);
				List<Subject> subList=sbl.displayAll();
				for(Subject sub:subList){
				System.out.println(sub);
				}
			System.out.println("\n-------------------INSTRUCTIONS FOR ONLINE EXAM-------------------");
			System.out.println("1)You will be given only 15 seconds to attempt every question");
			System.out.println("2)You can't skip any question");
			System.out.println("3)Every question has 4 options out of which only one is correct");
			System.out.println("4)You can't attempt the same test twice");
			System.out.println("5)Once answered you can't change your answer");
			System.out.println("6)Each question is of one mark");
			System.out.println("7)Your result will be displayed as per the number of correct questions you have answered in percentage");
			System.out.println("Enter Subject-Id");
			int subjectId=sc.nextInt();
			status=tbl.check(subjectId);
			if(status){
			tbl.giveTest(username, subjectId);
			}
			else
			{
				System.out.println("Invalid Subject");
				return true;
			}
			int result=tbl.result(username, subjectId);
			result=result*10;
			System.out.println("Your Score Percentage: "+result+"%");
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

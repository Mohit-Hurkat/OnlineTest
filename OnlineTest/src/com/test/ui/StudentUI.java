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
	private StudentData studentD=new StudentData();
	private TestLogic tbl=new TestLogic();
	private SubjectLogic sbl=new SubjectLogic();
	private Student student=null;
	private static final String STUDENT_MENU_OPTIONS ="\n1.Update Your Record"+	
			"\n" + "2.Give Online Test"+ "\n" + "3.View Previous Results"+
			"\n" + "4.Exit"; 
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
			student=studentD.update();
			if(student!=null)
			 studentDao.update(username, student);
			else{
				System.out.println(FAIL);
			}
			 
			break;
		
		case 2:
			studentD.instruction();
			Scanner sc= new Scanner(System.in);
				List<Subject> subList=sbl.displayAll();
				for(Subject sub:subList){
				System.out.println(sub);
				}
			System.out.println("Enter Subject-Id");
			int subjectId=sc.nextInt();
			status=tbl.check(subjectId);
			if(status){
			tbl.dateCheck(subjectId);
			status=tbl.giveTest(username, subjectId);
				if(status){
							int result=tbl.result(username, subjectId);
							result=result*10;
							System.out.println("Your Score Percentage: "+result+"%");
							return false;
							}
							else{
							System.out.println("\n");
							return true;
							}
						}	
			else{
				System.out.println("Invalid Subject");
				return true;
			}
		case 3:
			status=tbl.result_student(username);
			return status;

		case 4:
			return false;
		
		
		default:
			System.out.println("Invalid choice");
			displayMenu();
		}
		
		return true;
	}

}

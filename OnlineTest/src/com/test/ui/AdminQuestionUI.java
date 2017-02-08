package com.test.ui;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.test.bean.Question;
import com.test.bean.Subject;
import com.test.bl.QuestionLogic;
import com.test.helper.QuestionData;

public class AdminQuestionUI 
{
	private QuestionLogic questionbl=new QuestionLogic();
	private static final String MENU_OPTIONS_QUESTION = "1.Insert a question" +
			"\n2.Update a question" + "\n3.Delete a Question"+ " \n4.Search a Question"+
			"\n5.Display all Questions"+ "\n6.Exit";
	private QuestionData qd=new QuestionData();
	
	public void displayMenu(){
		System.out.println();
		System.out.println(MENU_OPTIONS_QUESTION);
	}
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException{
		Scanner scanner=new Scanner(System.in);		
		int subId=0,ans,questionId;
		String ques,ch1,ch2,ch3,ch4;
		Question question=null;
		 int quesId=0;
		switch(choice)
		{
		case 1:
			question=qd.input();
			questionbl.insert(question);
			System.out.println("One Question Successfully Inserted.");
			break;
		case 2:
			question=qd.update();
			questionbl.update(question.getQuestionId(), question);
			System.out.println("One Question Successfully Updated.");
			break;
		case 3:
			System.out.println("Enter The Question Id You Want To Delete:");
			questionId=scanner.nextInt();
			questionbl.delete(questionId);
			System.out.println("One Question Successfully Deleted.");
			break;
		case 4:
			System.out.println("Enter The Question Id You Want To Search:");
			questionId=scanner.nextInt();
			question=questionbl.search(questionId);
			 System.out.println(question.display());
			break;
		case 5:
			System.out.println("Enter Subject Id:");
			subId=scanner.nextInt();
			List<Question> quesList=questionbl.displayAll(subId);
			for(Question s:quesList)
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

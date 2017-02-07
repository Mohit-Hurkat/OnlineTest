package com.test.ui;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.test.bean.Question;
import com.test.bean.Subject;
import com.test.bl.QuestionLogic;

public class AdminQuestionUI 
{
	private QuestionLogic questionbl=new QuestionLogic();
	private static final String MENU_OPTIONS_QUESTION = "1.Insert a question" +
			"\n 2.Update a question" + "\n 3.Delete a Question"+ " \n 4.Search a Question"+
			"\n 5.Display all Questions"+ "\n 6.Exit";
	public void displayMenu(){
		System.out.println(MENU_OPTIONS_QUESTION);
	}
	public boolean choice(int choice) throws ClassNotFoundException, IOException, SQLException{
		Scanner scanner=new Scanner(System.in);		
		String username;
		int chaa,subId,ans,questionId;
		String ques,ch1,ch2,ch3,ch4;
		Question question=null;
		 int quesId=0;
		switch(choice)
		{
		case 1:
			quesId+=1;
			System.out.println("Enter The Subject Id:");
			subId=scanner.nextInt();
			System.out.println("Write The Question:");
			ques=scanner.next();
			System.out.println("Enter Multiple Choice One:");
			ch1=scanner.next();
			System.out.println("Enter Multiple Choice Second:");
			ch2=scanner.next();
			System.out.println("Enter Multiple Choice Third:");
			ch3=scanner.next();
			System.out.println("Enter Multiple Choice Fourth:");
			ch4=scanner.next();
			System.out.println("Enter Answer Of The Question:");
			ans=scanner.nextInt();
			 question=new Question(quesId, subId, ques, ans, ch1, ch2, ch3, ch4);
			questionbl.insert(question);
			System.out.println("One Question Successfully Inserted.");
			break;
		case 2:
			System.out.println("Enter The Question Id You Want To Update:");
			questionId=scanner.nextInt();
			System.out.println("Enter Subject Id:");
			subId=scanner.nextInt();
			System.out.println("Write The New Question:");
			ques=scanner.next();
			System.out.println("Enter New Multiple Choice One:");
			ch1=scanner.next();
			System.out.println("Enter New Multiple Choice Second:");
			ch2=scanner.next();
			System.out.println("Enter New Multiple Choice Third:");
			ch3=scanner.next();
			System.out.println("Enter New Multiple Choice Fourth:");
			ch4=scanner.next();
			System.out.println("Enter New Answer Of The Question:");
			ans=scanner.nextInt();
			question=new Question(quesId, subId, ques, ans, ch1, ch2, ch3, ch4);
			questionbl.update(questionId, question);
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
			displayMenu();
			break;
		case 6:
			 return false;
			 
		default:
				System.out.println("Invalid Choice");
				 
		}
		return true;
}
}

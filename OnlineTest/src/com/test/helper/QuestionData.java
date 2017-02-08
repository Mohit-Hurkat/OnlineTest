package com.test.helper;

import java.util.Scanner;

import com.test.bean.Question;

public class QuestionData {

	Question question;
	private String question1,choice1,choice2,choice3,choice4;
	private int subjectId,answer;
	
	
	public Question input(){
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter The Subject Id:");
		subjectId=scanner.nextInt();
		System.out.println("Write The Question:");
		question1=scanner.nextLine();
		
		System.out.println("Enter Option 1:");
		choice1=scanner.nextLine();
		System.out.println("Enter Option 2:");
		choice2=scanner.nextLine();
		System.out.println("Enter Option 3:");
		choice3=scanner.nextLine();
		System.out.println("Enter Option 4:");
		choice4=scanner.nextLine();
		System.out.println("Enter Answer Of The Question:");
		answer=scanner.nextInt();
		 question=new Question(0,subjectId, question1, answer, choice1, choice2, choice3, choice4);
		 return question;
	}
}

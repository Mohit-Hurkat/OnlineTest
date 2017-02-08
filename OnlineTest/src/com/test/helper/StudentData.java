package com.test.helper;

import java.util.Scanner;

import com.test.bean.Student;
public class StudentData {
	private Student student;
	private String username,password,name,phone,email;
	Scanner sc=new Scanner(System.in);
	
	public void input(){
		try {
			System.out.println("Enter Username : ");
			username=sc.next();
			System.out.println("Enter Password : ");
			password=sc.next();
			System.out.println("Enter Name : ");
			name=sc.next();
			System.out.println("Enter Phone Number : ");
			phone=sc.next();
			System.out.println("Enter Email : ");
			email=sc.next();
			student=new Student(username,password,name,phone,email);
		} catch (Exception e) {
			System.out.println("Enter Appropriate Information");
		}
		
	}
	public Student update(){
		 try {
			System.out.println("Enter New Details :\n");
			 System.out.println("Enter New Student Name:");
			 name=sc.nextLine();
			 System.out.println("Enter New Password:");
			 password=sc.nextLine();
			 System.out.println("Enter New Phone Number:");
			 phone=sc.nextLine();
			 System.out.println("Enter New E-Mail Id:");
			 email=sc.nextLine();
			 student=new Student(username,password,name, phone, email);
			 return student;
		} catch (Exception e) {
			System.out.println("Enter Appropriate Information");
		}
		 return null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
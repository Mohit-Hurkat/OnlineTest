package com.test.helper;

import java.util.Scanner;

import com.test.bean.Student;
public class StudentData {
	private Student student;
	
	public void input(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username : ");
		String username=sc.next();
		System.out.println("Enter Password : ");
		String password=sc.next();
		System.out.println("Enter Name : ");
		String name=sc.next();
		System.out.println("Enter Phone Number : ");
		String phone=sc.next();
		System.out.println("Enter Email : ");
		String email=sc.next();
		student=new Student(username,password,name,phone,email);
		
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
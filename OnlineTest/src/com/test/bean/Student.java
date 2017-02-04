package com.test.bean;

public class Student extends User{
     private String name;
     private String phone;
     public Student(String username, String password, String name, String phone) {
 		super(username, password);
 		this.name = name;
 		this.phone = phone;
 	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", phone=" + phone + ", getUsername()=" + getUsername() + "]";
	}
	
	
     
}

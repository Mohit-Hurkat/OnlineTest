package com.test.bean;

public class Admin extends User{
	public final static String USER_NAME = "admin";
	
	public Admin(String password) {
		super(USER_NAME, password);
	}
}

package com.test.bl;

import java.sql.SQLException;

import com.test.dao.TestDao;
import com.test.dao.TestDaoImpl;

public class TestLogic {
	private TestDao tdao=new TestDaoImpl();
	
	public boolean giveTest(String username,int sujectId) throws ClassNotFoundException, SQLException{
		return tdao.giveTest(username, sujectId);
	}
	 public int result(String username,int subjectId) throws ClassNotFoundException, SQLException{
		 return  tdao.result(username, subjectId);
	 }
	 public boolean check(int subjectId) throws ClassNotFoundException, SQLException{
		 return tdao.check(subjectId);
	 }

}

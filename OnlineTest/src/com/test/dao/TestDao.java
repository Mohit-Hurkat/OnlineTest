package com.test.dao;

import java.sql.SQLException;

public interface TestDao {
	public boolean giveTest(String username,int sujectId) throws ClassNotFoundException, SQLException;
	public int result(String username,int subjectId) throws ClassNotFoundException, SQLException;
}

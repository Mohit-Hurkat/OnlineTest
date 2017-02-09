package com.test.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface TestDao {
	public boolean giveTest(String username,int sujectId) throws ClassNotFoundException, SQLException;
	public int result(String username,int subjectId) throws ClassNotFoundException, SQLException;
	public boolean check(int subjectId) throws ClassNotFoundException, SQLException;
	public boolean dateCheck(int subject_id) throws SQLException, ClassNotFoundException;
	public boolean result_student(String username) throws ClassNotFoundException, SQLException, IOException;
}

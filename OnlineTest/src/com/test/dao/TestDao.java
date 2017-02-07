package com.test.dao;

import java.sql.SQLException;

public interface TestDao {
	boolean giveTest(String username,int sujectId) throws ClassNotFoundException, SQLException;

}

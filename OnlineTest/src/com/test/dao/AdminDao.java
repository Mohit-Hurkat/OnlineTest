
package com.test.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.test.bean.Admin;

public interface AdminDao {
	public boolean insert(Admin admin)throws IOException, ClassNotFoundException, SQLException;
	public boolean delete(String admin,String username) throws IOException, ClassNotFoundException, SQLException;
	boolean update(String username, String password) throws IOException, ClassNotFoundException, SQLException;
	Admin retrieveAdminRecord() throws IOException, ClassNotFoundException, SQLException;
}

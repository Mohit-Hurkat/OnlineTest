package com.test.bl;

import java.io.IOException;
import java.sql.SQLException;

import com.test.bean.Admin;
import com.test.bean.Student;
import com.test.dao.AdminDao;
import com.test.dao.AdminDaoImpl;



public class AdminLogic {
	private AdminDao adminDao=new AdminDaoImpl();
	
	public boolean update(String username, String password) throws IOException, ClassNotFoundException, SQLException{
		return adminDao.update(username, password);
	}
	
//	public Admin retrieveAdminRecord() throws IOException, ClassNotFoundException, SQLException {
//		return adminDao.retrieveAdminRecord();
//	}
	public boolean insert(Admin admin)throws IOException, ClassNotFoundException, SQLException{
		return adminDao.insert(admin);
	}
	public boolean delete(String admin,String username) throws IOException, ClassNotFoundException, SQLException{
		return adminDao.delete(admin,username);
	}
	public Admin search(String username) throws IOException, ClassNotFoundException, SQLException{
		return adminDao.search(username);
	}
}

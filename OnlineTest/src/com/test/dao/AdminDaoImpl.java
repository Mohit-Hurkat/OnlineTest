package com.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.bean.Admin;
import com.test.helper.JDBCConnection;

public class AdminDaoImpl implements AdminDao{
	private static final String UPDATE_QUERY = "UPDATE ADMIN SET PASSWORD = ? WHERE USERNAME = ?";
	private static final String INSERT_QUERY="INSERT INTO ADMIN(USERNAME,PASSWORD) VALUES(?,?,?,?)";
	private static final String DELETE_QUERY = "DELETE FROM ADMIN WHERE USERNAME = ?";
	private static final String SELECT_QUERY = "SELECT * FROM ADMIN WHERE USERNAME = ?";
	
	@Override
	public boolean insert(Admin admin) throws IOException, ClassNotFoundException, SQLException {
		int numAffectedRows;
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
		preparedStatement.setString(1, admin.getUsername());
		preparedStatement.setString(2, admin.getPassword());
		numAffectedRows = preparedStatement.executeUpdate();  
		//System.out.println(numAffectedRows);
		return numAffectedRows > 0;
	}
	@Override
	public boolean update(String username,Admin admin) throws IOException, ClassNotFoundException, SQLException {
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
		preparedStatement.setString(1, admin.getPassword());
		preparedStatement.setString(2, username);
		preparedStatement.close();
		connection.close();
		return true;
	}
	
	@Override
	public boolean delete(String username) throws IOException, ClassNotFoundException, SQLException {
		int updateCount;
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
		preparedStatement.setString(1, username);
		preparedStatement.execute();
		updateCount = preparedStatement.getUpdateCount();
		preparedStatement.close();
		connection.close();
		return updateCount > 0;
	}
	
	@Override
	public Admin retrieveAdminRecord() throws IOException, ClassNotFoundException, SQLException{
		Admin admin=null;
		//List<Customer> cList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
		preparedStatement.setString(1, Admin.USER_NAME);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			String pass = rs.getString("PASSWORD");
			admin = new Admin(pass);
		}
		preparedStatement.close();
		connection.close();
		return admin;
	}

}

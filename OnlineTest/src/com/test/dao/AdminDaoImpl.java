package com.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.bean.Admin;
import com.test.helper.JDBCConnection;

public class AdminDaoImpl implements AdminDao{
	private static final String UPDATE_QUERY = "UPDATE ADMIN SET USERNAME = ?, PASSWORD = ?,";
	private static final String INSERT_QUERY="INSERT INTO ADMIN(USERNAME,PASSWORD) VALUES(?,?,?,?)";
	private static final String DELETE_QUERY = "DELETE FROM ADMIN WHERE USERNAME = ?";
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
	public boolean update(Admin newAdmin) throws IOException, ClassNotFoundException, SQLException {
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
		preparedStatement.setString(1, newAdmin.getUsername());
		preparedStatement.setString(2, newAdmin.getPassword());
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

}

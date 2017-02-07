package com.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.bean.Subject;
import com.test.helper.JDBCConnection;

public class SubjectDaoImpl implements SubjectDao {
	private static final String INSERT_QUERY="INSERT INTO SUBJECT(subjectId,subjectName) VALUES(?,?)";
	private static final String GET_MAX_ID_QUERY = "SELECT COALESCE(MAX(subjectId), 0) AS COUNT FROM SUJBECT";
	private static final String SELECT_QUERY = "SELECT * FROM SUBJECT WHERE subjectId = ?";   
	private static final String SELECT_ALL_QUERY = "SELECT * FROM SUBJECT";
	private static final String UPDATE_QUERY = "UPDATE SUBJECT SET SUBJECT = ? WHERE subjectId = ?";
	private static final String DELETE_QUERY = "DELETE FROM SUBJECT WHERE subjectId = ?";
	
	@Override
	public boolean insert(Subject subject) throws IOException, ClassNotFoundException, SQLException {
		int numAffectedRows;
		Connection connection = JDBCConnection.getConnection();
		int subjectId = this.getMaxId() + 1;
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
		preparedStatement.setInt(1,subjectId);
		preparedStatement.setString(2, subject.getSubject());
		numAffectedRows = preparedStatement.executeUpdate();  
		//System.out.println(numAffectedRows);
		return numAffectedRows > 0;
		
	}

	private int getMaxId() throws ClassNotFoundException, SQLException {
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_ID_QUERY);
		ResultSet rs = preparedStatement.executeQuery();
		rs.next();
		int result = rs.getInt("COUNT");
		rs.close();
		preparedStatement.close();
		connection.close();
		return result;
	}

	@Override
	public Subject search(int subjectId) throws IOException, ClassNotFoundException, SQLException {
		Subject subject = null;
		List<Subject> subjectList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
		preparedStatement.setInt(1, subjectId);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			String subject1 = rs.getString("SUBJECT");
			subject = new Subject(subjectId, subject1 );
			subjectList.add(subject);
		}
		rs.close();
		preparedStatement.close();
		connection.close();
		return subject;
	}

	@Override
	public List<Subject> displayAll() throws IOException, ClassNotFoundException, SQLException {
		Subject subject = null;
		List<Subject> subjectList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
		preparedStatement.setString(1, subject.getSubject());
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			int subjectId = rs.getInt("SUBJECT_ID");
			String subjectName = rs.getString("SUBJECT");
			Subject subOb = new Subject(subjectId, subjectName);
			subjectList.add(subOb);
		}
		rs.close();
		preparedStatement.close();
		connection.close();
		return subjectList;
	}

	@Override
	public boolean update(int subjectId, Subject subject) throws IOException, ClassNotFoundException, SQLException {
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
		preparedStatement.setString(1, subject.getSubject());
		preparedStatement.setInt(2, subjectId);
		preparedStatement.close();
		connection.close();
		return true;
	}

	@Override
	public boolean delete(int subjectId) throws IOException, ClassNotFoundException, SQLException {
		int updateCount;
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
		preparedStatement.setInt(1, subjectId);
		preparedStatement.execute();
		updateCount = preparedStatement.getUpdateCount();
		preparedStatement.close();
		connection.close();
		return updateCount > 0;
	}
	

}

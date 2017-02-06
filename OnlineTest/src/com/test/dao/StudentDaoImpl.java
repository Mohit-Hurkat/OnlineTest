package com.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.test.bean.Student;
import com.test.helper.JDBCConnection;

public class StudentDaoImpl implements StudentDao{
	private static final String UPDATE_QUERY = "UPDATE STUDENT SET USERNAME = ?, PASSWORD = ?," + 
			"NAME = ? PHONE = ? WHERE USERNAME = ?";
	private static final String DELETE_QUERY = "DELETE FROM STUDENT WHERE USERNAME = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM STUDENT";	
	private static final String SELECT_QUERY = "SELECT * FROM STUDENT WHERE USERNAME = ?";
    private static final String INSERT_QUERY="INSERT INTO STUDENT(USERNAME,PASSWORD,NAME,PHONE) VALUES(?,?,?,?)";
	@Override
	public boolean insert(Student student) throws IOException, ClassNotFoundException, SQLException{
		int numAffectedRows;
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
		preparedStatement.setString(1, student.getUsername());
		preparedStatement.setString(2, student.getPassword());
		preparedStatement.setString(3, student.getName());
		preparedStatement.setString(4, student.getPhone());
		numAffectedRows = preparedStatement.executeUpdate();  
		//System.out.println(numAffectedRows);
		return numAffectedRows > 0;
	}

	@Override
	public Student search(String username)throws IOException,ClassNotFoundException, SQLException {
		Student student=null;
		List<Student> studentList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
		preparedStatement.setString(1, username);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){    //ask why next
			String StudentName = rs.getString("NAME");
			String StudentPhone = rs.getString("PHONE");
			student = new Student(username,"********",StudentName,StudentPhone);
			studentList.add(student);
		}
		return student;
	}

	@Override
	public List<Student> displayAll() throws IOException,ClassNotFoundException, SQLException{
		List<Student> studentList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			String StudentUsername = rs.getString("USERNAME");
			String StudentName = rs.getString("NAME");
			String StudentPhone = rs.getString("PHONE");
			Student student = new Student(StudentUsername,"********",StudentName,StudentPhone);
			studentList.add(student);
		}
		return studentList;
	}

	@Override
	public boolean update(String username, Student newStudent)throws IOException, ClassNotFoundException, SQLException {
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
		preparedStatement.setString(1, newStudent.getUsername());
		preparedStatement.setString(2, newStudent.getPassword());
		preparedStatement.setString(3, newStudent.getName());
		preparedStatement.setString(4, newStudent.getPhone());
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

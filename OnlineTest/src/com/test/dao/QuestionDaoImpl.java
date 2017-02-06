package com.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.bean.Question;
import com.test.helper.JDBCConnection;

public class QuestionDaoImpl implements QuestionDao{
	private static final String UPDATE_QUERY = "UPDATE QUESTIONS SET SUBJECT_ID = ?, QUESTION = ?," + 
			"ANSWER = ? WHERE QUESTION_ID = ?";
	private static final String DELETE_QUERY = "DELETE FROM QUESTIONS WHERE QUESTION_ID = ?";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM QUESTIONS WHERE SUBJECT_ID= ?";	
	private static final String SELECT_QUERY = "SELECT * FROM QUESTIONS WHERE QUESTION_ID = ?";
    private static final String INSERT_QUERY="INSERT INTO QUESTIONS(QUESTION_ID,SUBJECT_ID,QUESTION,ANSWER) VALUES(?,?,?,?)";
    private static final String GET_MAX_ID_QUERY = "SELECT COALESCE(MAX(questionId), 0) AS COUNT FROM QUESTIONS";
   
    @Override
	public boolean insert(Question question) throws IOException, ClassNotFoundException, SQLException{
		int numAffectedRows;
		Connection connection = JDBCConnection.getConnection();
		int questionId = this.getMaxId() + 1;
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
		preparedStatement.setInt(1, questionId);
		preparedStatement.setInt(2, question.getSubjectId());
		preparedStatement.setString(3, question.getQuestion());
		preparedStatement.setInt(4, question.getAnswer());
		numAffectedRows = preparedStatement.executeUpdate();  
		//System.out.println(numAffectedRows);
		return numAffectedRows > 0;
	}
    
    
    @Override
	public Question search(int questionId)throws IOException,ClassNotFoundException, SQLException {
		Question question = null;
		List<Question> questionList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
		preparedStatement.setInt(1, questionId);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			int subjectId = rs.getInt("SUBJECT_ID");
			String question1 = rs.getString("QUESTION");
			int answer = rs.getInt("ANSWER");
			question = new Question(questionId, subjectId, question1, answer);
			questionList.add(question);
		}
		rs.close();
		preparedStatement.close();
		connection.close();
		return question;
	}
    
    @Override
	public List<Question> displayAll(int subjectId) throws IOException,ClassNotFoundException, SQLException{
    	List<Question> questionList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
		preparedStatement.setInt(1, subjectId);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			int questionId = rs.getInt("QUESTION_ID");
			String question1 = rs.getString("QUESTION");
			int answer = rs.getInt("ANSWER");
			Question question = new Question(questionId, subjectId, question1, answer);
			questionList.add(question);
		}
		rs.close();
		preparedStatement.close();
		connection.close();
		return questionList;
	}
    
    @Override
	public boolean update(int questionId, Question question)throws IOException, ClassNotFoundException, SQLException {
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
		preparedStatement.setInt(1, question.getSubjectId());
		preparedStatement.setString(2, question.getQuestion());
		preparedStatement.setInt(3, question.getAnswer());
		preparedStatement.setInt(4, questionId);
		preparedStatement.close();
		connection.close();
		return true;
	}
    
    @Override
	public boolean delete(int questionID) throws IOException, ClassNotFoundException, SQLException {
		int updateCount;
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
		preparedStatement.setInt(1, questionID);
		preparedStatement.execute();
		updateCount = preparedStatement.getUpdateCount();
		preparedStatement.close();
		connection.close();
		return updateCount > 0;
	}
    
    
    
    public int getMaxId() throws SQLException, ClassNotFoundException{
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
}

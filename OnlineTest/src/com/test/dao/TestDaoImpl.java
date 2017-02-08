package com.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;


import com.test.bl.QuestionLogic;
import com.test.helper.JDBCConnection;

public class TestDaoImpl implements TestDao {
	private QuestionLogic questionbl=new QuestionLogic();
	private static final String Set_Value="update QUESTIONS SET VALUE = 0";
	private static final String Call_Question="select * FROM ( "+
			"select * FROM QUESTIONS ORDER BY DBMS_RANDOM.RANDOM)"+
			"WHERE rownum <=4 AND SUBJECT_ID = ? AND VALUE = 0";
	private static final String Set_Value1="update QUESTIONS SET VALUE = 1 where QUESTION_ID = ?";
	private static final String Set_Result="INSERT INTO RESULT(USERNAME,SUBJECT_ID,RESULT) VALUES(?,?,?)";
	private boolean flag=false;
	
	
	public boolean giveTest(String username,int subjectId) throws ClassNotFoundException, SQLException{
		Scanner scanner=new Scanner(System.in);
		 int ans,count=0;
		 int numAffectedRows;
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(Set_Value);
		preparedStatement.executeUpdate();
		PreparedStatement preparedStatement1 = connection.prepareStatement(Call_Question);
		preparedStatement1.setInt(1,subjectId);
		ResultSet rs = preparedStatement1.executeQuery();
		PreparedStatement preparedStatement2 = connection.prepareStatement(Set_Value1);
			while(rs.next()){
				int questionid = rs.getInt(1);
				String question=rs.getString(3);
				String choice1=rs.getString(4);
				String choice2=rs.getString(5);
				String choice3=rs.getString(6);
				String choice4=rs.getString(7);
				int answer=rs.getInt(8);
				System.out.println("Question: "+question+"\n 1. "+
				choice1+"\n 2. "+choice2+"\n 3. "+choice3+"\n 4. "+choice4 );
				do{
				System.out.println("Enter Your Answer Number");
				ans=scanner.nextInt();
				if(ans>4||ans<1){
					System.out.println("Invalid Choice");
					flag=false;
				} 
				else{
					flag=true;
				}
				}while(flag==false);
				if(ans==answer){
					count++;					
				}
				preparedStatement2.setInt(1,questionid);
				preparedStatement2.executeQuery();
			}
			PreparedStatement preparedStatement3 = connection.prepareStatement(Set_Result);
			preparedStatement3.setString(1,username);
			preparedStatement3.setInt(2, subjectId);
			preparedStatement3.setInt(3, count);
			numAffectedRows = preparedStatement3.executeUpdate();
			preparedStatement.close();
			preparedStatement1.close();
			preparedStatement2.close();
			connection.close();
			return numAffectedRows > 0;
	}
}

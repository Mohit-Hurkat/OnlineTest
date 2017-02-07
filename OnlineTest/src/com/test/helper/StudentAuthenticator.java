package com.test.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.Map;

import com.test.bean.Student;
import com.test.dao.StudentDao;
import com.test.dao.StudentDaoImpl;

public class StudentAuthenticator {
	
	public Map.Entry<Student, Boolean> authenticate(String username, String password) throws ClassNotFoundException, IOException, SQLException{
		StudentDao cdao = new StudentDaoImpl();
		Student Student = cdao.search(username);
		if(Student == null)
			return new AbstractMap.SimpleEntry<>(null, false);
		if(password.equals(Student.getPassword()))
			return new AbstractMap.SimpleEntry<>(Student, true);
		return new AbstractMap.SimpleEntry<>(Student, false);
	}
}

package com.test.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.test.bean.Subject;

public interface SubjectDao {
	boolean insert(Subject subject) throws IOException, ClassNotFoundException, SQLException;
	Subject search(int subjectId) throws IOException, ClassNotFoundException, SQLException;
	List<Subject> displayAll(String subject) throws IOException, ClassNotFoundException, SQLException;
	boolean update(int subjectId, Subject subject) throws IOException, ClassNotFoundException, SQLException;
	boolean delete(int subjectId) throws IOException, ClassNotFoundException, SQLException;
}

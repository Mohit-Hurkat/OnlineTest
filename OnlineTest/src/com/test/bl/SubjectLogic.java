package com.test.bl;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import com.test.bean.Subject;
import com.test.dao.SubjectDao;
import com.test.dao.SubjectDaoImpl;

public class SubjectLogic {
	private SubjectDao subjectDao=new SubjectDaoImpl();
	boolean insert(Subject subject) throws IOException, ClassNotFoundException, SQLException{
		return subjectDao.insert(subject);
	}
	Subject search(int subjectId) throws IOException, ClassNotFoundException, SQLException{
		return subjectDao.search(subjectId);
	}
	public List<Subject> displayAll() throws IOException, ClassNotFoundException, SQLException{
		return subjectDao.displayAll();
	}
	boolean update(int subjectId, Subject subject) throws IOException, ClassNotFoundException, SQLException{
		return subjectDao.update(subjectId, subject);
	}
	boolean delete(int subjectId) throws IOException, ClassNotFoundException, SQLException{
		return subjectDao.delete(subjectId);
	}
}
 
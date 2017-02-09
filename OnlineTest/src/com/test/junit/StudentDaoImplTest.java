package com.test.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.bean.Student;
import com.test.dao.StudentDao;
import com.test.dao.StudentDaoImpl;

public class StudentDaoImplTest {
	StudentDao studentDao;
	Student student;
	@Before
	public void setUp() throws Exception {
		studentDao=new StudentDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		studentDao=null;
	}

	@Test(expected = SQLException.class)
	public void positiveNumberTestInsert() throws ClassNotFoundException, IOException, SQLException {
		student=new Student("shikhar","password","shikhar","7845866071","shikhar.bajaj16@gmail.com");
		assertTrue(studentDao.insert(student));
	}
	@Test(expected = SQLException.class)
	public void NegativeNumberTestInsert() throws ClassNotFoundException, IOException, SQLException {
		student=new Student("shikhar1","password","shikhar","7845866071aa","shikhar.bajaj16@gmail.com");
		assertTrue(studentDao.insert(student));
	}

	@Test(expected = SQLException.class)
	public void testSearch() throws ClassNotFoundException, IOException, SQLException {
		assertNotNull(studentDao.search("shikhar1"));
	}
	@Test(expected = SQLException.class)
	public void testSearch1() throws ClassNotFoundException, IOException, SQLException {
		assertNull(studentDao.search("shikhar2"));
	}

	@Test(expected = SQLException.class)
	public void testDisplayAll() throws ClassNotFoundException, IOException, SQLException {
		assertNotNull(studentDao.displayAll());
	}

	@Test(expected = SQLException.class)
	public void testUpdate()throws ClassNotFoundException, IOException, SQLException  {
		Student newStudent=new Student("shikhar12","password","shikhar","7845866071aa","shikhar.bajaj16@gmail.com");
		assertTrue(studentDao.update("admin", newStudent));
	}

	@Test(expected = SQLException.class)
	public void testDeleteTrue() throws ClassNotFoundException, IOException, SQLException {
		//Student newStudent1=new Student("shikhar1234","password","shikhar","7845866071aa","shikhar.bajaj16@gmail.com");
		assertTrue(studentDao.delete("shikhar1"));
	}
	@Test(expected = SQLException.class)
	public void testDeleteFalse() throws ClassNotFoundException, IOException, SQLException {
		//Student newStudent1=new Student("shikhar1234","password","shikhar","7845866071aa","shikhar.bajaj16@gmail.com");
		assertFalse(studentDao.delete("shikhar1212123"));
	}
}

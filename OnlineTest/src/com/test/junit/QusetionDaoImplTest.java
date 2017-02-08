package com.test.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.bean.Question;
import com.test.dao.QuestionDao;
import com.test.dao.QuestionDaoImpl;

public class QusetionDaoImplTest {
   QuestionDao questionDao;
   Question question;
	@Before
	public void setUp() throws Exception {
		questionDao=new QuestionDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		questionDao=null;
	}

	@Test(expected = SQLException.class)
	public void testInsert() throws ClassNotFoundException, IOException, SQLException {
		question=new Question(100,12,"What is 2+2",4,"1","2","3","4");
		assertTrue(questionDao.insert(question));
	}

	@Test(expected = SQLException.class)
	public void testSearchTrue() throws ClassNotFoundException, IOException, SQLException {
		assertNotNull(questionDao.search(2));
	}
	@Test(expected = SQLException.class)
	public void testSearchFalse() throws ClassNotFoundException, IOException, SQLException {
		assertNull(questionDao.search(1000));
	}

	@Test(expected = SQLException.class)
	public void testDisplayAllTrue() throws ClassNotFoundException, IOException, SQLException {
		assertNotNull(questionDao.displayAll(12));
	}
	@Test(expected = SQLException.class)
	public void testDisplayAllFalse() throws ClassNotFoundException, IOException, SQLException {
		assertNull(questionDao.displayAll(1200));
	}

	@Test(expected = SQLException.class)
	public void testUpdateTrue() throws ClassNotFoundException, IOException, SQLException {
		question=new Question(101,12,"What is 2+1",3,"1","2","3","4");
		assertTrue(questionDao.update(100, question));
	}
	@Test(expected = SQLException.class)
	public void testUpdateFalse() throws ClassNotFoundException, IOException, SQLException {
		question=new Question(101,12,"What is 2+1",3,"1","2","3","4");
		assertTrue(questionDao.update(1021, question));
	}

	@Test(expected = SQLException.class)
	public void testDeleteTrue() throws ClassNotFoundException, IOException, SQLException {
		assertTrue(questionDao.delete(1));
	}
	@Test(expected = SQLException.class)
	public void testDeleteFalse() throws ClassNotFoundException, IOException, SQLException {
		assertFalse(questionDao.delete(10001));
	}

}

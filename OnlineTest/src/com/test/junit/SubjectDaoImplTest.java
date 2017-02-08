package com.test.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.bean.Subject;
import com.test.dao.SubjectDao;
import com.test.dao.SubjectDaoImpl;

public class SubjectDaoImplTest {
	 SubjectDao subjectDao;
	    Subject subject;
		@Before
		public void setUp() throws Exception {
			subjectDao=new SubjectDaoImpl();
		}

		@After
		public void tearDown() throws Exception {
		    subjectDao=null;
		}

		@Test(expected = SQLException.class)
		public void testInsert() throws ClassNotFoundException, IOException, SQLException {
			String subject="Trigonometry";
			assertTrue(subjectDao.insert(subject));
		}

		@Test(expected = SQLException.class)
		public void testSearchTrue() throws ClassNotFoundException, IOException, SQLException {
			assertNotNull(subjectDao.search(3));
		}
		@Test(expected = SQLException.class)
		public void testSearchFalse() throws ClassNotFoundException, IOException, SQLException {
			assertNull(subjectDao.search(300));
		}

		@Test(expected = SQLException.class)
		public void testDisplayAll() throws ClassNotFoundException, IOException, SQLException {
			assertNotNull(subjectDao.displayAll());
		}


	

	

}

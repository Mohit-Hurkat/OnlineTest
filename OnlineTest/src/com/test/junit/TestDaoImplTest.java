package com.test.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.dao.TestDao;
import com.test.dao.TestDaoImpl;

public class TestDaoImplTest {
    TestDao testDao;
	@Before
	public void setUp() throws Exception {
		testDao=new TestDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		testDao=null;
	}

//	@Test(expected = SQLException.class)
//	public void testGiveTestTrue() throws ClassNotFoundException, SQLException {
//		assertTrue(testDao.giveTest("shikhar",2));
//	}
//	@Test(expected = SQLException.class)
//	public void testGiveTestFalse() throws ClassNotFoundException, SQLException {
//		assertFalse(testDao.giveTest("shikhar121231",2000));
//	}
//
//	@Test(expected = SQLException.class)
//	public void testResultTrue() throws ClassNotFoundException, SQLException {
//		assertNotNull(testDao.result("shikhar", 2));
//	}
//	@Test(expected = SQLException.class)
//	public void testResultFalse() throws ClassNotFoundException, SQLException {
//		assertNull(testDao.result("shikhar23452353", 3242));
//	}
	
	@Test(expected = SQLException.class)
	public void testDateT() throws ClassNotFoundException, SQLException {
		assertTrue(testDao.dateCheck(3));
	}
	
	@Test(expected = SQLException.class)
	public void testDateF() throws ClassNotFoundException, SQLException {
		assertFalse(testDao.dateCheck(3));
	}
	


}

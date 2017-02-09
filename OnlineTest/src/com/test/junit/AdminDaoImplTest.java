package com.test.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.bean.Admin;
import com.test.bean.Student;
import com.test.dao.AdminDao;
import com.test.dao.AdminDaoImpl;
import com.test.dao.StudentDao;

public class AdminDaoImplTest {
	AdminDao adminDao;
	Admin admin;
	@Before
	public void setUp() throws Exception {
		adminDao=new AdminDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		adminDao=null;
	}

	@Test(expected = SQLException.class)
	public void testUpdateTrue() throws ClassNotFoundException, IOException, SQLException {
		assertTrue(adminDao.update("admin","admin@123"));
	}
	@Test(expected = SQLException.class)
	public void testUpdateFalse() throws ClassNotFoundException, IOException, SQLException {
		assertFalse(adminDao.update("admi5765n","admin@123"));
	}

	@Test(expected = SQLException.class)
	public void testSearchTrue() throws ClassNotFoundException, IOException, SQLException {
		assertNotNull(adminDao.search("admin"));
	}
	@Test(expected = SQLException.class)
	public void testSearchFalse() throws ClassNotFoundException, IOException, SQLException {
		assertNull(adminDao.search("admin1231341"));
	}
}

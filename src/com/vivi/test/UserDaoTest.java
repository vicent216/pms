package com.vivi.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vivi.dao.impl.UserDaoImpl;
import com.vivi.domain.User;

public class UserDaoTest {

	@Test
	public void test() {
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.findUser("vivi","123");
		assertNotNull(user);
	}
	
	@Test
	public void test1() {
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.findUser("vivi1","123");
		assertNull(user);
	}
	
	public void test2() {
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.findUser("vivi1","1234");
		assertNull(user);
	}

}

package com.vivi.service.impl;

import com.vivi.dao.impl.UserDaoImpl;
import com.vivi.domain.User;

public class UserServiceImpl {
	UserDaoImpl dao = new UserDaoImpl();

	public User login(String username, String password) {
		return dao.findUser(username, password);
		
	}

}

package com.vivi.dao.impl;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;

import com.vivi.domain.User;
import com.vivi.exception.UserDaoException;
import com.vivi.util.Dom4JUtil;

public class UserDaoImpl {
	public User findUser(String username, String password) {
		try {
			Document doc = Dom4JUtil.getDocument("users.xml");
			String XPath = "//user[@username='"+username+"' and @password='"+password+"']";
			Node node = doc.selectSingleNode(XPath);
			if(node == null) {
				return null;
			} else {
				User user = new User();
				user.setUsername(node.valueOf("@username"));
				user.setPassword(node.valueOf("@password"));
				return user;
			}
			
		} catch (DocumentException e) {
			throw new UserDaoException(e);
		}
	}

}

package com.vivi.exception;

import org.dom4j.DocumentException;

public class UserDaoException extends RuntimeException {

	public UserDaoException() {
		super();
	}

	public UserDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDaoException(String message) {
		super(message);
	}

	public UserDaoException(Throwable cause) {
		super(cause);
	}



}

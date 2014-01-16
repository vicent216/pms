package com.vivi.exception;

public class StudentDaoException extends RuntimeException {

	public StudentDaoException() {
		super();
	}

	public StudentDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentDaoException(String message) {
		super(message);
	}

	public StudentDaoException(Throwable cause) {
		super(cause);
	}

}

package com.dyashin.jdbcmaven.usermanagement.exception;

public class InvalidPasswordException extends RuntimeException {
	public InvalidPasswordException(String msg) {
		super(msg);
	}

}

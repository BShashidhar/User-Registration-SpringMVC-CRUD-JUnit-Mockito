package com.userregistration.exception;

@SuppressWarnings("serial")
public class UserDoesNotExistException extends Exception {
	public static String message = "user already exists !..please login";

	public UserDoesNotExistException() {

	}

	@SuppressWarnings("static-access")
	public UserDoesNotExistException(String message) {
		this.message = message;
	}
}

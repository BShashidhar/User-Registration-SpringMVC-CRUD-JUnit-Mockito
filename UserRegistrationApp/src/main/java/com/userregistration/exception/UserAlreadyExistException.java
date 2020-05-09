package com.userregistration.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends Exception {
public static  String message="user already exists !..please login";


public UserAlreadyExistException()
{
	
}
@SuppressWarnings("static-access")
public UserAlreadyExistException(String message)
{
	this.message=message;
}
}

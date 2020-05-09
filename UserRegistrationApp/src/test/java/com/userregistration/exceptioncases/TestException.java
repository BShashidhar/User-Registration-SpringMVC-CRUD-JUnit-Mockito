package com.userregistration.exceptioncases;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.userregistration.exception.UserAlreadyExistException;
import com.userregistration.exception.UserDoesNotExistException;
import com.userregistration.model.User;
import com.userregistration.service.LoginServiceImpl;

import junit.framework.Assert;

public class TestException {
	@InjectMocks
	private LoginServiceImpl loginServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testForUserRegistration() throws UserAlreadyExistException {

		User user = new User();
		user.setUserName("admin");
		user.setUserPassword("james");
		loginServiceImpl.register(user);
		Assert.assertEquals(UserAlreadyExistException.message, "user already exists !..please login");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testForUserLogin() throws UserDoesNotExistException {
		User user = new User();
		user.setUserName("admin");
		user.setUserPassword("james");
		loginServiceImpl.login(user.getUserName(), user.getUserPassword());
		Assert.assertEquals(UserDoesNotExistException.message, "user already exists !..please login");
	}
}

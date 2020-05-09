package com.social.imageApp.account.EntityValidationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.social.imageApp.account.UtilTestClass.MasterData;
import com.social.imageApp.account.model.User;

public class EntityValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void testUsersSuccess() {
    	User user = MasterData.getDetails();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testUserFailed() {
    	User user = MasterData.getDetails();
    	user.setUserEmail(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }
    
    @Test
    public void testUserFailed1() {
    	User user = MasterData.getDetails();
    	user.setUserName(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }
    
    @Test
	public void testUserNameLength() {
    	User user = MasterData.getDetails();
		user.getUserName();
		int maxChar = 5;
		boolean usernameLength = ((user.getUserName().length()) >= maxChar);
		assertEquals(usernameLength, true);
	}
    
    @Test
	public void testPasswordLength() {
    	User user = MasterData.getDetails();
		user.getUserPassword();
		int passwordLength = 10;
		assertEquals(passwordLength, user.getUserPassword().length());
	}
    @Test
    public void testActiveUser() {
    	User user = MasterData.getDetails();
    	user.isActive();
    	boolean reslut = true;
    	assertEquals(reslut, user.isActive());
    }
}
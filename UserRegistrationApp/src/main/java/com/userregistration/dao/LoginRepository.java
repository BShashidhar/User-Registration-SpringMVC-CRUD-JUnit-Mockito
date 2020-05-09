package com.userregistration.dao;

import com.userregistration.model.User;

public interface LoginRepository {

	boolean register(User user);
	boolean login(String userName,String password);
	boolean resetPassword(String userName,String password);
}

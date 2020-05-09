package com.userregistration.dao;

import java.util.List;

import com.userregistration.model.User;

public interface UserDao {	
	void saveUser(User user);
	User getUser(int userId);
	List<User> listUser();
	void updateUser(int userId,User user);
	void deleteUser(int userId);
}

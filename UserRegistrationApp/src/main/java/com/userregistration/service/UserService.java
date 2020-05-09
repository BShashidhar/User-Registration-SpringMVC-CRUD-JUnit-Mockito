package com.social.imageApp.account.service;

import java.util.List;

import com.social.imageApp.account.model.User;

public interface UserService {
	Boolean saveUser(User user);
	User getUser(int userId);
	List<User> listUser();
	void updateUser(int userId,User user);
	void deleteUser(int userId);
}

package com.userregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userregistration.dao.UserDao;
import com.userregistration.model.User;

@Service("UserService")
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public Boolean saveUser(User user) {
		return null;		
		
	}
	
	@Override
	public User getUser(int userId) {
		return null;		

	}

	@Override
	public List<User> listUser() {
		return null;
		
	}

	@Override
	public void updateUser(int userId,User user) {		
		
	}

	@Override
	public void deleteUser(int userId) {
		
	}
}

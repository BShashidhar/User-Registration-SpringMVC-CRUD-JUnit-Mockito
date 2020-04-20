package com.social.imageApp.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.social.imageApp.account.dao.UserDao;
import com.social.imageApp.account.model.User;

@Service("UserService")
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public Boolean saveUser(User user) {		
		userDao.saveUser(user);
		return true;
	}
	
	@Override
	public User getUser(int userId) {		
		return userDao.getUser(userId);
	}

	@Override
	public List<User> listUser() {
		return userDao.listUser();
	}

	@Override
	public void updateUser(int userId,User user) {		
		userDao.updateUser(userId, user);
	}

	@Override
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
	}
}

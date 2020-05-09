package com.social.imageApp.account.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.social.imageApp.account.model.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		
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

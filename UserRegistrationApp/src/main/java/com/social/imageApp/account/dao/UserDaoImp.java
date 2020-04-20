package com.social.imageApp.account.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		sessionFactory.getCurrentSession().save(user);
	}
	@Override
	public User getUser(int userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}
	@Override
	public List<User> listUser() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query<User> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void updateUser(int userId,User user) {		
		Session session = sessionFactory.getCurrentSession();
		User uu = session.byId(User.class).load(userId);
		
		uu.setProfilePicture(user.getProfilePicture());
		uu.setUserEmail(user.getUserEmail());
		uu.setUserFirstName(user.getUserFirstName());
		uu.setUserLastName(user.getUserLastName());
		uu.setUserName(user.getUserName());		
		uu.setUserPassword(user.getUserPassword());		
		session.flush();
	}

	@Override
	public void deleteUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(userId);
		session.delete(user);		
	}
}

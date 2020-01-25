package com.sprhiber.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sprhiber.model.User;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public List<User> list() {
		Query query=sessionFactory.getCurrentSession().createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> list=(List<User>)query.list();
		return list;
	}
	
	@Transactional
	public void deleteUser(Long id) {
		User user=(User)sessionFactory.getCurrentSession().load(User.class,id);
		if(null!=user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}
	
	@Transactional
	public User getUser(Long id) {
		User user=(User)sessionFactory.getCurrentSession().load(User.class,id);
		return user;
	}
	
	@Transactional
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

}
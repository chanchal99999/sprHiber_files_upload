package com.sprhiber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprhiber.dao.UserDao;
import com.sprhiber.model.User;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}

	public List<User> list(){
		return userDao.list();
	}
	public void delete(Long id) {
		userDao.deleteUser(id);		
	}
	public void update(User user) {
		userDao.update(user);		
	}
	public User getUser(Long id) {
		return userDao.getUser(id);
	}
}

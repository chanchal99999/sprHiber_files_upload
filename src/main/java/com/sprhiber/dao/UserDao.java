package com.sprhiber.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sprhiber.model.User;

@Repository
@Component
public interface UserDao {
	void save(User user);
	List<User> list();
	public void deleteUser(Long id);
	void update(User user);
	public User getUser(Long id);
}

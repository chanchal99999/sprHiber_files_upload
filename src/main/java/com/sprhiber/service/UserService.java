package com.sprhiber.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sprhiber.model.User;


@Service
@Component
public interface UserService {
	void save(User user);
	List<User> list();
	void delete(Long id);
	void update(User user);
	User getUser(Long id);
}

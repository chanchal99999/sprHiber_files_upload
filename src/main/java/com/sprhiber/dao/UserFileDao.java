package com.sprhiber.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sprhiber.model.UserFile;

@Repository
@Component
public interface UserFileDao {
	void save(UserFile userFile);
	List<UserFile> list();
	public UserFile getUserFile(Long id);
	void remove(Long id);
	void update(UserFile userFile);
}

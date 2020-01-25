package com.sprhiber.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sprhiber.model.UserFile;

@Service
@Component
public interface UserFileService {

	void save(UserFile userFile);
	List<UserFile> list();
	void remove(Long id);
	UserFile getUserFile(Long id);
	void update(UserFile userFile);
}

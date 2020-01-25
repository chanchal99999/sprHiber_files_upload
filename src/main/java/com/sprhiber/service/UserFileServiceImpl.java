package com.sprhiber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprhiber.dao.UserFileDao;
import com.sprhiber.model.UserFile;

@Service("userFileService")
public class UserFileServiceImpl implements UserFileService {

	@Autowired
	UserFileDao userFiledao;
	
	public void save(UserFile userFile) {
			userFiledao.save(userFile);
	}
	public List<UserFile> list() {
		List<UserFile> list=userFiledao.list();
		return list;
	}

	public void remove(Long id) {
		userFiledao.remove(id);
	}

	public UserFile getUserFile(Long id) {
		UserFile userFile=userFiledao.getUserFile(id);
		return userFile;
	}

	public void update(UserFile userFile) {
		userFiledao.update(userFile);		
	}
}

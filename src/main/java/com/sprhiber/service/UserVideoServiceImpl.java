package com.sprhiber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprhiber.dao.UserVideoDao;
import com.sprhiber.model.UserVideo;

@Service("userVideoService")
public class UserVideoServiceImpl implements UserVideoService {

	@Autowired
	UserVideoDao userVideoDao;
	public void saveVideo(UserVideo userVideo) {
		userVideoDao.saveVideo(userVideo);
	}

	public List<UserVideo> allUserVideo() {
		List<UserVideo> list=userVideoDao.allUserVideo();
		return list;
	}

	public void update(UserVideo userVideo) {
		userVideoDao.update(userVideo);
	}

	public UserVideo getUserVideo(Long id) {
		return userVideoDao.getUserVideo(id);
	}

	public void remove(Long id) {
		userVideoDao.remove(id);
	}

}

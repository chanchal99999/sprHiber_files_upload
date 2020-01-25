package com.sprhiber.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sprhiber.model.UserVideo;
@Repository
@Component
public interface UserVideoDao {
	void saveVideo(UserVideo userVideo);
	List<UserVideo> allUserVideo();
	void update(UserVideo userVideo);
	UserVideo getUserVideo(Long id);
	void remove(Long id);
}

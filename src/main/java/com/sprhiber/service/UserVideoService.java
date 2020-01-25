package com.sprhiber.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sprhiber.model.UserVideo;

@Service
@Component
public interface UserVideoService {

	void saveVideo(UserVideo userVideo);
	List<UserVideo> allUserVideo();
	void update(UserVideo uploadVideo);
	UserVideo getUserVideo(Long id);
	void remove(Long id);
}

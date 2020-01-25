package com.sprhiber.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sprhiber.model.UserVideo;

@Repository
public class UserVideoDaoImp implements UserVideoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveVideo(UserVideo userVideo) {
		sessionFactory.getCurrentSession().save(userVideo);
	}

	@Transactional
	public List<UserVideo> allUserVideo() {
		Query query=sessionFactory.getCurrentSession().createQuery("from UserVideo");
		@SuppressWarnings("unchecked")
		List<UserVideo> list=(List<UserVideo>)query.list();
		return list;		
	}
	@Transactional
	public void update(UserVideo userVideo) {
		sessionFactory.getCurrentSession().saveOrUpdate(userVideo);		
	}
	@Transactional
	public UserVideo getUserVideo(Long id) {
		UserVideo userVideo=(UserVideo)sessionFactory.getCurrentSession().load(UserVideo.class,id);
		return userVideo;
	}
	@Transactional
	public void remove(Long id) {
		UserVideo userVideo=(UserVideo)sessionFactory.getCurrentSession().load(UserVideo.class, id);
		if(userVideo!=null) {
			this.sessionFactory.getCurrentSession().delete(userVideo);
		}
	}
	
}

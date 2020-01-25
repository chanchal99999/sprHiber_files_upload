package com.sprhiber.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sprhiber.model.UserFile;

@Repository
public class UserFileDaoImpl implements UserFileDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void save(UserFile userFile) {
		sessionFactory.getCurrentSession().save(userFile); //saveOrUpdate(userFile);

	}
	@Transactional
	public List<UserFile> list() {
		Query query=sessionFactory.getCurrentSession().createQuery("from UserFile");
		@SuppressWarnings("unchecked")
		List<UserFile> list=(List<UserFile>)query.list();
		return list;
	}
	@Transactional
	public void update(UserFile userFile) {
			sessionFactory.getCurrentSession().saveOrUpdate(userFile);
	}
	@Transactional
	public UserFile getUserFile(Long id) {
		UserFile userFile=(UserFile)sessionFactory.getCurrentSession().load(UserFile.class,id);
		return userFile;
	}
	@Transactional
	public void remove(Long id) {
		UserFile userFile=(UserFile)sessionFactory.getCurrentSession().load(UserFile.class,id);
		if(null!=userFile) {
			this.sessionFactory.getCurrentSession().delete(userFile);
		}
	}
}
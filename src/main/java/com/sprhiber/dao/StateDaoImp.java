package com.sprhiber.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sprhiber.model.State;

@Repository
public class StateDaoImp implements StateDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void save(State state) {
		sessionFactory.getCurrentSession().saveOrUpdate(state);
	}
	@Transactional
	public List<State> allState() {
		Query query=sessionFactory.getCurrentSession().createQuery("from State");
		@SuppressWarnings("unchecked")
		List<State> list=query.list();
		return list;
	}
	@Transactional
	public State getState(Long stateId) {
		State state=(State)sessionFactory.getCurrentSession().load(State.class, stateId);
		return state;
	}
	@Transactional
	public void delete(Long stateId) {
		State state=(State)sessionFactory.getCurrentSession().load(State.class, stateId);
		if(state!=null) {
			this.sessionFactory.getCurrentSession().delete(state);
		}
	}
}

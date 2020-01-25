package com.sprhiber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprhiber.dao.StateDao;
import com.sprhiber.model.State;

@Service("stateService")
public class StateServiceImpl implements StateService {

	@Autowired
	StateDao stateDao;
	public void save(State state) {
		stateDao.save(state);;
	}

	public List<State> allState() {
		return stateDao.allState();
	}

	public State getState(Long stateId) {
		return stateDao.getState(stateId);
	}

	public void delete(Long stateId) {
		stateDao.delete(stateId);
	}

}

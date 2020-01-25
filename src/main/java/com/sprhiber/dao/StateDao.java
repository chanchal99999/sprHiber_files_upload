package com.sprhiber.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sprhiber.model.State;

@Repository
@Component
public interface StateDao {
	void save(State state);
	List<State> allState();
	State getState(Long stateId);
	void delete(Long stateId);
}

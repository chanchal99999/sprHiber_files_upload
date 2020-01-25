package com.sprhiber.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sprhiber.model.State;

@Service
@Component
public interface StateService {
	void save(State state);
	List<State> allState();
	State getState(Long stateId);
	void delete(Long stateId);
}

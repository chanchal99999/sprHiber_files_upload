package com.sprhiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false) 
@Table(name="STATE_TBL")
public class State {
	
	@Override
	public String toString() {
		return stateName;
	}

	@Id
	@GeneratedValue
	@Column(name="STATE_ID")
	//@OneToMany
	private Long stateId;
	
	@Column(name="STATE_NAME")
	private String stateName;

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}

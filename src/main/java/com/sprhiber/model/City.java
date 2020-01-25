package com.sprhiber.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
@Table(name="CITY_TBL")
public class City {
	@Id
	@GeneratedValue
	@Column(name="CITY_ID")
	private Long cityId;
	
	@Column(name="CITY_NAME")
	private String cityName;
	
	//@Column(name="STATE_ID")
	@ManyToOne(cascade=CascadeType.ALL) 
	private State state;
	
	@Column(name="STATE_ID")
	private Long stateId;
	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return cityName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}

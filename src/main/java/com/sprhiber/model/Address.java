package com.sprhiber.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
@Table(name="ADDRESS_TBL")
public class Address {
	@Id
	@GeneratedValue
	@Column(name="ADD_ID")
	private Long addId;
	
	@Column(name="USER_NAME")
	private String userName;

	@Column(name="VILL_NAME")
	private String villName;
	
	@ManyToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="STATE_ID")
	private State state;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CITY_ID")
	private City city;
	
	public Long getAddId() {
		return addId;
	}

	public void setAddId(Long addId) {
		this.addId = addId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVillName() {
		return villName;
	}

	public void setVillName(String villName) {
		this.villName = villName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addId=" + addId + ", userName=" + userName + ", villName=" + villName + ", state=" + state
				+ ", city=" + city + "]";
	}
}

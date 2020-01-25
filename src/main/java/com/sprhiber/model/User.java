package com.sprhiber.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Proxy(lazy=false) 
@Table(name = "TBL_USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;
	
	@Column(name = "USER_NAME")
	@Size(max=20,min=3,message="User Name is Invalid")
	@NotEmpty(message="Please Enter Your Name")
	private String name;
	
	/*@Column(name = "USER_EMAIL", unique = true)*/
	@Column(name = "USER_EMAIL")
	@Email(message="Enter Valid Email")
	@NotEmpty(message="Please Enter your email")
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

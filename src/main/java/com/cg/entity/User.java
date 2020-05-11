package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	//login information
	@Id
	private String userId;
	
	@Column
	private String password;
	

	
	public User() {
	
		// TODO Auto-generated constructor stub
	}

	

	public User(String userId,String password) {
		super();
		this.userId = userId;
		this.password = password;
	
	}

	


	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}

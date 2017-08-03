package com.cisco.cbv.blogitaway.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JWTToken {

	@Id
	private String user;
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}

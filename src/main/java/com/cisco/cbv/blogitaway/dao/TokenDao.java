package com.cisco.cbv.blogitaway.dao;

import com.cisco.cbv.blogitaway.model.JWTToken;
import com.cisco.cbv.blogitaway.model.User;

public interface TokenDao {

	public void store(String user, String token);

	public JWTToken read(String user);

	public void delete(String user);

	public void update(JWTToken jwtToken);
}

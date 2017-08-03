package com.cisco.cbv.blogitaway.dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.cisco.cbv.blogitaway.model.User;

public interface UserDao {
	public void create(User user) throws NoSuchAlgorithmException;

	public User read(String userName);
	
	public List<User> getAllUsers();
	
	public User updateUser(String userName, User user);

	public boolean authenticate(User user);

}

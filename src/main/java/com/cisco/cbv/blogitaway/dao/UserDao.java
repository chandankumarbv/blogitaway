package com.cisco.cbv.blogitaway.dao;

import java.util.List;

import com.cisco.cbv.blogitaway.model.User;

public interface UserDao {
	public void create(User user);

	public User read(int userId);
	
	public List<User> getAllUsers();
	
	public void updateUser(int userId, User user);

}

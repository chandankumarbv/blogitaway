package com.cisco.cbv.blogitaway.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cisco.cbv.blogitaway.model.User;

public class UserDaoImpl implements UserDao {
	private static UserDaoImpl instance;

	private UserDaoImpl() {
	}

	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}

	@Override
	public void create(User user) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	@Override
	public User read(int userId) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		User user = entityManager.find(User.class, userId);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		Query query = entityManager.createQuery("SELECT u from User u");
		List<User> userList = query.getResultList();
		return userList;
	}

	@Override
	public void updateUser(int userId, User user) {
		// TODO Auto-generated method stub

	}

}

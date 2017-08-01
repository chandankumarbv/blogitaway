package com.cisco.cbv.blogitaway.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	public void create(User user) throws NoSuchAlgorithmException {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		encryptPasswd(user);
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	private void encryptPasswd(User user) throws NoSuchAlgorithmException {
		String clearTextPassword = user.getPassword();
		String hashedPasswd = encrypt(clearTextPassword);
		user.setPassword(hashedPasswd);
	}

	private String encrypt(String clearTextPassword) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(clearTextPassword.getBytes());
		String hashedPasswd = new String(messageDigest.digest());
		return hashedPasswd;
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

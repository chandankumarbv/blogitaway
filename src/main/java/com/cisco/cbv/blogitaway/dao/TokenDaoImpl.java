package com.cisco.cbv.blogitaway.dao;

import javax.persistence.EntityManager;

import com.cisco.cbv.blogitaway.model.JWTToken;
import com.cisco.cbv.blogitaway.model.User;

public class TokenDaoImpl implements TokenDao {

	private static TokenDaoImpl instance;

	private TokenDaoImpl() {
	}

	public static TokenDao getInstance() {
		if (instance == null) {
			instance = new TokenDaoImpl();
		}
		return instance;
	}

	@Override
	public void store(String user, String token) {
		JWTToken jwtToken = new JWTToken();
		jwtToken.setUser(user);
		jwtToken.setToken(token);
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(jwtToken);
		em.getTransaction().commit();
	}

	@Override
	public JWTToken read(String user) {
		EntityManager em = PersistenceUtil.getEntityManager();
		JWTToken jwtToken = em.find(JWTToken.class, user);
		return jwtToken;
	}

	@Override
	public void delete(String user) {
		EntityManager em = PersistenceUtil.getEntityManager();

		JWTToken jwtToken = read(user);
		if (jwtToken != null) {
			em.getTransaction().begin();
			JWTToken managedJwtToken = em.merge(jwtToken);
			if (managedJwtToken != null) {
				em.remove(managedJwtToken);
			}
			em.getTransaction().commit();

		}
	}

	@Override
	public void update(JWTToken jwtToken) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(jwtToken);
		em.getTransaction().commit();
	}

}

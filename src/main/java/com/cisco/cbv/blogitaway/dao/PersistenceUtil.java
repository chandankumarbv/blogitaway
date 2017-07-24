package com.cisco.cbv.blogitaway.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

	private static EntityManagerFactory emFactory;

	private PersistenceUtil() {
	}

	private static EntityManagerFactory getEMFactory() {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory("library");
		}
		return emFactory;
	}

	public static EntityManager getEntityManager() {
		return getEMFactory().createEntityManager();
	}
}

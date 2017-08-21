package com.cisco.cbv.blogitaway.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class PersistenceUtil {

	private static EntityManagerFactory emFactory;
	private static Datastore ds;

	private PersistenceUtil() {
	}

	public static Datastore getDataStore() {
		if (ds == null) {
			MongoClient mongoClient = new MongoClient("db");
			Morphia morphia = new Morphia();
			ds = morphia.createDatastore(mongoClient, "blogitaway");
		}
		return ds;
	}

	@Deprecated
	private static EntityManagerFactory getEMFactory() {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory("blogitaway");
		}
		throw new RuntimeException("STILLL USING JPA");
		// return emFactory;
	}

	@Deprecated
	public static EntityManager getEntityManager() {
		return getEMFactory().createEntityManager();
	}
}

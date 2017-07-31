package com.cisco.cbv.blogitaway.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cisco.cbv.blogitaway.model.Blog;
import com.cisco.cbv.blogitaway.model.Comment;

public class BlogDaoImpl implements BlogDao {

	private static BlogDaoImpl instance;

	private BlogDaoImpl() {
	}

	public static BlogDao getInstance() {
		if (instance == null) {
			instance = new BlogDaoImpl();
		}
		return instance;
	}

	@Override
	public void create(Blog blog) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(blog);
		entityManager.getTransaction().commit();
	}

	@Override
	public Blog read(int blogId) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		Blog blog = entityManager.find(Blog.class, blogId);
		return blog;
	}

	@Override
	public List<Blog> getAllBlogs() {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		Query query = entityManager.createQuery("SELECT b from Blog b");
		List<Blog> blogList = query.getResultList();
		return blogList;
	}

	@Override
	public List<Comment> getAllComments(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

}

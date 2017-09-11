package com.cisco.cbv.blogitaway.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cisco.cbv.blogitaway.model.Blog;
import com.cisco.cbv.blogitaway.model.Comment;
import com.cisco.cbv.blogitaway.model.PagingConfig;
import com.cisco.cbv.blogitaway.model.User;

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
		User owner = blog.getOwner();
		if(owner!=null && owner.getUserName()!=null) {
			User managedUser = entityManager.find(User.class, owner.getUserName());
			blog.setOwner(managedUser);
		}
		entityManager.getTransaction().begin();
		entityManager.persist(blog);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Blog> getAllBlogs() {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		Query query = entityManager.createQuery("SELECT b from Blog b");
		List<Blog> blogList = query.getResultList();
		return blogList;
	}

	@Override
	public List<Comment> getAllComments(String blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogs(PagingConfig paging) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		Query query = entityManager.createQuery("SELECT b from Blog b");
		
		query.setMaxResults(paging.getLimit() - paging.getOffset());
		query.setFirstResult(paging.getOffset());
		
		List<Blog> blogList = query.getResultList();
		return blogList;
	}

	@Override
	public List<Blog> searchBlogs(PagingConfig pagingConfig, String searchString) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		Query query = entityManager.createQuery("SELECT b from Blog b WHERE b.content LIKE :searchString");
		query.setParameter("searchString", "%"+searchString+"%");
		query.setMaxResults(pagingConfig.getLimit() - pagingConfig.getOffset());
		query.setFirstResult(pagingConfig.getOffset());
		
		List<Blog> blogList = query.getResultList();
		return blogList;
	}

	@Override
	public Blog read(String blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogsByUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}

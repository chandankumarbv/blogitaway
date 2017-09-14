package com.cisco.cbv.blogitaway.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.QueryResults;

import com.cisco.cbv.blogitaway.model.Blog;
import com.cisco.cbv.blogitaway.model.Comment;
import com.cisco.cbv.blogitaway.model.PagingConfig;
import com.cisco.cbv.blogitaway.model.User;

public class BlogDaoMongoImpl extends BasicDAO<Blog, String> implements BlogDao {
	private static BlogDao instance;

	private BlogDaoMongoImpl() {
		super(Blog.class, PersistenceUtil.getDataStore());
	}

	public static BlogDao getInstance() {
		if (instance == null) {
			instance = new BlogDaoMongoImpl();
		}
		return instance;
	}

	@Override
	public void create(Blog blog) {

		// EntityManager entityManager = PersistenceUtil.getEntityManager();
		// User owner = blog.getOwner();
		// if(owner!=null && owner.getUserName()!=null) {
		// User managedUser = entityManager.find(User.class, owner.getUserName());
		// blog.setOwner(managedUser);
		// }
		// entityManager.getTransaction().begin();
		// entityManager.persist(blog);
		// entityManager.getTransaction().commit();
		blog.setId(new ObjectId().toString());
		save(blog);
	}

	@Override
	public Blog read(String blogId) {
		return get(blogId);
	}

	@Override
	public List<Blog> getAllBlogs() {
		QueryResults<Blog> queryResults = find();
		return queryResults.asList();
	}

	@Override
	public List<Blog> getBlogsByUser(String userName) {
		User user = new User();
		user.setUserName(userName);
		QueryResults<Blog> results = find(createQuery().field("owner").equal(user));
		return results.asList();
	}

	@Override
	public List<Comment> getAllComments(String blogId) {
		return CommentDaoImpl.getInstance().readCommentsOfBlog(blogId);
	}

	@Override
	public List<Blog> getBlogs(PagingConfig paging) {
		QueryResults<Blog> results = find(createQuery().offset(paging.getOffset()).limit(paging.getLimit()));
		return results.asList();
	}

	@Override
	public List<Blog> searchBlogs(PagingConfig pagingConfig, String query) {
		QueryResults<Blog> results = find(createQuery().field("content").contains(query));
		return results.asList();
	}
}

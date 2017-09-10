package com.cisco.cbv.blogitaway.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.QueryResults;

import com.cisco.cbv.blogitaway.model.Blog;
import com.cisco.cbv.blogitaway.model.Comment;

public class CommentDaoImpl extends BasicDAO<Comment, String> implements CommentDao {

	private static CommentDaoImpl instance;

	private CommentDaoImpl() {
		super(Comment.class, PersistenceUtil.getDataStore());
	}

	@Override
	public void create(Comment comment) {
		save(comment);
	}

	@Override
	public Comment readComment(String commentId) {
		return get(commentId);
	}

	@Override
	public List<Comment> readCommentsOfBlog(String blogId) {
		Blog blog = new Blog();
		blog.setId(blogId);
		QueryResults<Comment> results = find(createQuery().field("blog").equal(blog));
		return results.asList();
	}

	public static CommentDao getInstance() {
		if (instance == null) {
			instance = new CommentDaoImpl();
		}
		return instance;
	}

}

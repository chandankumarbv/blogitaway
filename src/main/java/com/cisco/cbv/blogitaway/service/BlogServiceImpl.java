package com.cisco.cbv.blogitaway.service;

import java.util.List;

import com.cisco.cbv.blogitaway.dao.BlogDao;
import com.cisco.cbv.blogitaway.dao.BlogDaoMongoImpl;
import com.cisco.cbv.blogitaway.dao.CommentDao;
import com.cisco.cbv.blogitaway.dao.CommentDaoImpl;
import com.cisco.cbv.blogitaway.model.Blog;
import com.cisco.cbv.blogitaway.model.BlogNotFoundException;
import com.cisco.cbv.blogitaway.model.BlogitAwayException;
import com.cisco.cbv.blogitaway.model.Comment;
import com.cisco.cbv.blogitaway.model.CommentNotFoundException;
import com.cisco.cbv.blogitaway.model.InvalidBlogException;
import com.cisco.cbv.blogitaway.model.InvalidCommentException;
import com.cisco.cbv.blogitaway.model.InvalidValueException;
import com.cisco.cbv.blogitaway.model.NoBlogsFoundException;
import com.cisco.cbv.blogitaway.model.NoCommentsFoundException;
import com.cisco.cbv.blogitaway.model.PagingConfig;

public class BlogServiceImpl implements BlogService {
	private BlogDao blogDao = BlogDaoMongoImpl.getInstance();
	private CommentDao commentDao = CommentDaoImpl.getInstance();

	@Override
	public List<Blog> getBlogs(PagingConfig pagingConfig)
			throws NoBlogsFoundException, InvalidValueException, BlogitAwayException {
		return blogDao.getBlogs(pagingConfig);
	}

	@Override
	public List<Blog> getBlogsByUser(String userName) {
		return blogDao.getBlogsByUser(userName);
	}

	@Override
	public void postBlog(Blog blog) throws InvalidBlogException, BlogitAwayException {
		blogDao.create(blog);
	}

	@Override
	public List<Blog> searchBlogs(PagingConfig pagingConfig, String query)
			throws NoBlogsFoundException, InvalidValueException, BlogitAwayException {
		return blogDao.searchBlogs(pagingConfig, query);
	}

	@Override
	public Blog getSpecificBlog(String blogId) throws BlogNotFoundException, BlogitAwayException {
		return blogDao.read(blogId);
	}

	@Override
	public void publishBlog(String blogId) throws BlogNotFoundException, BlogitAwayException {
	}

	@Override
	public void postComment(Comment comment)
			throws BlogNotFoundException, InvalidCommentException, BlogitAwayException {
		commentDao.create(comment);
	}

	@Override
	public List<Comment> getAllComments(String blogId, PagingConfig pagingConfig)
			throws BlogNotFoundException, NoCommentsFoundException, BlogitAwayException {
		return commentDao.readCommentsOfBlog(blogId);
	}

	@Override
	public Comment getSpecificComment(String commentId)
			throws BlogNotFoundException, CommentNotFoundException, InvalidValueException, BlogitAwayException {
		return commentDao.readComment(commentId);
	}

}

package com.cisco.cbv.blogitaway.service;

import java.util.List;

import com.cisco.cbv.blogitaway.dao.BlogDao;
import com.cisco.cbv.blogitaway.dao.BlogDaoImpl;
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

public class BlogServiceImpl implements BlogService{
	private BlogDao blogDao = BlogDaoImpl.getInstance();

	@Override
	public List<Blog> getBlogs(PagingConfig pagingConfig)
			throws NoBlogsFoundException, InvalidValueException, BlogitAwayException {
		return blogDao.getBlogs(pagingConfig);
	}

	@Override
	public Blog postBlog(Blog blog) throws InvalidBlogException, BlogitAwayException {
		return null;
	}

	@Override
	public List<Blog> searchBlogs(PagingConfig pagingConfig, String query)
			throws NoBlogsFoundException, InvalidValueException, BlogitAwayException {
		return null;
	}

	@Override
	public Blog getSpecificBlog(int blogId) throws BlogNotFoundException, BlogitAwayException {
		return null;
	}

	@Override
	public void publishBlog(int blogId) throws BlogNotFoundException, BlogitAwayException {
	}

	@Override
	public void deleteBlog(int blogId) throws BlogNotFoundException, BlogitAwayException {
	}

	@Override
	public Comment postComment(int blogId, Comment comment)
			throws BlogNotFoundException, InvalidCommentException, BlogitAwayException {
		return null;
	}

	@Override
	public List<Comment> getAllComments(int blogId, PagingConfig pagingConfig)
			throws BlogNotFoundException, NoCommentsFoundException, BlogitAwayException {
		return null;
	}

	@Override
	public Comment getSpecificComment(int blogId, int commentId)
			throws BlogNotFoundException, CommentNotFoundException, InvalidValueException, BlogitAwayException {
		return null;
	}

}

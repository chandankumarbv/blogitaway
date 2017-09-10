package com.cisco.cbv.blogitaway.service;

import java.util.List;

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

public interface BlogService {
	List<Blog> getBlogs(PagingConfig pagingConfig) throws NoBlogsFoundException, InvalidValueException, BlogitAwayException;

	void postBlog(Blog blog) throws InvalidBlogException, BlogitAwayException;
	
	List<Blog> searchBlogs(PagingConfig pagingConfig, String query) throws NoBlogsFoundException, InvalidValueException, BlogitAwayException;

	Blog getSpecificBlog(String blogId) throws BlogNotFoundException, BlogitAwayException;

	void publishBlog(String blogId) throws BlogNotFoundException, BlogitAwayException;
		
	void postComment(Comment comment) throws BlogNotFoundException, InvalidCommentException, BlogitAwayException;
	
	List<Comment> getAllComments(String blogId, PagingConfig pagingConfig) throws BlogNotFoundException, NoCommentsFoundException, BlogitAwayException;

	Comment getSpecificComment(String commentId) throws BlogNotFoundException, CommentNotFoundException, InvalidValueException, BlogitAwayException;
}

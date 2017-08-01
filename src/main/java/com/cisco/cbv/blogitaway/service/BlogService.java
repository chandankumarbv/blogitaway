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

	Blog postBlog(Blog blog) throws InvalidBlogException, BlogitAwayException;
	
	List<Blog> searchBlogs(PagingConfig pagingConfig, String query) throws NoBlogsFoundException, InvalidValueException, BlogitAwayException;

	Blog getSpecificBlog(int blogId) throws BlogNotFoundException, BlogitAwayException;

	void publishBlog(int blogId) throws BlogNotFoundException, BlogitAwayException;
	
	void deleteBlog(int blogId) throws BlogNotFoundException, BlogitAwayException;
	
	Comment postComment(int blogId, Comment comment) throws BlogNotFoundException, InvalidCommentException, BlogitAwayException;
	
	List<Comment> getAllComments(int blogId, PagingConfig pagingConfig) throws BlogNotFoundException, NoCommentsFoundException, BlogitAwayException;

	Comment getSpecificComment(int blogId, int commentId) throws BlogNotFoundException, CommentNotFoundException, InvalidValueException, BlogitAwayException;
}

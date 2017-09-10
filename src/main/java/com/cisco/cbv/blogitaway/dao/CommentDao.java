package com.cisco.cbv.blogitaway.dao;

import java.util.List;

import com.cisco.cbv.blogitaway.model.Comment;

public interface CommentDao {

	public void create(Comment comment);

	public Comment readComment(String commentId);

	public List<Comment> readCommentsOfBlog(String blogId);

}

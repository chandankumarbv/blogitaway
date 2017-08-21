package com.cisco.cbv.blogitaway.dao;

import java.util.List;

import com.cisco.cbv.blogitaway.model.Blog;
import com.cisco.cbv.blogitaway.model.Comment;
import com.cisco.cbv.blogitaway.model.PagingConfig;


public interface BlogDao {
	public void create(Blog blog);

	@Deprecated
	public Blog read(int blogId);

	public Blog read(String blogId);
	
	public List<Blog> getAllBlogs();
	
	// TODO should comment be part of separate DAO or Blog dao.
	public List<Comment> getAllComments(int blogId);
	
	public List<Blog> getBlogs(PagingConfig paging);

	public List<Blog> searchBlogs(PagingConfig pagingConfig, String query);
}

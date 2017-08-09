package com.cisco.cbv.blogitaway.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cisco.cbv.blogitaway.dao.BlogDaoImpl;
import com.cisco.cbv.blogitaway.model.Blog;
import com.cisco.cbv.blogitaway.model.Comment;
import com.cisco.cbv.blogitaway.model.PagingConfig;
import com.cisco.cbv.blogitaway.model.User;
import com.cisco.cbv.blogitaway.service.BlogService;
import com.cisco.cbv.blogitaway.service.BlogServiceImpl;

@Path("/blog")
public class BlogServerResource {
	private BlogService blogService = new BlogServiceImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBlogs(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
		PagingConfig paging = new PagingConfig();
		paging.setLimit(limit);
		paging.setOffset(offset);
		
		List<Blog> blogs = blogService.getBlogs(paging);
		return Response.ok().entity(blogs).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBlog(Blog blog) {
		BlogDaoImpl.getInstance().create(blog);
		return Response.ok().build();
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchBlogs(@QueryParam("limit") int limit, @QueryParam("offset") int offset,
			@QueryParam("query") String query) {
		PagingConfig paging = new PagingConfig();
		paging.setLimit(limit);
		paging.setOffset(offset);
		List<Blog> searchResult = blogService.searchBlogs(paging, query);
		return Response.ok().entity(searchResult).build();
	}

	@GET
	@Path("{blog_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecificBlog(@PathParam("blog_id") int blogId) {		
		Blog blog = BlogDaoImpl.getInstance().read(blogId);
		return Response.ok().entity(blog).build();
	}

	@POST
	@Path("/{blog_id}/publish")
	public Response publishBlog(@PathParam("blog_id") int blogId) {
		return Response.ok().build();
	}

	@GET
	@Path("/trending")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrendingBlogs(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
		List<Blog> allBlogs = BlogDaoImpl.getInstance().getAllBlogs();
		return Response.ok().entity(allBlogs).build();
	}

	@POST
	@Path("/{blog_id}/reportAbuse")
	public Response reportAbuseForBlog(@PathParam("blog_id") int blogId) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{blog_id}")
	public Response deleteBlog(@PathParam("blog_id") int blogId) {
		return Response.ok().build();
	}

	// FIXME should comment resources be served as separate or as part of blog
	// resource?

	@POST
	@Path("/{blog_id}/comment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postComment(@PathParam("blog_id") int blogId, Comment comment) {
		return Response.ok().build();
	}

	@GET
	@Path("/{blog_id}/comment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllComments(@PathParam("blog_id") int blogId) {
		return Response.ok().build();
	}

	@GET
	@Path("{blog_id}/{comment_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecificComment(@PathParam("blog_id") int blogIdj, @PathParam("comment_id") int commentId) {
		return Response.ok().build();
	}

	@POST
	@Path("/{blog_id}/{comment_id}/reportAbuse")
	public Response reportAbuseForComment(@PathParam("blog_id") int blogId,
			@PathParam("comment_id") int commentId) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{blog_id}/{comment_id}")
	public Response deleteComment(@PathParam("blog_id") int blogId, @PathParam("comment_id") int commentId) {
		return Response.ok().build();
	}

}

package com.cisco.cbv.blogitaway.resource;

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

@Path("/blog")
public class BlogServerResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBlogs(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
		return Response.ok().build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBlog(Blog blog) {
		Blog blog2 = new Blog();
		blog2.setId(2);
		blog2.setTitle("Blog title");
		blog2.setContent("THis is content of the lbog");
		BlogDaoImpl.getInstance().create(blog2);
		return Response.ok().build();
	}

	@GET
	@Path("{blog_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecificBlog(@PathParam("{blog_id}") int blogId) {
		Blog blog = BlogDaoImpl.getInstance().read(blogId);
		return Response.ok().entity(blog).build();
	}

	@POST
	@Path("/{blog_id}/publish")
	public Response publishBlog(@PathParam("{blog_id}") int blogId) {
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
	public Response reportAbuseForBlog(@PathParam("{blog_id}") int blogId) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{blog_id}")
	public Response deleteBlog(@PathParam("{blog_id}") int blogId) {
		return Response.ok().build();
	}

	// FIXME should comment resources be served as separate or as part of blog
	// resource?

	@POST
	@Path("/{blog_id}/comment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postComment(@PathParam("{blog_id}") int blogId) {
		return Response.ok().build();
	}

	@GET
	@Path("/{blog_id}/comment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllComments(@PathParam("{blog_id}") int blogId) {
		return Response.ok().build();
	}

	@GET
	@Path("{blog_id}/{comment_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecificComment(@PathParam("{blog_id}") int blogIdj, @PathParam("{comment_id}") int commentId) {
		return Response.ok().build();
	}

	@POST
	@Path("/{blog_id}/{comment_id}/reportAbuse")
	public Response reportAbuseForComment(@PathParam("{blog_id}") int blogId,
			@PathParam("{comment_id}") int commentId) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{blog_id}/{comment_id}")
	public Response deleteComment(@PathParam("{blog_id}") int blogId, @PathParam("{comment_id}") int commentId) {
		return Response.ok().build();
	}

}

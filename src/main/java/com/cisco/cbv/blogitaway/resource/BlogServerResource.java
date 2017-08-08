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
		
		
		
		List<Blog> allBlogs = new ArrayList<>();
		
		for(int i = 0; i< 30; i++){
			Blog e = new Blog();
			e.setId(i);
			
			User user = new User();
			user.setUserName("User" + i);
			user.setEmailAddress("user" + i + "@email.com");
			
			e.setOwner(user);
			
			e.setContent("Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]");
			e.setTitle("Advanced business cards design " + i);
			
			allBlogs.add(e);
		}
		
//				blogService.getBlogs(paging);
		return Response.ok().entity(allBlogs).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBlog(Blog blog) {
		return Response.ok().build();
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchBlogs(@QueryParam("limit") int limit, @QueryParam("offset") int offset,
			@QueryParam("query") String query) {
		List<Blog> allBlogs = new ArrayList<>();
		
		for(int i = 0; i< 30; i++){
			Blog e = new Blog();
			e.setId(i);
			
			User user = new User();
			user.setUserName("User" + i);
			user.setEmailAddress("user" + i + "@email.com");
			
			e.setOwner(user);
			
			e.setContent("Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]"
					+ "<b>Resrresers</b>");
			e.setTitle("Advanced business cards design " + i);
			
			allBlogs.add(e);
		}
		
		return Response.ok().entity(allBlogs).build();
	}

	@GET
	@Path("{blog_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecificBlog(@PathParam("blog_id") int blogId) {
		Blog e = new Blog();
		e.setId(blogId);
		
		User user = new User();
		user.setUserName("User" + blogId);
		user.setEmailAddress("user" + blogId + "@email.com");
		
		e.setOwner(user);
		
		e.setContent("Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]");
		e.setTitle("Advanced business cards design " + blogId);
		
		return Response.ok().entity(e).build();
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

package com.cisco.cbv.blogitaway.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/search")
public class SearchServerResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchBlogs(@QueryParam("q") String searchText) {
		return Response.ok().build();
	}
}

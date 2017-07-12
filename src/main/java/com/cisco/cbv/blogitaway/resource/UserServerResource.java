package com.cisco.cbv.blogitaway.resource;

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

@Path("/user")
public class UserServerResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
		return Response.ok().build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser() {
		return Response.ok().build();
	}

	@GET
	@Path("{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserDetails(@PathParam("{user_id}") int userId) {
		return Response.ok().build();
	}

	@POST
	@Path("{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserDetails(@PathParam("{user_id}") int userId) {
		return Response.ok().build();
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginUser() {
		return Response.ok().build();
	}

	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logoutUser() {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{user_id}")
	public Response deleteUser(@PathParam("{user_id}") int userId) {
		return Response.ok().build();
	}


}

package com.cisco.cbv.blogitaway.resource;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
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
import javax.ws.rs.core.Response.StatusType;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cisco.cbv.blogitaway.dao.TokenDaoImpl;
import com.cisco.cbv.blogitaway.dao.UserDaoImpl;
import com.cisco.cbv.blogitaway.model.JWTToken;
import com.cisco.cbv.blogitaway.model.User;

@Path("/user")
public class UserServerResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
		List<User> allUsers = UserDaoImpl.getInstance().getAllUsers();
		return Response.ok().entity(allUsers).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(User user) throws NoSuchAlgorithmException, IllegalArgumentException, UnsupportedEncodingException {

		UserDaoImpl.getInstance().create(user);
		String token = TokenUtil.issueAndStoreToken(user.getUserName());
		return Response.ok().entity(token).build();
	}

	@GET
	@Path("{user_name}")
	@Produces(MediaType.APPLICATION_JSON)
	@AuthorizationNeeded
	public Response getUserDetails(@PathParam("user_name") String userName) {
		User user = UserDaoImpl.getInstance().read(userName);
		if (user == null) {
			return Response.status(404).build();
		}
		return Response.ok().entity(user).build();
	}

	@POST
	@Path("{user_name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@AuthorizationNeeded
	public Response updateUserDetails(@PathParam("user_name") String userName, User user) {
		if (UserDaoImpl.getInstance().read(userName) == null) {
			return Response.status(404).build();
		}
		User updatedUser = UserDaoImpl.getInstance().updateUser(userName, user);
		return Response.accepted(updatedUser).build();
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginUser(User user) throws IllegalArgumentException, UnsupportedEncodingException {
		if (UserDaoImpl.getInstance().authenticate(user)) {
			String token = TokenUtil.issueAndStoreToken(user.getUserName());
			return Response.ok().entity(token).build();
		} else {
			return Response.status(401).entity("Authentication Failed.").build();
		}
	}

	@GET
	@Path("/verifyToken")
	public Response verifyJWTToken(@QueryParam("token") String token)
			throws IllegalArgumentException, UnsupportedEncodingException {
		if (AuthUtil.verifyToken(token)) {
			return Response.ok().build();
		}
		return Response.status(401).entity("Verification failed.").build();
	}

	@POST
	@Path("/logout")
	@AuthorizationNeeded
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logoutUser(User user) {
		TokenDaoImpl.getInstance().delete(user.getUserName());
		return Response.ok().build();
	}

	@DELETE
	@Path("/{user_id}")
	public Response deleteUser(@PathParam("user_id") int userId) {
		return Response.ok().build();
	}

}

package com.cisco.cbv.blogitaway.resource;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AppExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		if (exception instanceof NotAuthorizedException) {
			return Response.status(401).entity("Error: " + exception.getLocalizedMessage()).build();
		}
		return Response.status(500).entity("Error: " + exception.getLocalizedMessage()).build();
	}

}

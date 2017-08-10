package com.cisco.cbv.blogitaway.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cisco.cbv.blogitaway.model.BlogNotFoundException;

@Provider
public class BlogExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		if (exception instanceof BlogNotFoundException) {
			return Response.status(404).build();
		}
		return Response.serverError().entity(exception).build();
	}

}

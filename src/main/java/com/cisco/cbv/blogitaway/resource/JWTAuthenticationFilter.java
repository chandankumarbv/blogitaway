package com.cisco.cbv.blogitaway.resource;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

@Provider
@AuthorizationNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTAuthenticationFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("JWT URL: " + requestContext.getUriInfo().getPath());
		String token = getTokenFromHeader(requestContext.getHeaderString(HttpHeaders.AUTHORIZATION));
		if (token != null) {
			if (!AuthUtil.verifyToken(token)) {
				throw new NotAuthorizedException("Invalid token");
			}
		} else {
			throw new NotAuthorizedException("Authorization header not provided");
		}
	}

	private String getTokenFromHeader(String header) {
		if (header != null) {
			Pattern pattern = Pattern.compile("Bearer (.*)");
			Matcher matcher = pattern.matcher(header);
			if (matcher.matches()) {
				return matcher.group(1);
			}
		}
		return null;
	}
}

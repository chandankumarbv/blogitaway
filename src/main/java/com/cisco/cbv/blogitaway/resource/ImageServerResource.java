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

@Path("/{user_id}/image")
public class ImageServerResource {

	@GET
	@Produces(MediaType.MULTIPART_FORM_DATA)
	public Response getImages(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
		return Response.ok().build();
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response postImage() {
		return Response.ok().build();
	}

	@GET
	@Path("{image_id}")
	@Produces(MediaType.MULTIPART_FORM_DATA)
	public Response getSpecificImage(@PathParam("image_id") int imageId) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{image_id}")
	public Response deleteImage(@PathParam("image_id") int imageId) {
		return Response.ok().build();
	}

}

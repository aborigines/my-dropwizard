package com.dropwizard.errors;

import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class NoContentExceptionMapper extends IOException implements ExceptionMapper<NoContentException> {
  @Override
  public Response toResponse(NoContentException e) {
    return Response.status(Response.Status.NOT_FOUND).entity(new ErrorMessage(Response.Status.NOT_FOUND.getStatusCode(), "Not Found", e.getMessage())).build();
  }
}

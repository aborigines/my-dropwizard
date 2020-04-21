package com.dropwizard.errors;

import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UncaughtExceptionMapper extends Throwable implements ExceptionMapper<Throwable> {
  @Override
  public Response toResponse(Throwable throwable) {
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
      .type(MediaType.APPLICATION_JSON_TYPE)
      .entity(
        new ErrorMessage(
          Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
          Response.Status.INTERNAL_SERVER_ERROR.toString(),
          "Something went wrong"
      )).build();
  }
}

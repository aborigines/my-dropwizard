package com.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.dropwizard.api.Hello;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

  @GET
  @Timed
  public Hello to(@QueryParam("name") Optional<String> name) {
    final String value = name.orElse(null);
    return new Hello(value);
  }
}

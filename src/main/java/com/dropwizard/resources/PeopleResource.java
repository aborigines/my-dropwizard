package com.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.dropwizard.core.People;
import com.dropwizard.service.PeopleService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {
  private final PeopleService peopleService;

  public PeopleResource(PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @GET
  @Timed
  @UnitOfWork
  public List<People> listPeople() {
    return this.peopleService.listPeople();
  }
}

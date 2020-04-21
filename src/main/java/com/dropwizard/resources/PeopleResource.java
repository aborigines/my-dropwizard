package com.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.dropwizard.api.HttpResponse;
import com.dropwizard.core.People;
import com.dropwizard.errors.NoContentExceptionMapper;
import com.dropwizard.service.PeopleService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

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

  @GET
  @Timed
  @UnitOfWork
  @Path("{id}")
  public Optional<People> findPeople(@PathParam("id") OptionalLong id) {
    return this.peopleService.findById(id);
  }

  @POST
  @Timed
  @UnitOfWork
  public People createPeople(@Valid People people) {
    return this.peopleService.createPeople(people);
  }


  @PUT
  @Timed
  @UnitOfWork
  @Path("{id}")
  public Response updatePeople(@PathParam("id") Long id, @Valid People people) {
    People updated = this.peopleService.updateById(id, people);
    if (updated.getId() != null) {
      return Response.ok().entity(people).build();
    }
    return null;
  }

  @DELETE
  @Timed
  @UnitOfWork
  @Path("{id}")
  public Response deletePeople(@PathParam("id") Long id) throws NoContentException, NoContentExceptionMapper {
    boolean deleted = this.peopleService.delete(id);
    if (deleted) {
      return Response.ok().build();
    }
    return null;
  }
}

package com.dropwizard.db;

import com.dropwizard.core.People;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class PeopleDao extends AbstractDAO<People> {
  public PeopleDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public Optional<People> findById(Long id) {
    return Optional.ofNullable(get(id));
  }

  public People create(People People) {
    return persist(People);
  }

  @SuppressWarnings("unchecked")
  public List<People> findAll() {
    return list((Query<People>) namedQuery("com.dropwizard.core.People.findAll"));
  }
}

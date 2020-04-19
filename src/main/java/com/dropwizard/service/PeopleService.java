package com.dropwizard.service;


import com.dropwizard.core.People;
import com.dropwizard.db.PeopleDao;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

public class PeopleService {

  private final PeopleDao peopleDao;

  public PeopleService(PeopleDao peopleDao) {
    this.peopleDao = peopleDao;
  }

  public List<People> listPeople() {
    return this.peopleDao.findAll();
  }

  public People createPeople(People people) {
    people.setId(null);
    return this.peopleDao.create(people);
  }

  public Optional<People> findById(OptionalLong peopleId) {
    return this.peopleDao.findById(
      peopleId.orElseThrow( ()-> new IllegalArgumentException("the id is mandatory"))
    );
  }

  public People updateById(Long id, People people) {
    people.setId(id);
    return this.peopleDao.create(people);
  }

  public boolean delete(Long id) {
    Optional<People> findPeople =  Optional.ofNullable(this.peopleDao.findById(id))
      .orElseThrow(() -> new RuntimeException("some error message"));
    if (findPeople.isPresent()) {
      this.peopleDao.delete(findPeople.get());
      return true;
    } else {
      return false;
    }
  }
}

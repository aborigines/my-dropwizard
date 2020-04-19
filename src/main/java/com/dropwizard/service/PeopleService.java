package com.dropwizard.service;


import com.dropwizard.core.People;
import com.dropwizard.db.PeopleDao;

import java.util.List;

public class PeopleService {

  private final PeopleDao peopleDao;

  public PeopleService(PeopleDao peopleDao) {
    this.peopleDao = peopleDao;
  }

  public List<People> listPeople() {
    return this.peopleDao.findAll();
  }
}

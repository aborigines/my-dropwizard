package com.dropwizard;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DropwizardConfiguration extends Configuration {

  @Valid
  @NotNull
  private DataSourceFactory database = new DataSourceFactory();

  public void setDataSourceFactory(DataSourceFactory factory) {
    this.database = factory;
  }

  public DataSourceFactory getDataSourceFactory() {
    return database;
  }
}

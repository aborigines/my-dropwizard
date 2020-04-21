package com.dropwizard;

import com.dropwizard.core.People;
import com.dropwizard.db.PeopleDao;
import com.dropwizard.errors.NoContentExceptionMapper;
import com.dropwizard.errors.NotFoundExceptionMapper;
import com.dropwizard.errors.UncaughtExceptionMapper;
import com.dropwizard.resources.HelloResource;
import com.dropwizard.resources.PeopleResource;
import com.dropwizard.service.PeopleService;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jersey.errors.EarlyEofExceptionMapper;
import io.dropwizard.jersey.errors.LoggingExceptionMapper;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardApplication extends Application<DropwizardConfiguration> {
    private PeopleService peopleService;

    public static void main(final String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardConfiguration> bootstrap) {
      bootstrap.addBundle(migrations);
      bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final DropwizardConfiguration configuration,
                    final Environment environment) {
      // DAO
      final PeopleDao peopleDao = new PeopleDao(hibernate.getSessionFactory());

      // Service
      final PeopleService peopleService = new PeopleService(peopleDao);

      // Provider
      environment.jersey().register(new LoggingExceptionMapper<Throwable>() {});
      environment.jersey().register(new JsonProcessingExceptionMapper());
      environment.jersey().register(new EarlyEofExceptionMapper());
      environment.jersey().register(new NotFoundExceptionMapper());
      environment.jersey().register(new NoContentExceptionMapper());
      environment.jersey().register(new UncaughtExceptionMapper());

      // Resource
      environment.jersey().register(new HelloResource());
      environment.jersey().register(new PeopleResource(peopleService));
    }

    private final MigrationsBundle<DropwizardConfiguration> migrations = new MigrationsBundle<DropwizardConfiguration>() {
      @Override
      public DataSourceFactory getDataSourceFactory(DropwizardConfiguration configuration) {
        return configuration.getDataSourceFactory();
      }
    };

    private final HibernateBundle<DropwizardConfiguration> hibernate = new HibernateBundle<DropwizardConfiguration>(People.class) {
      @Override
      public DataSourceFactory getDataSourceFactory(DropwizardConfiguration configuration) {
        return configuration.getDataSourceFactory();
      }
    };
}

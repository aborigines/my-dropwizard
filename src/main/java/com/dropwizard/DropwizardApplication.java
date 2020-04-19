package com.dropwizard;

import com.dropwizard.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardApplication extends Application<DropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardConfiguration> bootstrap) {
      bootstrap.addBundle(new MigrationsBundle<DropwizardConfiguration>() {
        @Override
        public DataSourceFactory getDataSourceFactory(DropwizardConfiguration configuration) {
          return configuration.getDataSourceFactory();
        }
      });
    }

    @Override
    public void run(final DropwizardConfiguration configuration,
                    final Environment environment) {
      registerResource(configuration, environment);
    }

    public void registerResource(final DropwizardConfiguration configuration, final Environment environment) {
      environment.jersey().register(new HelloResource());
    }
}

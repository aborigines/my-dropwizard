package com.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.List;

public class dropwizardApplication extends Application<dropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard";
    }

    @Override
    public void initialize(final Bootstrap<dropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final dropwizardConfiguration configuration,
                    final Environment environment) {
      registerResource(configuration, environment);
    }

    public void registerResource(final dropwizardConfiguration configuration, final Environment environment) {
      List<String> resourceList = configuration.getResourceList();
      try {
        for (String resource : resourceList) {
          String className = String.format("%s.resources.%s",this.getClass().getPackage().getName(), resource);
          environment.jersey().register(Class.forName(className));
        }
      } catch (Exception e) {
        e.printStackTrace();
        System.exit(0);
      }
    }
}

package com.dropwizard;

import io.dropwizard.Configuration;
import java.util.List;

public class dropwizardConfiguration extends Configuration {
  List<String> resourceList;

  public List<String> getResourceList() {
    return resourceList;
  }
}

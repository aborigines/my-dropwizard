package com.dropwizard;

import io.dropwizard.Configuration;
import java.util.List;

public class DropwizardConfiguration extends Configuration {
  List<String> resourceList;

  public List<String> getResourceList() {
    return resourceList;
  }
}

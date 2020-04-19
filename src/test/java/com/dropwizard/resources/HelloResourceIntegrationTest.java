package com.dropwizard.resources;

import com.dropwizard.DropwizardApplication;
import com.dropwizard.DropwizardConfiguration;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.ClientBuilder;

import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(DropwizardExtensionsSupport.class)
class HelloResourceIntegrationTest {

  public static final DropwizardAppExtension<DropwizardConfiguration> EXTENSION =
    new DropwizardAppExtension(DropwizardApplication.class, resourceFilePath("config-test.yml"));

  @Test
  public void shouldReturnName() {
    String response = ClientBuilder.newClient()
      .target("http://localhost:" + EXTENSION.getLocalPort() + "/hello")
      .queryParam("name", "test").request().get(String.class);

    assertThat(response).isEqualTo("{\"content\":\"test\"}");
  }
}

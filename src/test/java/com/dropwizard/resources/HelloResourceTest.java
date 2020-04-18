package com.dropwizard.resources;

import com.dropwizard.api.Hello;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(DropwizardExtensionsSupport.class)
class HelloResourceTest {

  private HelloResource resource;

  private Hello hello;

  @BeforeEach
  public void setUp() {
    resource = new HelloResource();
  }

  @Test
  public void nameReturnsName() {
    Hello result = resource.name(Optional.of("test"));
    assertThat(result.getContent()).contains("test");
  }
}

package com.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hello {

  @JsonProperty
  private String content;

  public Hello(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Hello{" +
      "content='" + content + '\'' +
      '}';
  }
}

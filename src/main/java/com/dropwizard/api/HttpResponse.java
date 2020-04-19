package com.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class HttpResponse {
  @JsonProperty
  private Integer status;

  @JsonProperty
  private String error;

  @JsonProperty
  private String message;

  public HttpResponse(Integer status, String error, String message) {
    this.status = status;
    this.error = error;
    this.message = message;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

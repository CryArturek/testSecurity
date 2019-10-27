package com.rossa.security.objects;

import java.io.Serializable;

public class AuthenticationToken implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String token;

  public AuthenticationToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}

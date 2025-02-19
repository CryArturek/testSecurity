package com.rossa.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Wrong credentials")
public class AuthenticationException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public AuthenticationException() {
    super();
  }

  public AuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public AuthenticationException(String message, Throwable cause) {
    super(message, cause);
  }

  public AuthenticationException(String message) {
    super(message);
  }

  public AuthenticationException(Throwable cause) {
    super(cause);
  }

}

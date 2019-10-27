package com.rossa.security.service;

import com.rossa.security.exceptions.AuthenticationException;
import com.rossa.security.objects.UserCredential;

/**
 * This interface should be overriden by implementation in project, which wants use
 * globema-spring-com.globema.security project.
 * 
 * @author wim
 *
 */
public interface CredentialsService {
  /**
   * Get user credential based on login. This method should be used when the next step is to compare
   * passwords or other credentials in globema-spring-com.globema.security module.
   * 
   * @param login
   * @return
   */
  UserCredential getUserByLogin(String login);

  /**
   * Authenticate user by login and password.
   * 
   * @param login
   * @param password
   * @return
   * @throws AuthenticationException
   */
  UserCredential authenticate(String login, String password) throws AuthenticationException;
}

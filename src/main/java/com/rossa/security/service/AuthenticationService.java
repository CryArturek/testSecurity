package com.rossa.security.service;

import com.rossa.security.exceptions.AuthenticationException;
import com.rossa.security.objects.AuthenticationToken;
import com.rossa.security.objects.UserCredential;
import com.rossa.security.token.TokenTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  @Autowired
  private CredentialsService credentialsService;

  @Autowired
  private TokenTools tokenTools;

  public AuthenticationToken getToken(UserCredential credentials) {
    if (checkCredentials(credentials)) {
      throw new AuthenticationException("Wrong credentials");
    }
    UserCredential user = credentialsService.authenticate(credentials.getLogin(), credentials.getPassword());
    if (user == null) {
      throw new AuthenticationException("Wrong credentials");
    }
    return tokenTools.createTokenForUser(user);
  }

  private boolean checkCredentials(UserCredential credentials) {
    return credentials == null || credentials.getLogin() == null || credentials.getPassword() == null;
  }

  public UserCredential getCredentials(String token) {
    String login = tokenTools.parseAuthenticationFromToken(token);
    if (login == null) {
      return null;
    }
    return credentialsService.getUserByLogin(login);
  }

  public AuthenticationToken extendToken(UserCredential credential){
    AuthenticationToken token =tokenTools.createTokenForUser(credential);
    return token;
  };
}

package com.rossa.security.service;



import com.rossa.security.objects.UserCredential;

import java.util.Set;

public class UserCredentialWithToken extends UserCredential {

  private Set<String> userGroups;
  private String userGroup;

  public String getUserGroup() {
    return userGroup;
  }

  public void setUserGroup(String userGroup) {
    this.userGroup = userGroup;
  }

  public Set<String> getUserGroups() {
    return userGroups;
  }

  public void setUserGroups(Set<String> userGroups) {
    this.userGroups = userGroups;
  }
}

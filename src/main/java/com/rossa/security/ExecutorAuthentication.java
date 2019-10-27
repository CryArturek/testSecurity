package com.rossa.security;

import com.rossa.security.objects.UserCredential;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExecutorAuthentication implements Authentication {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private static final String ROLE_WEB = "USER";
	
	private UserCredential executor;
	private boolean authenticated = true;
	
	public ExecutorAuthentication(UserCredential executor) {
		this.executor = executor;
	}

	public UserCredential getExecutor(){
		return executor;
	}

  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
    authorityList.add(new SimpleGrantedAuthority(ROLE_WEB));
    return authorityList;
  }


  public Object getCredentials() {
    return executor.getPassword();
  }

  public UserCredential getDetails() {
    return executor;
  }

  public Object getPrincipal() {
    return executor.getLogin();
  }

  public boolean isAuthenticated() {
    return authenticated;
  }

  public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
    this.authenticated = authenticated;
  }

  public String getName() {
    return executor.getLogin();
  }

}

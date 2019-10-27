package com.rossa.security;

import com.rossa.security.objects.UserCredential;
import com.rossa.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 *
 */
@Component
@Order(324234)
public class StatelessAuthenticationFilter extends GenericFilterBean {

    private static final String AUTH_HEADER_NAME = "X-Auth-Token";

    @Autowired
    private AuthenticationService service;


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
            ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            UserCredential credential = service.getCredentials(token);
            if (credential != null) {
                ExecutorAuthentication authentication = new ExecutorAuthentication(credential);
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//                User userDetails = new User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities(user.getRoles()));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.setHeader(AUTH_HEADER_NAME, service.extendToken(credential).getToken());
            }
        }
        filterChain.doFilter(request, response);
    }

}

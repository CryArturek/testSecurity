package com.rossa.security.service;


import com.rossa.security.exceptions.AuthenticationException;
import com.rossa.security.objects.UserCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CredentialServiceImpl implements CredentialsService {


    @Value("${ldap.isprod:false}")
    private boolean isProd;

    private Map<String, Map.Entry<Instant, Set<String>>> userToGroups = new HashMap<>();

    @Override
    public UserCredential getUserByLogin(String login) {
        UserCredentialWithToken userCredential = new UserCredentialWithToken();
        if (userToGroups.get(login) == null || Instant.now().isAfter(userToGroups.get(login).getKey())) {

            List<String> hackList = new ArrayList<>(Arrays.asList("hack", "group"));
            Set<String> userGroups = new HashSet<>(hackList);
            this.userToGroups.put(login, new AbstractMap.SimpleEntry<>(Instant.now().plus(240, ChronoUnit.MINUTES),
                    userGroups));
        }
        userCredential.setUserGroups(this.userToGroups.get(login).getValue());
        userCredential.setLogin(login);
        return userCredential;
    }

    @Override
    public UserCredential authenticate(String login, String password) throws AuthenticationException {
        if (login == null || password == null) {
            throw new AuthenticationException("Invalid credentials");
        }
        try {
            return createCredential(login, password);
        } catch (Exception e) {
            throw new AuthenticationException("Login failed");
        }
    }

    private UserCredential createCredential(String login, String password) {
        UserCredential userCredential = new UserCredential();
        userCredential.setPassword(password);
        userCredential.setLogin(login);
        return userCredential;
    }

}

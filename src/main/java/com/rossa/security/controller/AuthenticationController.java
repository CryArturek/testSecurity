package com.rossa.security.controller;

import com.rossa.security.exceptions.AuthenticationException;
import com.rossa.security.objects.AuthenticationToken;
import com.rossa.security.objects.UserCredential;
import com.rossa.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/auth")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @RequestMapping(value = "/token", method = RequestMethod.POST, produces = "application/json")
    public AuthenticationToken login(@RequestBody UserCredential credentials) throws AuthenticationException {
        System.out.println("token");
        AuthenticationToken token = service.getToken(credentials);
        return token;
    }
}

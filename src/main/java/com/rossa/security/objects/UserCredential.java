package com.rossa.security.objects;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
@Data
public class UserCredential implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String login;
    private String password;
    private ArrayList<String> roles = new ArrayList<>(Arrays.asList("ROLE_USER"));
}

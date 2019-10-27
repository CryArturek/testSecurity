package com.rossa.Package;

import com.rossa.User;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UserExten extends User {
    private String company;
    // constructor, getters, setters
}

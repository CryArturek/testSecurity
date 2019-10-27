package com.rossa;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UserExtent1 extends User {
    private String company1;
    // constructor, getters, setters
}

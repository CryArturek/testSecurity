package com.rossa;


import lombok.Data;

import javax.persistence.*;

//@Entity
//@Table(name = "ddddddddddddddd")
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;

    // standard constructors / setters / getters / toString

}

package com.rossa.Package;

import lombok.Data;

import javax.validation.constraints.NotNull;


public class ApiObject {

    @NotNull
    public Integer value;
    public String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

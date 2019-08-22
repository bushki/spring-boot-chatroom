package edu.udacity.java.nano.model;

import javax.validation.constraints.NotBlank;

public class User {

    @NotBlank(message = "username cannot be empty")
    private String name;
}

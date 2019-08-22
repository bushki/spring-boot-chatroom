package edu.udacity.java.nano.model;

import javax.validation.constraints.NotBlank;

public class User {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //@NotBlank(message = "username cannot be empty")
    private String username;
}

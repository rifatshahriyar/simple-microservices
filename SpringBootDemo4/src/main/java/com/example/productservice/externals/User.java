package com.example.productservice.externals;

import org.springframework.hateoas.RepresentationModel;

public class User extends RepresentationModel<User> {

    private Long Id;
    private String name;
    private String email;

    public User() {
    }

    public User(Long id, String name, String email) {
        this.Id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

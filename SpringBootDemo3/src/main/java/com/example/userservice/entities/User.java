package com.example.userservice.entities;

import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User extends RepresentationModel<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String name;

    @NotNull
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

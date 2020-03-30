package com.example.productservice.entities;

import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product extends RepresentationModel<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String name;

    @NotNull
    private Long userId;

    public Product() {
    }

    public Product(Long id, String name, Long userId) {
        this.Id = id;
        this.name = name;
        this.userId = userId;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }
}

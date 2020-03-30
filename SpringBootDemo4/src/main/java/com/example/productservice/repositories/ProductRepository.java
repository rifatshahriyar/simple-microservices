package com.example.productservice.repositories;

import com.example.productservice.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long>   {
    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    Optional<Product> findProductByName(String name);

    @Query("SELECT p FROM Product p WHERE p.userId = ?1")
    Iterable<Product> findProductByUserId(Long userId);
}

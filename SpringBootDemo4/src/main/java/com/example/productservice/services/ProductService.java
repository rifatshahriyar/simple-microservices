package com.example.productservice.services;

import com.example.productservice.entities.Product;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Repository
public class ProductService {

    final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        Iterable<Product> products = repository.findAll();
        List<Product> productList = new ArrayList<>();
        for (Product product:  products) {
            productList.add(product);
        }
        return productList;
    }

    public Product getProductById(Long id) {
        Optional<Product> product = repository.findById(id);
        if (!product.isPresent()) {
            throw new ProductNotFoundException(id);
        }
        return product.get();
    }

    public Product getProductByName(String name) {
        Optional<Product> product = repository.findProductByName(name);
        if (!product.isPresent()) {
            throw new ProductNotFoundException(name);
        }
        return product.get();
    }

    public List<Product> getProductByUserId(Long userId) {
        Iterable<Product> products  = repository.findProductByUserId(userId);
        List<Product> productList = new ArrayList<>();
        for (Product product:  products) {
            productList.add(product);
        }
        return productList;
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }
}
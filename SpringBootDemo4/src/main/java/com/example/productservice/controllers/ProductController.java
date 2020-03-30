package com.example.productservice.controllers;

import com.example.productservice.entities.Product;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.externals.User;
import com.example.productservice.externals.UserServiceClient;
import com.example.productservice.services.ProductService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    final ProductService productService;
    final UserServiceClient userServiceClient;

    public ProductController(ProductService productService, UserServiceClient userServiceClient) {
        this.productService = productService;
        this.userServiceClient = userServiceClient;
    }

    @RequestMapping(value = "/product", produces = { "application/hal+json" })
    public CollectionModel<Product> index() {
        return new CollectionModel<>(productService.getProducts());
    }

    @RequestMapping(value = "/product/{id}", produces = { "application/hal+json" })
    public Product getProduct(@PathVariable(value = "id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/product/name/{name}", produces = { "application/hal+json" })
    public Product getProductByName(@PathVariable(value = "name") String name) throws ProductNotFoundException {
        return productService.getProductByName(name);
    }

    @RequestMapping(value = "/product/uid/{uid}", produces = { "application/hal+json" })
    public CollectionModel<Product>  getProductByUserId(@PathVariable(value = "uid") Long uid) throws ProductNotFoundException {
        return new CollectionModel<>(productService.getProductByUserId(uid));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/product/add", produces = { "application/hal+json" })
    public Product addProduct(@RequestBody Product user) {
        return productService.addProduct(user);
    }

    @RequestMapping(value = "/product/user/{id}", produces = { "application/hal+json" })
    public User getUserByProductId(@PathVariable(value = "id") Long id)  {
        return userServiceClient.getUser(productService.getProductById(id).getUserId());
    }
}
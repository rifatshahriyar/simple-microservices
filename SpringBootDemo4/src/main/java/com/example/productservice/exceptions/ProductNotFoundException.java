package com.example.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product does not exist")  // 404
public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(Long id) {
        super("ProductNotFoundException with id =" + id);
    }

    public ProductNotFoundException(String name) {
        super("ProductNotFoundException with name =" + name);
    }

}
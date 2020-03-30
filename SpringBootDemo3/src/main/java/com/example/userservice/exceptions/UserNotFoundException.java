package com.example.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User does not exist")  // 404
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(Long id) {
        super("UserNotFoundException with id =" + id);
    }

    public UserNotFoundException(String email) {
        super("UserNotFoundException with name/email =" + email);
    }

}
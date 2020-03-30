package com.example.userservice.controllers;

import com.example.userservice.entities.User;
import com.example.userservice.exceptions.UserNotFoundException;
import com.example.userservice.services.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", produces = { "application/hal+json" })
    public CollectionModel<User> index() {
        return new CollectionModel<>(userService.getUsers());
    }

    @RequestMapping(value = "/user/{id}", produces = { "application/hal+json" })
    public User getUser(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/user/email/{email}", produces = { "application/hal+json" })
    public User getUserByEmail(@PathVariable(value = "email") String email) throws UserNotFoundException {
        return userService.getUserByEmail(email);
    }

    @RequestMapping(value = "/user/name/{name}", produces = { "application/hal+json" })
    public User getUserByName(@PathVariable(value = "name") String name) throws UserNotFoundException {
        return userService.getUserByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/add", produces = { "application/hal+json" })
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
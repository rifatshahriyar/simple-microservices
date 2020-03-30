package com.example.userservice.services;

import com.example.userservice.entities.User;
import com.example.userservice.exceptions.UserNotFoundException;
import com.example.userservice.repositories.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Repository
public class UserService {

    final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        Iterable<User> users = repository.findAll();
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            userList.add(user);
        }
        return userList;
    }

    public User getUserById(Long id) {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException(id);
        }
        return user.get();
    }

    public User getUserByName(String name) {
        Optional<User> user = repository.findUserByName(name);
        if (!user.isPresent()) {
            throw new UserNotFoundException(name);
        }
        return user.get();
    }

    public User getUserByEmail(String email) {
        Optional<User> user = repository.findUserByEmail(email);
        if (!user.isPresent()) {
            throw new UserNotFoundException(email);
        }
        return user.get();
    }

    public User addUser(User user) {
        return repository.save(user);
    }
}
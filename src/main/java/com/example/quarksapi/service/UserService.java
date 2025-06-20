package com.example.quarksapi.service;

import com.example.quarksapi.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final Map<String, User> userStorage = new HashMap<>();

    public User createUser(String name, String email) {
        String id = UUID.randomUUID().toString();
        User user = new User(id, name, email);
        userStorage.put(id, user);
        return user;
    }

    public User getUserById(String id) {
        return userStorage.get(id);
    }
}

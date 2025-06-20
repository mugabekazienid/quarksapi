package com.example.quarksapi.controller;

import com.example.quarksapi.model.User;
import com.example.quarksapi.service.UserService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String email = body.get("email");

        if (name == null || email == null) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", "Missing 'name' or 'email' field"));
        }

        User user = userService.createUser(name, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "User not found"));
        }
        return ResponseEntity.ok(user);
    }
}

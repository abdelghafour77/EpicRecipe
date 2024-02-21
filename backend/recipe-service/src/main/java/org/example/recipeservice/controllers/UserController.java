package org.example.recipeservice.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.recipeservice.entities.User;
import org.example.recipeservice.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "This is a User API")
public class UserController {
    private final UserService service;

    @GetMapping()
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }

    @PostMapping()
    public User saveUser(User user) {
        return service.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(UUID id, User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        service.deleteUser(id);
    }



}

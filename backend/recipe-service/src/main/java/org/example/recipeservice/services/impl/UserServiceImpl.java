package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.entities.User;
import org.example.recipeservice.repository.UserRepository;
import org.example.recipeservice.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(UUID id, User user) {
        user.setId(id);
        return repository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        repository.deleteById(id);
    }
}

package org.example.epicrecipe.services.impl;

import lombok.AllArgsConstructor;
import org.example.epicrecipe.entities.User;
import org.example.epicrecipe.repository.UserRepository;
import org.example.epicrecipe.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User updateUser(Long id, User user) {
        user.setId(id);
        return repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}

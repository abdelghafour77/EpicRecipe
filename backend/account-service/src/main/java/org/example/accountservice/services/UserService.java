package org.example.accountservice.services;

import org.example.accountservice.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    User saveUser(User user);

    User updateUser(UUID id, User user);

    void deleteUser(UUID id);


}

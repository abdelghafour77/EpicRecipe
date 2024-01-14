package org.example.epicrecipe.services;

import org.example.epicrecipe.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    User saveUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);


}

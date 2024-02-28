package org.example.recipeservice.users;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.recipeservice.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface UserRestRecipe {

    @GetMapping("/api/v1/users/{id}")
    @CircuitBreaker(name = "user-service", fallbackMethod = "getDefaultUser")
    User findUserById(@PathVariable Long id);

    @GetMapping("/users")
    List<User> findAllUsers();

    default User getDefaultUser(Long id, Throwable throwable) {

        return User.builder()
                .id(id)
                .firstName("Default")
                .lastName("Default")
                .email("Default")
                .password("Default")
                .build();

    }
}

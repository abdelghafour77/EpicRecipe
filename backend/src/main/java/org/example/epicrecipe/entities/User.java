package org.example.epicrecipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.example.epicrecipe.entities.enums.Role;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Role role;
}

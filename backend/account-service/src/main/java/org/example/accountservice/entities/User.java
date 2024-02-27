package org.example.accountservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.accountservice.entities.enums.Role;

import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private List<Role> roles;

//    @Transient
//    private List<Comment> comments;
//
//    @Transient
//    private List<Favorite> favorites;
//
//    @Transient
//    private List<SearchHistory> searchHistory;

}

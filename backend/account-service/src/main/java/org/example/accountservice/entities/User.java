package org.example.accountservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.accountservice.entities.enums.Role;
import org.example.accountservice.model.Comment;
import org.example.accountservice.model.Favorite;
import org.example.accountservice.model.SearchHistory;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String email;
    private String password;

    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    private List<SearchHistory> searchHistory;

}

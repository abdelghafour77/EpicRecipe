package org.example.recipeservice.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.recipeservice.entities.Favorite;
import org.example.recipeservice.services.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
@RequiredArgsConstructor
@Tag(name = "Favorite Controller", description = "This is a Favorite API")
public class FavoriteController {
    private final FavoriteService service;

    @GetMapping()
    public ResponseEntity<List<Favorite>> getFavorites() {
       return ResponseEntity.ok(service.getFavorites());
    }
}

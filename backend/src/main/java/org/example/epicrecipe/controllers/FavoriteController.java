package org.example.epicrecipe.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.epicrecipe.services.FavoriteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/favorites")
@RequiredArgsConstructor
@Tag(name = "Favorite Controller", description = "This is a Favorite API")
public class FavoriteController {
    private final FavoriteService service;

    @GetMapping()
    public void getFavorites() {
        service.getFavorites();
    }
}

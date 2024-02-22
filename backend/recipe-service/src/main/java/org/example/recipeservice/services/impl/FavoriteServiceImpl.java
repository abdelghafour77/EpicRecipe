package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.repository.RecipeRepository;
import org.example.recipeservice.services.FavoriteService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final RecipeRepository repository;

    @Override
    public void addFavorite(Long recipeId) {

    }

    @Override
    public void removeFavorite(Long recipeId) {

    }

    @Override
    public void getFavorites() {

    }
}

package org.example.epicrecipe.services.impl;

import lombok.AllArgsConstructor;
import org.example.epicrecipe.repository.RecipeRepository;
import org.example.epicrecipe.services.FavoriteService;
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

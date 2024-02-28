package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.entities.Favorite;
import org.example.recipeservice.repository.FavoriteRepository;
import org.example.recipeservice.services.FavoriteService;
import org.example.recipeservice.users.UserRestRecipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository repository;
    private final UserRestRecipe userRestRecipe;

    @Override
    public Favorite addFavorite(Favorite favorite) {
        Favorite saveFavorite= repository.save(favorite);
        saveFavorite.setUser(userRestRecipe.findUserById(favorite.getUserId()));
        return saveFavorite;
    }

    @Override
    public void removeFavorite(Long recipeId) {

    }

    @Override
    public List<Favorite> getFavorites() {
    List<Favorite> allFavorite = repository.findAll();
    allFavorite.forEach(favorite -> favorite.setUser(userRestRecipe.findUserById(favorite.getUserId())));
    return allFavorite;
    }
}

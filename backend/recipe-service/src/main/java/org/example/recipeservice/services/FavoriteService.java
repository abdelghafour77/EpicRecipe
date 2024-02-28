package org.example.recipeservice.services;

import org.example.recipeservice.entities.Favorite;

import java.util.List;

public interface FavoriteService {
    Favorite addFavorite(Favorite favorite);
    void removeFavorite(Long recipeId);
    List<Favorite> getFavorites();
}

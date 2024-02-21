package org.example.recipeservice.services;

public interface FavoriteService {
    void addFavorite(Long recipeId);
    void removeFavorite(Long recipeId);
    void getFavorites();
}

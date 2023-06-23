package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.Favorite;


import java.util.List;
import java.util.Optional;

public interface IFavoritesService {
    List<Favorite> findAll();

    Optional<Favorite> findByFavorites(Integer idFavorites);

    Favorite create(String name, String username, String userEmail);

    Favorite update(String name, String username, String userEmail);

    void deleteByName(String name, String username, String userEmail);

    void delete(Integer idFavorite);
}

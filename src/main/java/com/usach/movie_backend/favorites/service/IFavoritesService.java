package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.Favorites;


import java.util.List;
import java.util.Optional;

public interface IFavoritesService<T> {
    List<Favorites> findAll();

    Optional<Favorites> findByFavorites(Integer idFavorites);

    Favorites create(Favorites favorites);

    Favorites update(Favorites favorites);

    void delete(Integer idFavorites);
}

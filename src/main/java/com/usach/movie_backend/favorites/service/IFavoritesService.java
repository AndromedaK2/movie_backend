package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.Favorite;


import java.util.List;
import java.util.Optional;

public interface IFavoritesService {
    List<Favorite> findAll();

    Optional<Favorite> findByFavorites(Integer idFavorites);

    Favorite create(Favorite favorites);

    Favorite update(Favorite favorites);

    void delete(Integer idFavorites);
}

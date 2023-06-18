package com.usach.movie_backend.favorites.service;


import com.usach.movie_backend.favorites.domain.FavoritesMovies;

import java.util.List;
import java.util.Optional;

public interface IFavoritesMoviesService<T> {
    List<FavoritesMovies> findAll();

    Optional<FavoritesMovies> findByFavoritesMovies(Integer idFavoritesMovies);

    FavoritesMovies create(FavoritesMovies favoritesMovies);

    FavoritesMovies update(FavoritesMovies favoritesMovies);

    void delete(Integer idFavoritesMovies);
}

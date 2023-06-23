package com.usach.movie_backend.favorites.service;


import com.usach.movie_backend.favorites.domain.FavoritesMovie;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieCreate;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieDelete;

import java.util.List;
import java.util.Optional;

public interface IFavoritesMoviesService{
    List<FavoritesMovie> findAll();

    FavoritesMovie create(FavoriteMovieCreate favoritesMovieCreate);

    void delete(FavoriteMovieDelete favoriteMovieDelete);
}

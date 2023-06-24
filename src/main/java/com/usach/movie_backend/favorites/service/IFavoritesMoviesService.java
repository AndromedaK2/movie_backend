package com.usach.movie_backend.favorites.service;


import com.usach.movie_backend.favorites.domain.FavoritesMovie;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieCreate;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieDelete;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieGet;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieList;

import java.util.List;
import java.util.Optional;

public interface IFavoritesMoviesService{
    List<FavoritesMovie> findAll();
    FavoriteMovieList findFavoriteMovies(FavoriteMovieGet favoriteMovieGet);

    FavoritesMovie create(FavoriteMovieCreate favoritesMovieCreate);

    void delete(FavoriteMovieDelete favoriteMovieDelete);
}

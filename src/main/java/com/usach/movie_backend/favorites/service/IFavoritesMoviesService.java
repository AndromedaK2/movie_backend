package com.usach.movie_backend.favorites.service;


import com.usach.movie_backend.favorites.domain.FavoritesMovie;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieCreate;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieDelete;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieGet;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovies;

import java.util.List;

public interface IFavoritesMoviesService{
    List<FavoritesMovie> findAll();
    FavoriteMovies findFavoriteMovies(FavoriteMovieGet favoriteMovieGet);

    FavoritesMovie create(FavoriteMovieCreate favoritesMovieCreate);

    void delete(FavoriteMovieDelete favoriteMovieDelete);
}

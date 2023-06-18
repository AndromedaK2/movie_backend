package com.usach.movie_backend.favorites.service;


import com.usach.movie_backend.favorites.domain.FavoritesSeries;

import java.util.List;
import java.util.Optional;

public interface IFavoritesSeriesService <T>{
    List<FavoritesSeries> findAll();

    Optional<FavoritesSeries> findByFavoritesSeries(Integer idFavoritesSeries);

    FavoritesSeries create(FavoritesSeries favoritesSeries);

    FavoritesSeries update(FavoritesSeries favoritesSeries);

    void delete(Integer idFavoritesMovies);
}

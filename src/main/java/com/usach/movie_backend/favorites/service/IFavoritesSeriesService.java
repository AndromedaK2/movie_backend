package com.usach.movie_backend.favorites.service;


import com.usach.movie_backend.favorites.domain.FavoritesSerie;

import java.util.List;
import java.util.Optional;

public interface IFavoritesSeriesService <T>{
    List<FavoritesSerie> findAll();

    Optional<FavoritesSerie> findByFavoritesSeries(Integer idFavoritesSeries);

    FavoritesSerie create(FavoritesSerie favoritesSeries);

    FavoritesSerie update(FavoritesSerie favoritesSeries);

    void delete(Integer idFavoritesMovies);
}

package com.usach.movie_backend.favorites.service;


import com.usach.movie_backend.favorites.domain.FavoritesSerie;
import com.usach.movie_backend.favorites.service.dto.FavoriteSerieCreate;
import com.usach.movie_backend.favorites.service.dto.FavoriteSerieDelete;

import java.util.List;

public interface IFavoritesSeriesService {
    List<FavoritesSerie> findAll();

    FavoritesSerie create(FavoriteSerieCreate favoritesSeries);

    void delete(FavoriteSerieDelete idFavoritesMovies);
}

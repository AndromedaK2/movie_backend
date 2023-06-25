package com.usach.movie_backend.favorites.service.dto;

import com.usach.movie_backend.series.domain.Serie;

import java.util.List;

public record FavoriteSeries(Integer idFavorite, List<Serie> series) {
}

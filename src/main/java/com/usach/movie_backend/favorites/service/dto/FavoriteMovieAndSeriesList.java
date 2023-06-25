package com.usach.movie_backend.favorites.service.dto;

import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.series.domain.Serie;

import java.util.List;

public record FavoriteMovieAndSeriesList(
        Integer idFavorite, List<Movie> movies, List<Serie> series) {}

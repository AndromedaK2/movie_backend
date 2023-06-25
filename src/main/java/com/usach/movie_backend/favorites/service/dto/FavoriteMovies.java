package com.usach.movie_backend.favorites.service.dto;

import com.usach.movie_backend.movies.domain.Movie;

import java.util.List;

public record FavoriteMovies(Integer idFavorite, List<Movie> movies) {
}

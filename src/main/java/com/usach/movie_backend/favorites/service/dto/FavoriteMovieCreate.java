package com.usach.movie_backend.favorites.service.dto;

public record FavoriteMovieCreate(String name, String username,
                                  String userEmail, String movieTitle) {
}

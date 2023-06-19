package com.usach.movie_backend.movies.service;


import com.usach.movie_backend.movies.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface IMoviesService<T> {
    List<Movie> findAll();

    Optional<Movie> findByMovieId(Integer idMovie);

    Movie create(Movie movies);

    Movie update(Movie movies);

    void delete(Integer idMovie);

    Movie findByTitle(String title);
}

package com.usach.movie_backend.movies.service;


import com.usach.movie_backend.movies.domain.Movie;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IMoviesService<T> {
    Page<Movie> findAll(Integer page, Integer size);

    Optional<Movie> findByMovieId(Integer idMovie);

    Movie create(Movie movies);

    Movie update(Movie movies);

    void delete(Integer idMovie);

    Movie findByTitle(String title);
}

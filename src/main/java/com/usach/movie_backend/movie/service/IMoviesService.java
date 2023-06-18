package com.usach.movie_backend.movie.service;


import com.usach.movie_backend.movie.domain.Movies;

import java.util.List;
import java.util.Optional;

public interface IMoviesService<T> {
    List<Movies> findAll();

    Optional<Movies> findByMovie(Integer idMovie);

    Movies create(Movies movies);

    Movies update(Movies movies);

    void delete(Integer idMovie);
}

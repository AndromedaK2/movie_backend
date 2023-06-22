package com.usach.movie_backend.movies.service;


import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.service.dto.MovieUpdate;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IMoviesService {
    Page<Movie> findAll(Integer page, Integer size, String genderName,
                        String producerName, String directorFirstName,
                        String directorLastName);

    Optional<Movie> findByMovieId(Integer idMovie);

    Movie create(Movie movies);

    Movie update(MovieUpdate movieUpdate);

    void delete(String idMovie);

    Movie findByTitle(String title);
}

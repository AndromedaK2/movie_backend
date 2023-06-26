package com.usach.movie_backend.movies.service;


import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.service.dto.MovieCreate;
import com.usach.movie_backend.movies.service.dto.MovieUpdate;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IMoviesService {
    Page<Movie> findAllByFilters(Integer page, Integer size, String genderName,
                        String producerName, String directorFirstName,
                        String directorLastName, String title);

    Optional<Movie> findByMovieId(Integer idMovie);

    List<Movie> findAllFavoritesByIdFavorite(Integer idFavorite);

    Movie create(MovieCreate movieCreate);

    Movie update(MovieUpdate movieUpdate);
    Movie updateAll(Movie movie);
    void delete(String idMovie);

    Movie findByTitle(String title);
}

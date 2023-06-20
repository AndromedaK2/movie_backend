package com.usach.movie_backend.movies.repository;

import com.usach.movie_backend.movies.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMoviesRepository extends JpaRepository<Movie,Integer> {
    List<Movie> findAll();

    Optional<Movie> findMovieByTitle(String title);

    void deleteByTitle(String title);

}

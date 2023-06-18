package com.usach.movie_backend.movie.repository;

import com.usach.movie_backend.movie.domain.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMoviesRepository extends JpaRepository<Movies,Integer> {
    List<Movies> findAll();
}

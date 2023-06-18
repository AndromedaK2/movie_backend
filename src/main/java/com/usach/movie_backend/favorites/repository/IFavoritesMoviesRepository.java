package com.usach.movie_backend.favorites.repository;

import com.usach.movie_backend.favorites.domain.FavoritesMovies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavoritesMoviesRepository extends JpaRepository<FavoritesMovies,Integer> {
    List<FavoritesMovies> findAll();
}

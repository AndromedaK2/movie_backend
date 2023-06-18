package com.usach.movie_backend.favorites.repository;

import com.usach.movie_backend.favorites.domain.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavoritesRepository extends JpaRepository<Favorites, Integer> {
    List<Favorites> findAll();
}

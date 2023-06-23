package com.usach.movie_backend.favorites.repository;

import com.usach.movie_backend.favorites.domain.FavoritesSerie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavoritesSeriesRepository extends JpaRepository<FavoritesSerie,Integer> {
    List<FavoritesSerie> findAll();
}

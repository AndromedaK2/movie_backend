package com.usach.movie_backend.favorites.repository;

import com.usach.movie_backend.favorites.domain.FavoritesSeries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavoritesSeriesRepository extends JpaRepository<FavoritesSeries,Integer> {
    List<FavoritesSeries> findAll();
}

package com.usach.movie_backend.favorites.repository;

import com.usach.movie_backend.favorites.domain.FavoritesMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IFavoritesMoviesRepository extends JpaRepository<FavoritesMovie,Integer> {
    Optional<FavoritesMovie> findFavoritesMovieByIdFavoriteAndIdMovie(
            @Param("idFavorite") Integer idFavorite,
            @Param("idMovie") Integer idMovie
    );
}

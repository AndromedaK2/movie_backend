package com.usach.movie_backend.favorites.repository;

import com.usach.movie_backend.favorites.domain.FavoritesSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IFavoritesSeriesRepository extends JpaRepository<FavoritesSerie,Integer> {

    Optional<FavoritesSerie> findFavoritesMovieByIdFavoriteAndIdSerie(
            @Param("idFavorite") Integer idFavorite,
            @Param("idSerie") Integer idSerie
    );
}

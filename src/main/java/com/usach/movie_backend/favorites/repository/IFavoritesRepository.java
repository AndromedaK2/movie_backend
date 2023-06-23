package com.usach.movie_backend.favorites.repository;

import com.usach.movie_backend.favorites.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IFavoritesRepository extends JpaRepository<Favorite, Integer> {

    Optional<Favorite> findByNameAndIdProfile(@Param("name") String name,@Param("idProfile") Integer idProfile);
}

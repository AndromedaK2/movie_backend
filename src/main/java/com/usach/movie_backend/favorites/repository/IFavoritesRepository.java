package com.usach.movie_backend.favorites.repository;

import com.usach.movie_backend.favorites.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IFavoritesRepository extends JpaRepository<Favorite, Integer> {

    Optional<Favorite> findByNameAndIdProfile(String name, Integer idProfile);
}

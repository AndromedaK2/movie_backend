package com.usach.movie_backend.seasons.repository;

import com.usach.movie_backend.seasons.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISeasonRepository extends JpaRepository<Season,Integer> {
    List<Season>findAll();
}

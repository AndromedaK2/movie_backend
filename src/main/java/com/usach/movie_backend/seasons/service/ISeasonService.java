package com.usach.movie_backend.seasons.service;

import com.usach.movie_backend.seasons.domain.Season;

import java.util.List;
import java.util.Optional;

public interface ISeasonService <T>{

    List<Season> findAll();

    Optional<Season> findBySeason(Integer idSeason);

    Season create(Season season);

    Season update(Season season);

    void delete(Integer idSeason);
}

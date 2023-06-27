package com.usach.movie_backend.seasons.service;

import com.usach.movie_backend.seasons.domain.Season;

import java.util.List;

public interface ISeasonService {

    List<Season> findAll();

   Season findBySeason(Integer idSeason);

    List <Season> findAllByTitle(String title);

    Season findByTitle(String title);

    Season create(SeasonCreate seasonCreate);

    Season update(Season season);

    void delete(Integer idSeason);
}

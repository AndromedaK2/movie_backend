package com.usach.movie_backend.seasons.service;


import com.usach.movie_backend.seasons.domain.Season;
import com.usach.movie_backend.seasons.repository.ISeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService implements ISeasonService<Season>{
    @Autowired
    private ISeasonRepository iSeasonRepository;
    @Override
    public List<Season> findAll() {
        return iSeasonRepository.findAll();
    }

    @Override
    public Optional<Season> findBySeason(Integer idSeason) {
        return iSeasonRepository.findById(idSeason);
    }

    @Override
    public Season create(Season season) {
        return iSeasonRepository.save(season);
    }

    @Override
    public Season update(Season season) {
        return iSeasonRepository.save(season);
    }

    @Override
    public void delete(Integer idSeason) {

        iSeasonRepository.deleteById(idSeason);
    }
}

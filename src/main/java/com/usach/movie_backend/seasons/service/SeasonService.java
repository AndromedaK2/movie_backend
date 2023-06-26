package com.usach.movie_backend.seasons.service;


import com.usach.movie_backend.movies.service.MoviesService;
import com.usach.movie_backend.seasons.domain.Season;
import com.usach.movie_backend.seasons.repository.ISeasonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService implements ISeasonService<Season>{
    @Autowired
    private ISeasonRepository iSeasonRepository;
    private final static Logger logger = LoggerFactory.getLogger(SeasonService.class);
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
    public List<Season> findByTitle(String title) {
        if(title.isBlank()){
            logger.info("Retrieves Series without filters");
            return iSeasonRepository.findAllByFilters(title);
        }
        return iSeasonRepository.findAllByFilters(title);
    }
    @Override
    public void delete(Integer idSeason) {

        iSeasonRepository.deleteById(idSeason);
    }
}

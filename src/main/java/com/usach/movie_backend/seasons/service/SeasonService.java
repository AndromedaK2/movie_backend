package com.usach.movie_backend.seasons.service;


import com.usach.movie_backend.seasons.domain.Season;
import com.usach.movie_backend.seasons.repository.ISeasonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService implements ISeasonService{
    @Autowired
    private ISeasonRepository seasonRepository;
    private final static Logger logger = LoggerFactory.getLogger(SeasonService.class);
    @Transactional(readOnly = true)
    public List<Season> findAll() {
        return seasonRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Season findBySeason(Integer idSeason) {
        return seasonRepository.findById(idSeason).get();
    }

    @Transactional(noRollbackFor = {RuntimeException.class})
    public Season create(Season season) {
        return seasonRepository.save(season);
    }

    @Transactional(noRollbackFor = {RuntimeException.class})
    public Season update(Season season) {
        return seasonRepository.save(season);
    }

    @Transactional(readOnly = true)
    public List<Season> findAllByTitle(String title) {
        if(title.isBlank()){
            logger.info("Retrieves Series without filters");
            return seasonRepository.findAll();
        }
        return seasonRepository.findAllByFilters(title);
    }

    @Transactional(readOnly = true)
    public Season findByTitle(String title) {
        Optional<Season> season = seasonRepository.findSeasonByTitle(title);
        if(season.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Serie not found");
        return season.get();
    }


    @Override
    public void delete(Integer idSeason) {

        seasonRepository.deleteById(idSeason);
    }
}

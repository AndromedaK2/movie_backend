package com.usach.movie_backend.serie.service;

import com.usach.movie_backend.serie.domain.Series;
import com.usach.movie_backend.serie.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService  implements ISerieService<Series>{
    @Autowired
    private ISerieRepository iSerieRepository;
    @Override
    public List<Series> findAll() {
        return iSerieRepository.findAll();
    }

    @Override
    public Optional<Series> findBySerie(Integer idSerie) {
        return iSerieRepository.findById(idSerie);
    }

    @Override
    public Series create(Series serie) {
        return iSerieRepository.save(serie);
    }

    @Override
    public Series update(Series serie) {
        return iSerieRepository.save(serie);
    }

    @Override
    public void delete(Integer idSerie) {
        iSerieRepository.deleteById(idSerie);
    }
}

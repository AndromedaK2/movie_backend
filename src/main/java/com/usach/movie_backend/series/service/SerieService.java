package com.usach.movie_backend.series.service;

import com.usach.movie_backend.series.domain.Serie;
import com.usach.movie_backend.series.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService  implements ISerieService{
    @Autowired
    private ISerieRepository serieRepository;

    @Transactional(readOnly = true)
    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Serie findByName(String name) {
        Optional<Serie> serie = serieRepository.findByName(name);
        if(serie.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Serie not found");
        return serie.get();
    }

    @Override
    public Serie create(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public Serie update(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public void delete(Integer idSerie) {
        serieRepository.deleteById(idSerie);
    }
}

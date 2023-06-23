package com.usach.movie_backend.series.service;


import com.usach.movie_backend.directors.service.IDirectorService;
import com.usach.movie_backend.producers.service.IProducerService;
import com.usach.movie_backend.series.domain.Serie;
import com.usach.movie_backend.series.repository.ISerieRepository;
import com.usach.movie_backend.series.service.dto.SerieCreate;
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
    @Autowired
    private IDirectorService directorService;
    @Autowired
    private IProducerService producerService;

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

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public Serie create(SerieCreate serieCreate) {
        if(serieRepository.findByName(serieCreate.name()).isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Serie already exists");
        Integer idDirector = directorService.findByFirstNameAndLastName(
                serieCreate.directorFirstName(),
                serieCreate.directorLastName()).getIdDirector();
        Integer idProducer = producerService.findByName(serieCreate.producerName()).getIdProducer();
        Serie serie = new Serie();
        serie.setName(serieCreate.name());
        serie.setUrlPhoto(serieCreate.urlPhoto());
        serie.setTrailer(serieCreate.trailer());
        serie.setActive(serieCreate.active());
        serie.setReleaseDate(serieCreate.releaseDate());
        serie.setSynopsis(serieCreate.synopsis());
        serie.setIdDirector(idDirector);
        serie.setIdProducer(idProducer);
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

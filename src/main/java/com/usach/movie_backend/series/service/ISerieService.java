package com.usach.movie_backend.series.service;


import com.usach.movie_backend.series.domain.Serie;
import com.usach.movie_backend.series.service.dto.SerieCreate;
import com.usach.movie_backend.series.service.dto.SerieUpdate;

import java.util.List;

public interface ISerieService{
    List<Serie> findAll();

    Serie findByName(String name);

    Serie create(SerieCreate serieCreate);

    Serie update(SerieUpdate serieUpdate);

    void delete(Integer idSerie);
}

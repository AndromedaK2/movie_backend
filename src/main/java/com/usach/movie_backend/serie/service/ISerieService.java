package com.usach.movie_backend.serie.service;


import com.usach.movie_backend.serie.domain.Series;

import java.util.List;
import java.util.Optional;

public interface ISerieService<T> {
    List<Series> findAll();

    Optional<Series> findBySerie(Integer idSerie);

    Series create(Series serie);

    Series update(Series serie);

    void delete(Integer idSerie);
}

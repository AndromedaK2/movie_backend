package com.usach.movie_backend.series.service;


import com.usach.movie_backend.series.domain.Serie;

import java.util.List;

public interface ISerieService{
    List<Serie> findAll();

    Serie findByName(String name);

    Serie create(Serie serie);

    Serie update(Serie serie);

    void delete(Integer idSerie);
}

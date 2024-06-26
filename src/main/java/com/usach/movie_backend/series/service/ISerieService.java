package com.usach.movie_backend.series.service;


import com.usach.movie_backend.series.domain.Serie;
import com.usach.movie_backend.series.service.dto.SerieCreate;
import com.usach.movie_backend.series.service.dto.SerieUpdate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ISerieService{
    List<Serie> findAll();

    Serie findByName(String name);

    List<Serie>findAllViews();
    List<Serie>findAllNote();


    List<Serie> findFavoriteSeriesByIdFavorite(Integer idFavorite);

    Serie create(SerieCreate serieCreate);

    Serie update(SerieUpdate serieUpdate);

    void delete(Integer idSerie);
}

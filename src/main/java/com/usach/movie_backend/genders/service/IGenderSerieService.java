package com.usach.movie_backend.genders.service;


import com.usach.movie_backend.genders.domain.GenderSerie;

import java.util.List;
import java.util.Optional;

public interface IGenderSerieService<T> {
    List<GenderSerie> findAll();

    Optional<GenderSerie> findByGenderSerie(Integer idGenderSerie);

    GenderSerie create(GenderSerie genderMovie);

    GenderSerie update(GenderSerie genderMovie);

    void delete(Integer idGenderSerie);
}

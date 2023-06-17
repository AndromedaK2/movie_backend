package com.usach.movie_backend.genders.service;

import com.usach.movie_backend.genders.domain.GenderMovie;

import java.util.List;
import java.util.Optional;

public interface IGenderMovieService<T> {
    List<GenderMovie> findAll();

    Optional<GenderMovie> findByGenderMovie(Integer idGenderMovie);

    GenderMovie create(GenderMovie genderMovie);

    GenderMovie update(GenderMovie genderMovie);

    void delete(Integer idGenderMovie);
}

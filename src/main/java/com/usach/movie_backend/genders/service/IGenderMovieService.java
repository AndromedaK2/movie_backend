package com.usach.movie_backend.genders.service;

import com.usach.movie_backend.genders.domain.GenderMovie;

import java.util.List;
import java.util.Optional;

public interface IGenderMovieService {
    List<GenderMovie> findAll();

    Optional<GenderMovie> findByGenderMovie(Integer idGenderMovie);

    List<GenderMovie> findByIdGender(Integer idGender);

    GenderMovie create(GenderMovie genderMovie);

    GenderMovie update(GenderMovie genderMovie);

    void delete(Integer idGenderMovie);
}

package com.usach.movie_backend.genders.service;

import com.usach.movie_backend.directors.domain.Director;
import com.usach.movie_backend.genders.domain.Gender;

import java.util.List;
import java.util.Optional;

public interface IGenderService<T> {
    List<Gender> findAll();

    Optional<Gender> findByGender(Integer idGender);

    Gender create(Gender gender);

    Gender update(Gender gender);

    void delete(Integer idGender);
}

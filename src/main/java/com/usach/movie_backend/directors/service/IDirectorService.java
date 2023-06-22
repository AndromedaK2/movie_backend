package com.usach.movie_backend.directors.service;

import com.usach.movie_backend.directors.domain.Director;


import java.util.List;
import java.util.Optional;

public interface IDirectorService{
    List<Director> findAll();

    Optional<Director> findByDirector(Integer idDirector);

    Director create(Director director);

    Director update(Director director);

    void delete(Integer idDirector);

    Director findByFirstNameAndLastName(String firstName, String lastName);
}

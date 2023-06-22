package com.usach.movie_backend.genders.repository;

import com.usach.movie_backend.genders.domain.GenderMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGenderMovieRepository extends JpaRepository<GenderMovie,Integer> {

    List<GenderMovie> findAll();

    List<GenderMovie> findGenderMovieByIdGender(Integer idGender);
}

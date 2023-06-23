package com.usach.movie_backend.series.repository;

import com.usach.movie_backend.series.domain.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISerieRepository extends JpaRepository<Serie,Integer> {

    List<Serie> findByGenders_IdGender(Integer idGender);

    Optional<Serie> findByName(String name);
}

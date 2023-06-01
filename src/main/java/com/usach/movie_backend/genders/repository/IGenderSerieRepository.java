package com.usach.movie_backend.genders.repository;

import com.usach.movie_backend.genders.domain.GenderSerie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGenderSerieRepository extends JpaRepository<GenderSerie,Integer> {

    List<GenderSerie> findAll();
}

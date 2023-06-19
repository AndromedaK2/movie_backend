package com.usach.movie_backend.series.repository;

import com.usach.movie_backend.series.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Series,Integer> {
    List<Series> findAll();
}

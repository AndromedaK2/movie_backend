package com.usach.movie_backend.seasons.repository;

import com.usach.movie_backend.seasons.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeasonRepository extends JpaRepository<Season,Integer> {
    List<Season>findAll();
    @Query(value = "SELECT * FROM seasons where title like CONCAT('%',:title,'%')", nativeQuery = true)
    List<Season> findAllByFilters(@Param("title")String title);

}

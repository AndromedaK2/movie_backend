package com.usach.movie_backend.seasons.repository;

import com.usach.movie_backend.seasons.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ISeasonRepository extends JpaRepository<Season,Integer> {

    @Query(value = "SELECT * FROM seasons where title like CONCAT('%',:title,'%')", nativeQuery = true)
    List<Season> findAllByFilters(@Param("title")String title);

    Optional<Season> findSeasonByTitle(@Param("title") String title);

}

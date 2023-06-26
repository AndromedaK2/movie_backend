package com.usach.movie_backend.comments.repository;

import com.usach.movie_backend.comments.domain.CommentsProfilesSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentsProfilesSeriesRepository extends JpaRepository<CommentsProfilesSeries,Integer> {
    List<CommentsProfilesSeries> findAll();

    @Query(value = "select AVG(note) from comments_profiles_series where id_serie = :idSerie", nativeQuery = true)
    Double commentAVGNote(@Param("idSerie") Integer idSerie);
}

package com.usach.movie_backend.comments.repository;

import com.usach.movie_backend.comments.domain.CommentsProfilesSeries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentsProfilesSeriesRepository extends JpaRepository<CommentsProfilesSeries,Integer> {
    List<CommentsProfilesSeries> findAll();
}

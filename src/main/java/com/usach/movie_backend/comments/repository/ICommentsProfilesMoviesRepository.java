package com.usach.movie_backend.comments.repository;

import com.usach.movie_backend.comments.domain.CommentsProfilesMovies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentsProfilesMoviesRepository extends JpaRepository<CommentsProfilesMovies,Integer> {
    List<CommentsProfilesMovies> findAll();
}

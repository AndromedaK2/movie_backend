package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesMovies;


import java.util.List;
import java.util.Optional;

public interface ICommentsProfilesMoviesService<T> {

    List<CommentsProfilesMovies> findAll();

    Optional<CommentsProfilesMovies> findByCommentsProfilesMovies(Integer idCommentsProfilesMovies);

    CommentsProfilesMovies create(CommentsProfilesMovies commentsProfilesMovies);

    CommentsProfilesMovies update(CommentsProfilesMovies commentsProfilesMovies);

    void delete(Integer idCommentsProfilesMovies);
}

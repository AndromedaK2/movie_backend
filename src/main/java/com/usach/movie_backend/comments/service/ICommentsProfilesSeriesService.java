package com.usach.movie_backend.comments.service;



import com.usach.movie_backend.comments.domain.CommentsProfilesSeries;

import java.util.List;
import java.util.Optional;

public interface ICommentsProfilesSeriesService<T> {

    List<CommentsProfilesSeries> findAll();

    Optional<CommentsProfilesSeries> findByCommentsProfilesSeries(Integer idCommentsProfilesSeries);

    CommentsProfilesSeries create(CommentsProfilesSeries commentsProfilesSeries);

    CommentsProfilesSeries update(CommentsProfilesSeries commentsProfilesSeries);

    void delete(Integer idCommentsProfilesSeries);
}

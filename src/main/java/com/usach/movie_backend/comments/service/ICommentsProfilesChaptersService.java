package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesChapters;


import java.util.List;
import java.util.Optional;

public interface ICommentsProfilesChaptersService<T> {

    List<CommentsProfilesChapters> findAll();

    Optional<CommentsProfilesChapters> findByCommentsCommentsProfilesChapters(Integer idCommentsProfilesChapters);

    CommentsProfilesChapters create(CommentsProfilesChapters commentsProfilesChapters);



    CommentsProfilesChapters update(CommentsProfilesChapters commentsProfilesChapters);

    void delete(Integer idCommentsProfilesChapters);
}


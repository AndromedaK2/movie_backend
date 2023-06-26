package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesMovies;
import com.usach.movie_backend.comments.service.dto.CommentProfileMovieCreate;
import com.usach.movie_backend.comments.service.dto.CommentProfileMovieUpdate;


import java.util.List;
import java.util.Optional;

public interface ICommentsProfilesMoviesService{

    List findAll();

    Double sumCommentsMovie(Integer idMovie);
    Double numberComments(Integer idMovie);

    Double commentsAVGNote(Integer idMovie);

    CommentsProfilesMovies findByCommentsProfilesMovies(Integer idCommentsProfilesMovies);

    CommentsProfilesMovies create(CommentProfileMovieCreate commentsProfilesMovies);

    CommentsProfilesMovies update(CommentProfileMovieUpdate commentsProfilesMovies);

    void delete(Integer idCommentsProfilesMovies);
}

package com.usach.movie_backend.comments.service;



import com.usach.movie_backend.comments.domain.CommentsProfilesSeries;
import com.usach.movie_backend.comments.service.dto.CommentProfileMovieUpdate;
import com.usach.movie_backend.comments.service.dto.CommentProfileSerieCreate;
import com.usach.movie_backend.comments.service.dto.CommentProfileSerieUpdate;

import java.util.List;
import java.util.Optional;

public interface ICommentsProfilesSeriesService {

    List<CommentsProfilesSeries> findAll();

    CommentsProfilesSeries findByCommentsProfilesSeries(Integer idCommentsProfilesSeries);

    Double commentsSerieAVG(Integer idSerie);

    CommentsProfilesSeries create(CommentProfileSerieCreate commentProfileSerieCreate);

    CommentsProfilesSeries update(CommentProfileSerieUpdate commentProfileSerieUpdate);

    void delete(Integer idCommentsProfilesSeries);
}

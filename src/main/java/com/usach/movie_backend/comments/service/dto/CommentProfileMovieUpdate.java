package com.usach.movie_backend.comments.service.dto;

public record CommentProfileMovieUpdate(
        String description,
        Integer idComment,

        Double noteUpdate,
        String title,
        String username,
        String userEmail ) {
}

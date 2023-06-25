package com.usach.movie_backend.comments.service.dto;

public record CommentProfileMovieUpdate(
        String description,
        Integer idComment,
        Integer note,
        String title,
        String username,
        String userEmail ) {
}

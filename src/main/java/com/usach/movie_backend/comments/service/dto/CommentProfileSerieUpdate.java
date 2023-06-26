package com.usach.movie_backend.comments.service.dto;

public record CommentProfileSerieUpdate(
        String description,
        Double noteupdate,
        String title,
        String username,
        String userEmail,
        Integer idCommentSerie

) {
}

package com.usach.movie_backend.comments.service.dto;

public record CommentProfileSerieCreate(String description ,
                                        Double note,
                                        String title,
                                        String username,
                                        String userEmail) {
}

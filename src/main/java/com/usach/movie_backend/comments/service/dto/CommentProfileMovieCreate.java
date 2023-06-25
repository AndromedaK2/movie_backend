package com.usach.movie_backend.comments.service.dto;

import jakarta.persistence.Column;

import java.util.Date;

public record CommentProfileMovieCreate(String description,
                                        Integer note,
                                        String title,
                                        String username,
                                        String userEmail) {
}



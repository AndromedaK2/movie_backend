package com.usach.movie_backend.configuration.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorException {
    private String code;
    private String message;
}

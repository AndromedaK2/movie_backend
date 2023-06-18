package com.usach.movie_backend.configuration.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;


@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends  RuntimeException{

    private HttpStatus status;
    private String code;

    @Builder
    public BusinessException(String code, HttpStatus  status, String message){
        super(message);
        this.status = status;
        this.code = code;
    }
}

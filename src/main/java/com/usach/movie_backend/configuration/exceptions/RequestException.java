package com.usach.movie_backend.configuration.exceptions;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class RequestException  extends  RuntimeException{

    private  String code;

    @Builder
    public RequestException(String code,String message){
        super(message);
        this.code = code;
    }
}

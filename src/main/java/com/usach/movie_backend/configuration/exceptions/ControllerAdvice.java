package com.usach.movie_backend.configuration.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorException> runtimeExceptionHandler(RuntimeException ex){
        ErrorException errorException = ErrorException.builder().code("500")
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorException> requestExceptionHandler(RequestException ex){
        ErrorException errorException = ErrorException.builder().code(ex.getCode())
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorException> businessExceptionHandler(BusinessException ex){
        ErrorException errorException = ErrorException.builder().code(ex.getCode())
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorException,ex.getStatus());
    }

    @ExceptionHandler(value = SQLException.class)
    public ResponseEntity<ErrorException> sqlExceptionHandler(SQLException ex){
        ErrorException errorException = ErrorException.builder()
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorException,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

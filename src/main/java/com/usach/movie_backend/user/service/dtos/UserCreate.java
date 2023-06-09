package com.usach.movie_backend.user.service.dtos;
import java.util.Date;

public record UserCreate(
        String firstName,
        String lastName,
        String email,
        Date birthday,
        String password) {}
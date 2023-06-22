package com.usach.movie_backend.users.service.dto;
import java.util.Date;

public record UserCreate(
        String firstName,
        String lastName,
        String email,
        Date birthday,
        String password) {}

package com.usach.movie_backend.directors.service.dto;

import jakarta.persistence.Column;

import java.util.Date;

public record DirectorCreate(String firstName, String lastName,
                             Date birthdate, String nationality, String urlPhoto) {
}



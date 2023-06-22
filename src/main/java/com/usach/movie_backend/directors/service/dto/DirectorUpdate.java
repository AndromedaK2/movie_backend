package com.usach.movie_backend.directors.service.dto;

import java.util.Date;

public record DirectorUpdate(String firstName, String lastName,
                             Date birthdate, String nationality, String urlPhoto) {
}

package com.usach.movie_backend.movies.service.dto;

import java.util.Date;

public record MovieCreate(String title, String duration, boolean active, String synopsis,
                          String urlTrailer, String urlPhoto, String urlVideo, Date releaseDate,
                          String directorFirstName, String directorLastName , String producerName) {
}

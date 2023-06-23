package com.usach.movie_backend.series.service.dto;

import java.util.Date;

public record SerieUpdate(String name, boolean active, String synopsis,
                          String trailer, String urlPhoto, Date releaseDate,
                          String directorFirstName, String directorLastName , String producerName) {
}

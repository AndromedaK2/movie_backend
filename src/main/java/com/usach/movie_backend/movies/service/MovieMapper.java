package com.usach.movie_backend.movies.service;

import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.service.dto.MovieCreate;
import com.usach.movie_backend.movies.service.dto.MovieUpdate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MovieMapper {
    
    public Movie createMovieMapper(Integer idDirector,Integer idProducer, MovieCreate movieCreate) {
        Movie movie = new Movie();
        movie.setTitle(movieCreate.title());
        movie.setIdDirector(idDirector);
        movie.setIdProducer(idProducer);
        movie.setDuration(movieCreate.duration());
        movie.setActive(movieCreate.active());
        movie.setSynopsis(movieCreate.synopsis());
        movie.setUrlTrailer(movieCreate.urlTrailer());
        movie.setUrlPhoto(movie.getUrlPhoto());
        movie.setUrlVideo(movieCreate.urlVideo());
        movie.setReleaseDate(movieCreate.releaseDate());
        movie.setNote(0f);
        movie.setViews(0);
        return movie;
    }
    public void updateMovieMapper(Integer idDirector, Integer idProducer, Movie movie, MovieUpdate movieUpdate) {
        movie.setTitle(movieUpdate.title());
        movie.setIdDirector(idDirector);
        movie.setIdProducer(idProducer);
        movie.setDuration(movieUpdate.duration());
        movie.setActive(movieUpdate.active());
        movie.setSynopsis(movieUpdate.synopsis());
        movie.setUrlTrailer(movieUpdate.urlTrailer());
        movie.setUrlPhoto(movie.getUrlPhoto());
        movie.setUrlVideo(movieUpdate.urlVideo());
        movie.setReleaseDate(movieUpdate.releaseDate());
        movie.setNote(0f);
        movie.setViews(0);
    }
}

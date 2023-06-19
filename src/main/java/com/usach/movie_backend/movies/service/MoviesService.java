package com.usach.movie_backend.movies.service;

import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.repository.IMoviesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class MoviesService implements IMoviesService<Movie>{
    @Autowired
    private IMoviesRepository moviesRepository;

    private final static Logger logger = LoggerFactory.getLogger(MoviesService.class);
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return moviesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Movie> findByMovieId(Integer idMovie) {
        return moviesRepository.findById(idMovie);
    }

    @Transactional(readOnly = true)
    public Movie findByTitle(String title) {
        Optional<Movie> movie = moviesRepository.findMovieByTitle(title);
        if(movie.isEmpty()){
            logger.info("movie {0} not found",title );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie not found");
        }
        logger.info("movie {0} found",title );
        return movie.get();
    }
    @Override
    public Movie create(Movie movies) {
        return moviesRepository.save(movies);
    }

    @Override
    public Movie update(Movie movies) {
        return moviesRepository.save(movies);
    }

    @Override
    public void delete(Integer idMovie) {
        moviesRepository.deleteById(idMovie);

    }



}

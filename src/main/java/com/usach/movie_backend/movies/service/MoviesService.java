package com.usach.movie_backend.movies.service;

import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.repository.IMoviesRepository;
import com.usach.movie_backend.movies.service.dto.MovieUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.util.Optional;
@Service
public class MoviesService implements IMoviesService<Movie>{
    @Autowired
    private IMoviesRepository moviesRepository;

    private final static Logger logger = LoggerFactory.getLogger(MoviesService.class);
    @Transactional(readOnly = true)
    public Page<Movie> findAll(Integer page, Integer size) {
        logger.info("Retrieves Movies");
        return moviesRepository.findAll(PageRequest.of(page,size));
    }

    @Transactional(readOnly = true)
    public Optional<Movie> findByMovieId(Integer idMovie) {
        return moviesRepository.findById(idMovie);
    }

    @Transactional(readOnly = true)
    public Movie findByTitle(String title) {
        Optional<Movie> movie = moviesRepository.findMovieByTitle(title);
        if(movie.isEmpty()){
            logger.info(MessageFormat.format("movie {0} not found",title ) );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie not found");
        }
        logger.info(MessageFormat.format("movie {0} found",title ));
        return movie.get();
    }
    @Transactional(noRollbackFor = {BusinessException.class, ResponseStatusException.class})
    public Movie create(Movie movies) {
        return moviesRepository.save(movies);
    }

    @Transactional(noRollbackFor = {BusinessException.class, ResponseStatusException.class})
    public Movie update(MovieUpdate movieUpdate) {
        Movie movie = new Movie();
        movie.setTitle(movieUpdate.title());
        movie.setDuration(movie.getDuration());
        movie.setActive(true);
        movie.setSynopsis(movieUpdate.synopsis());
        movie.setUrlTrailer(movieUpdate.urlTrailer());
        movie.setUrlPhoto(movieUpdate.urlPhoto());
        movie.setUrlVideo(movieUpdate.urlVideo());
        movie.setReleaseDate(movieUpdate.releaseDate());
        movie.setNote(0f);
        movie.setViews(0);
        // search director
        movie.setIdDirector(1);

        // search producer
        movie.setIdProducer(1);

        logger.info("update movie");
        return moviesRepository.save(movie);
    }

    @Transactional
    public void delete(String title) {
        moviesRepository.deleteByTitle(title);
    }



}

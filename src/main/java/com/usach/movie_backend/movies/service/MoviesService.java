package com.usach.movie_backend.movies.service;

import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.directors.service.IDirectorService;
import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.repository.IMoviesRepository;
import com.usach.movie_backend.movies.service.dto.MovieCreate;
import com.usach.movie_backend.movies.service.dto.MovieUpdate;
import com.usach.movie_backend.producers.service.IProducerService;
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
public class MoviesService implements IMoviesService{

    @Autowired
    private IMoviesRepository moviesRepository;

    @Autowired
    private IDirectorService directorService;

    @Autowired
    private IProducerService producerService;

    private final static Logger logger = LoggerFactory.getLogger(MoviesService.class);
    @Autowired
    private MovieMapper movieMapper;

    @Transactional(readOnly = true)
    public Page<Movie> findAll(Integer page, Integer size, String genderName,String producerName, String directorFirstName, String directorLastName) {
        if(genderName.isBlank() && producerName.isBlank() && directorFirstName.isBlank() && directorLastName.isBlank()){
            logger.info("Retrieves movies without filters");
            return moviesRepository.findAll(PageRequest.of(page,size));
        }
        logger.info("Retrieves movies with filters");
        return moviesRepository.findAllByFilter(genderName,producerName,directorFirstName,directorLastName,PageRequest.of(page,size));
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
    public Movie create(MovieCreate movieCreate) {
        if(moviesRepository.findMovieByTitle(movieCreate.title()).isPresent()){
            logger.info(MessageFormat.format("movie {0} found",movieCreate.title()));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie already exists");
        }
        Integer idDirector = directorService.findByFirstNameAndLastName(
                movieCreate.directorFirstName(),
                movieCreate.directorLastName()).getIdDirector();
        Integer idProducer = producerService.findByName(movieCreate.producerName()).getIdProducer();

        Movie movie = movieMapper.createMovieMapper(idDirector, idProducer,movieCreate);
        return moviesRepository.save(movie);
    }


    @Transactional(noRollbackFor = {BusinessException.class, ResponseStatusException.class})
    public Movie update(MovieUpdate movieUpdate) {

        Movie movie = findByTitle(movieUpdate.title());
        Integer idDirector = directorService.findByFirstNameAndLastName(
                movieUpdate.directorFirstName(),
                movieUpdate.directorLastName()).getIdDirector();
        Integer idProducer = producerService.findByName(movieUpdate.producerName()).getIdProducer();

        movieMapper.updateMovieMapper(idDirector, idProducer,movie, movieUpdate);

        logger.info("update movie");
        return moviesRepository.save(movie);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public void delete(String title) {
        moviesRepository.deleteByTitle(title);
    }



}

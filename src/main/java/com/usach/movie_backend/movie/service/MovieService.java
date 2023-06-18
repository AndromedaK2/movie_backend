package com.usach.movie_backend.movie.service;

import com.usach.movie_backend.movie.domain.Movies;
import com.usach.movie_backend.movie.repository.IMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService implements IMoviesService<Movies>{
    @Autowired
    private IMoviesRepository iMoviesRepository;
    @Override
    public List<Movies> findAll() {
        return iMoviesRepository.findAll();
    }

    @Override
    public Optional<Movies> findByMovie(Integer idMovie) {
        return iMoviesRepository.findById(idMovie);
    }

    @Override
    public Movies create(Movies movies) {
        return iMoviesRepository.save(movies);
    }

    @Override
    public Movies update(Movies movies) {
        return iMoviesRepository.save(movies);
    }

    @Override
    public void delete(Integer idMovie) {
        iMoviesRepository.deleteById(idMovie);

    }
}

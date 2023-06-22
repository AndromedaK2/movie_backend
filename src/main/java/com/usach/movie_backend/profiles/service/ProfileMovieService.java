package com.usach.movie_backend.profiles.service;


import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.repository.IMoviesRepository;
import com.usach.movie_backend.movies.service.IMoviesService;
import com.usach.movie_backend.movies.service.dto.MovieUpdate;
import com.usach.movie_backend.profiles.domain.Profile;
import com.usach.movie_backend.profiles.domain.ProfileMovie;
import com.usach.movie_backend.profiles.repository.IProfileMovieRepository;
import com.usach.movie_backend.profiles.service.dto.ViewLaterMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileMovieService implements IProfileMovieService  {

    @Autowired
    private IProfileMovieRepository profileMovieRepository;
    @Autowired
    private IProfileService profileService;
    @Autowired
    private IMoviesService moviesService;
    @Autowired
    private IMoviesRepository moviesRepository;

    @Transactional(readOnly = true)
    public List<ProfileMovie> findAll() {
        return profileMovieRepository.findAll();
    }


    @Transactional(noRollbackFor = {BusinessException.class, ResponseStatusException.class})
    public ProfileMovie create(ViewLaterMovie viewLaterMovie) {

        Profile profile = profileService.find(viewLaterMovie.username(), viewLaterMovie.userEmail());
        Movie movie = moviesService.findByTitle(viewLaterMovie.movieTitle());

        Integer profileId = profile.getIdProfile();
        Integer movieId   = movie.getIdMovie();

        Optional<ProfileMovie> profileMovieBy = profileMovieRepository.findProfileMovieByIdProfileAndIdMovie(profileId,movieId);
        if(profileMovieBy.isPresent()){
           throw  new ResponseStatusException(HttpStatus.CONFLICT,"You have already marked as view later");
        }

        ProfileMovie profileMovie = new ProfileMovie();
        profileMovie.setIdProfile(profileId);
        profileMovie.setIdMovie(movieId);
        profileMovie.setViewLater(true);
        ProfileMovie profileMovieCreated = profileMovieRepository.save(profileMovie);

        movie.setViews(movie.getViews()+1);
        moviesRepository.save(movie);

        return profileMovieCreated;
    }


    @Transactional(noRollbackFor = {BusinessException.class, ResponseStatusException.class})
    public void delete(ViewLaterMovie viewLaterMovie) {
        Profile profile = profileService.find(viewLaterMovie.username(), viewLaterMovie.userEmail());
        Movie movie = moviesService.findByTitle(viewLaterMovie.movieTitle());

        Integer profileId = profile.getIdProfile();
        Integer movieId   = movie.getIdMovie();

        Optional<ProfileMovie> profileMovieBy = profileMovieRepository.findProfileMovieByIdProfileAndIdMovie(profileId,movieId);
        if(profileMovieBy.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.CONFLICT,"You have not marked as view later");
        }
        profileMovieRepository.deleteById(profileMovieBy.get().getIdProfileMovie());
        movie.setViews(movie.getViews()-1);
        moviesRepository.save(movie);
    }
}

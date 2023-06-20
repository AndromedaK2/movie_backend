package com.usach.movie_backend.profile.service;


import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.service.IMoviesService;
import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.domain.ProfileMovie;
import com.usach.movie_backend.profile.repository.IProfileMovieRepository;
import com.usach.movie_backend.profile.service.dtos.ViewLaterMovie;
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
        return profileMovieRepository.save(profileMovie);
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
    }
}

package com.usach.movie_backend.profile.service;


import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.movie.service.IMoviesService;
import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.domain.ProfileMovie;
import com.usach.movie_backend.profile.repository.IProfileMovieRepository;
import com.usach.movie_backend.profile.service.dtos.ViewLaterMovie;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<ProfileMovie> findAll() {
        return profileMovieRepository.findAll();
    }

    @Override
    public Optional<ProfileMovie> findByProfileMovie(Integer idProfileMovie) {
        return profileMovieRepository.findById(idProfileMovie);
    }

    @Transactional(noRollbackFor = {BusinessException.class, ResponseStatusException.class})
    public ProfileMovie create(ViewLaterMovie viewLaterMovie) {

        Profile profile = profileService.find(viewLaterMovie.username(), viewLaterMovie.userEmail());
        Integer profileId = profile.getIdProfile();

        ProfileMovie profileMovie = new ProfileMovie();
        profileMovie.setIdProfile(profileId);
        profileMovie.setViewLater(true);
        profileMovie.setIdMovie(1);
        return profileMovieRepository.save(profileMovie);
    }

    @Override
    public ProfileMovie update(ProfileMovie profileMovie) {
        return profileMovieRepository.save(profileMovie);
    }

    @Override
    public void delete(Integer idProfileMovie) {
        profileMovieRepository.deleteById(idProfileMovie);
    }
}

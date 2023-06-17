package com.usach.movie_backend.profile.service;


import com.usach.movie_backend.profile.domain.ProfileMovie;
import com.usach.movie_backend.profile.repository.IProfileMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileMovieService implements IProfileMovieService<ProfileMovie>  {

    @Autowired
    private IProfileMovieRepository iProfileMovieRepository;
    @Override
    public List<ProfileMovie> findAll() {
        return iProfileMovieRepository.findAll();
    }

    @Override
    public Optional<ProfileMovie> findByProfileMovie(Integer idProfileMovie) {
        return iProfileMovieRepository.findById(idProfileMovie);
    }

    @Override
    public ProfileMovie create(ProfileMovie profileMovie) {
        return iProfileMovieRepository.save(profileMovie);
    }

    @Override
    public ProfileMovie update(ProfileMovie profileMovie) {
        return iProfileMovieRepository.save(profileMovie);
    }

    @Override
    public void delete(Integer idProfileMovie) {
        iProfileMovieRepository.deleteById(idProfileMovie);
    }
}

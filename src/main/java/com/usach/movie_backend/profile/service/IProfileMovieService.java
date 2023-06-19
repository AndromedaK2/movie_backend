package com.usach.movie_backend.profile.service;


import com.usach.movie_backend.profile.domain.ProfileMovie;
import com.usach.movie_backend.profile.service.dtos.ViewLaterMovie;


import java.util.List;
import java.util.Optional;

public interface IProfileMovieService{

    List<ProfileMovie> findAll();

    Optional<ProfileMovie> findByProfileMovie(Integer idProfileMovie);

    ProfileMovie create(ViewLaterMovie profileMovie);

    ProfileMovie update(ProfileMovie profileMovie);

    void delete(Integer idProfileMovie);

}



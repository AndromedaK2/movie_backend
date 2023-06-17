package com.usach.movie_backend.profile.service;


import com.usach.movie_backend.profile.domain.ProfileMovie;


import java.util.List;
import java.util.Optional;

public interface IProfileMovieService<T>{

    List<ProfileMovie> findAll();

    Optional<ProfileMovie> findByProfileMovie(Integer idProfileMovie);

    ProfileMovie create(ProfileMovie profileMovie);

    ProfileMovie update(ProfileMovie profileMovie);

    void delete(Integer idProfileMovie);

}



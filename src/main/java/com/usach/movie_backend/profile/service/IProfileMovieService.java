package com.usach.movie_backend.profile.service;


import com.usach.movie_backend.profile.domain.ProfileMovie;
import com.usach.movie_backend.profile.service.dtos.ViewLaterMovie;


import java.util.List;
import java.util.Optional;

public interface IProfileMovieService{

    List<ProfileMovie> findAll();
    ProfileMovie create(ViewLaterMovie profileMovie);
    void delete(ViewLaterMovie viewLaterMovie);

}



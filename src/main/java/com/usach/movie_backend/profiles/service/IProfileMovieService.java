package com.usach.movie_backend.profiles.service;


import com.usach.movie_backend.profiles.domain.ProfileMovie;
import com.usach.movie_backend.profiles.service.dto.ViewLaterMovie;


import java.util.List;

public interface IProfileMovieService{

    List<ProfileMovie> findAll();
    ProfileMovie create(ViewLaterMovie profileMovie);
    void delete(ViewLaterMovie viewLaterMovie);

}



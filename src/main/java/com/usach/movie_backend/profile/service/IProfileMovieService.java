package com.usach.movie_backend.profile.service;


import com.usach.movie_backend.profile.domain.ProfileMovie;
import com.usach.movie_backend.profile.service.dto.ViewLaterMovie;


import java.util.List;

public interface IProfileMovieService{

    List<ProfileMovie> findAll();
    ProfileMovie create(ViewLaterMovie profileMovie);
    void delete(ViewLaterMovie viewLaterMovie);

}



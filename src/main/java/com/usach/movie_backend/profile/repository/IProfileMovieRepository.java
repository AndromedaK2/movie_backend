package com.usach.movie_backend.profile.repository;


import com.usach.movie_backend.profile.domain.ProfileMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfileMovieRepository extends JpaRepository<ProfileMovie,Integer> {


    List<ProfileMovie> findAll();
}

package com.usach.movie_backend.profile.service;


import com.usach.movie_backend.directors.domain.Director;
import com.usach.movie_backend.profile.domain.ProfileMovie;
import com.usach.movie_backend.profile.domain.ProfileSerie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProfileSerieService<T>
{
    List<ProfileSerie> findAll();

    Optional<ProfileSerie> findByProfileSerie(Integer idProfileSerie);

    ProfileSerie create(ProfileSerie profileSerie);

    ProfileSerie update(ProfileSerie profileSerie);

    void delete(Integer idProfileSerie);
}

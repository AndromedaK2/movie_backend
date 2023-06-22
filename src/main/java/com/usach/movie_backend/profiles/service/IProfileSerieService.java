package com.usach.movie_backend.profiles.service;

import com.usach.movie_backend.profiles.domain.ProfileSerie;
import com.usach.movie_backend.profiles.service.dto.ViewLaterSerie;

import java.util.List;

public interface IProfileSerieService
{
    List<ProfileSerie> findAll();
    ProfileSerie create(ViewLaterSerie viewLaterSerie);
    void delete(ViewLaterSerie viewLaterSerie);
}

package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.profile.domain.ProfileSerie;
import com.usach.movie_backend.profile.service.dto.ViewLaterSerie;

import java.util.List;

public interface IProfileSerieService
{
    List<ProfileSerie> findAll();
    ProfileSerie create(ViewLaterSerie viewLaterSerie);
    void delete(ViewLaterSerie viewLaterSerie);
}

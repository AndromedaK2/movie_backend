package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.service.dtos.ProfileCreate;
import com.usach.movie_backend.profile.service.dtos.ProfileUpdate;


import java.util.List;
import java.util.Optional;

public interface IProfileService {
    List<Profile>findAll();

    Profile find(String username, String userEmail);

    Profile create(ProfileCreate profileCreate, String userEmail );

    Profile update(ProfileUpdate profileUpdate, String userEmail);

    void delete(String username, String userEmail);
}
